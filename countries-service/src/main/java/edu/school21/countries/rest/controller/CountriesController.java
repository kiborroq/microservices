package edu.school21.countries.rest.controller;

import edu.school21.countries.CountryReportOutDto;
import edu.school21.countries.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static edu.school21.countries.CountriesCloud.PATH_REPORT_COUNTRY;

@RestController
public class CountriesController {

	@Autowired
	private CountriesService countriesService;

	/**
	 * Get country info by name
	 *
	 * @param name country name
	 * @return info
	 */
	@GetMapping(PATH_REPORT_COUNTRY)
	public CountryReportOutDto getReportByName(@PathVariable("name") String name) {
		return countriesService.getReportByName(name);
	}

}
