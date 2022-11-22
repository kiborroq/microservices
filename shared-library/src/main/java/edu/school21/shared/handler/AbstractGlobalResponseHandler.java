package edu.school21.shared.handler;

import edu.school21.shared.model.ResponseWrapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public abstract class AbstractGlobalResponseHandler implements ResponseBodyAdvice {

	protected abstract String getTreatApiPrefix();

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
	}

	@Override
	public Object beforeBodyWrite(Object body,
								  MethodParameter returnType,
								  MediaType selectedContentType,
								  Class selectedConverterType,
								  ServerHttpRequest request,
								  ServerHttpResponse response) {
		if (isSuccess((ServletServerHttpResponse) response)
				&& isNotResponseBody(body)
				&& request.getURI().getPath().startsWith(getTreatApiPrefix())) {
			return new ResponseWrapper<>(body, HttpStatus.OK.value(), null);
		}

		return body;
	}

	private boolean isSuccess(ServletServerHttpResponse response) {
		int status = response.getServletResponse().getStatus();
		return status == 0 || status == HttpStatus.OK.value();
	}

	private boolean isNotResponseBody(Object body) {
		return body != null && !ResponseWrapper.class.isAssignableFrom(body.getClass());
	}

}
