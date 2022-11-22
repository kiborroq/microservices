package edu.school21.countries;

import edu.school21.shared.model.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CountriesCloud {

	String PATH_PREFIX = "/countries-management";
	String PATH_REPORT_COUNTRY = PATH_PREFIX + "/countries/{name}";

	/**
	 * Get country info by name
	 *
	 * @param name country name
	 * @return info
	 */
	@GetMapping(PATH_REPORT_COUNTRY)
	ResponseWrapper<CountryReportOutDto> getReportByName(@PathVariable("name") String name);

}
