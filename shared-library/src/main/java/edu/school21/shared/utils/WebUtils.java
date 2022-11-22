package edu.school21.shared.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.shared.exception.MicroservicesInternalServerException;
import edu.school21.shared.exception.MicroservicesRuntimeException;
import edu.school21.shared.model.ResponseWrapper;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebUtils {

	private static final String MESSAGE = "Error during feign request";
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static <T> T getResponseBody(ResponseWrapper<T> wrapper) {
		if (wrapper.getStatus() == null) {
			throw new MicroservicesInternalServerException(wrapper.getError());
		}

		if (wrapper.getStatus() != HttpStatus.OK.value()) {
			throw new MicroservicesRuntimeException(wrapper.getError(), HttpStatus.valueOf(wrapper.getStatus()));
		}

		return wrapper.getBody();
	}

	public static <T> T doFeignRequest(Callable<ResponseWrapper<T>> request) {
		try {
			ResponseWrapper<T> response = request.call();
			return WebUtils.getResponseBody(response);
		} catch (FeignException e) {
			ResponseWrapper<Void> failResponse = extractFailResponse(e);
			throw new MicroservicesRuntimeException(failResponse.getError(), HttpStatus.valueOf(failResponse.getStatus()));
		} catch (Exception e) {
			throw new MicroservicesInternalServerException(MESSAGE, e);
		}
	}

	private static ResponseWrapper<Void> extractFailResponse(FeignException e) {
		byte [] json = e.responseBody()
				.map(ByteBuffer::array)
				.orElseThrow(() -> new MicroservicesInternalServerException(MESSAGE, e));

		try {
			ResponseWrapper<Void> response = OBJECT_MAPPER.readValue(json, new TypeReference<ResponseWrapper<Void>>(){});
			return response.getStatus() != null ? response : new ResponseWrapper<>(null, e.status(), response.getError());
		} catch (IOException exception) {
			throw new MicroservicesInternalServerException(MESSAGE, exception);
		}
	}
}
