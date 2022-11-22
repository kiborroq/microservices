package edu.school21.covid.rest.handler;

import edu.school21.shared.handler.AbstractGlobalResponseHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static edu.school21.covid.CovidCloud.PATH_PREFIX;

@ControllerAdvice(basePackages = "edu.school21.covid.rest.controller")
public class GlobalResponseHandler extends AbstractGlobalResponseHandler {

	@Override
	protected String getTreatApiPrefix() {
		return PATH_PREFIX;
	}

}
