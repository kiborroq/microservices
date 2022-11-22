package edu.school21.shared.exception;

import org.springframework.http.HttpStatus;

public class MicroservicesRuntimeException extends RuntimeException {

	private final HttpStatus status;

	public MicroservicesRuntimeException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public MicroservicesRuntimeException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
