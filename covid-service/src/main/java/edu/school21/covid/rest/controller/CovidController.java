package edu.school21.covid.rest.controller;

import edu.school21.covid.CovidReportOutDto;
import edu.school21.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static edu.school21.covid.CovidCloud.PATH_REPORT_COUNTRY;

@RestController
public class CovidController {

	@Autowired
	private CovidService covidService;

	/**
	 * Get COVID-19 report for defined country
	 *
	 * @param iso country code
	 * @return report
	 */
	@GetMapping(PATH_REPORT_COUNTRY)
	public CovidReportOutDto getReportByCountry(@PathVariable("iso") String iso) {
		return covidService.getReportByCountry(iso);
	}

}
