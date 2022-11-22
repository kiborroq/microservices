package edu.school21.shared.exception;

import org.springframework.http.HttpStatus;

public class MicroservicesInternalServerException extends MicroservicesRuntimeException {

	public MicroservicesInternalServerException(String message) {
		super(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public MicroservicesInternalServerException(String message, Throwable cause) {
		super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
