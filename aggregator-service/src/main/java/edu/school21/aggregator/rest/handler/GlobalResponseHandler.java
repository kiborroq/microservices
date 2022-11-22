package edu.school21.aggregator.rest.handler;

import edu.school21.shared.handler.AbstractGlobalResponseHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = "edu.school21.aggregator.rest.controller")
public class GlobalResponseHandler extends AbstractGlobalResponseHandler {

	@Override
	protected String getTreatApiPrefix() {
		return "/information-management";
	}

}
