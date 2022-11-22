package edu.school21.shared.exception;

import org.springframework.http.HttpStatus;

public class MicroservicesNotfoundException extends MicroservicesRuntimeException {

	public MicroservicesNotfoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}

	public MicroservicesNotfoundException(String message, Throwable cause) {
		super(message, cause, HttpStatus.NOT_FOUND);
	}

}
