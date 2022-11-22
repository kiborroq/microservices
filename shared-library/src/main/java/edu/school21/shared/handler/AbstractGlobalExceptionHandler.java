package edu.school21.shared.handler;

import edu.school21.shared.exception.MicroservicesRuntimeException;
import edu.school21.shared.model.ResponseWrapper;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class AbstractGlobalExceptionHandler {

	protected abstract void log(Exception e);

	@ExceptionHandler(value = MicroservicesRuntimeException.class)
	public ResponseEntity<ResponseWrapper<Void>> microservicesRuntimeException(MicroservicesRuntimeException e) {
		log(e);

		HttpStatus status = e.getStatus();
		return new ResponseEntity<>(new ResponseWrapper<>(null, status.value(), e.getMessage()), status);
	}

	@ExceptionHandler(value = FeignException.class)
	public ResponseEntity<ResponseWrapper<Void>> feignException(FeignException e) {
		e.printStackTrace();

		HttpStatus status = HttpStatus.valueOf(e.status());
		return new ResponseEntity<>(new ResponseWrapper<>(null, e.status(), status.getReasonPhrase()), status);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResponseWrapper<Void>> microservicesRuntimeException(Exception e) {
		log(e);

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<>(new ResponseWrapper<>(null, status.value(), e.getMessage()), status);
	}

}
