package edu.school21.countries.rest.handler;

import edu.school21.shared.handler.AbstractGlobalResponseHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static edu.school21.countries.CountriesCloud.PATH_PREFIX;

@ControllerAdvice
public class GlobalResponseHandler extends AbstractGlobalResponseHandler {

	@Override
	protected String getTreatApiPrefix() {
		return PATH_PREFIX;
	}

}
