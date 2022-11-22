package edu.school21.aggregator.rest.handler;

import edu.school21.shared.handler.AbstractGlobalExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler extends AbstractGlobalExceptionHandler {

	@Override
	protected void log(Exception e) {
		e.printStackTrace();
	}

}
