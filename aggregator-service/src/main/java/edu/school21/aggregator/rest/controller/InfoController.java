package edu.school21.aggregator.rest.controller;

import edu.school21.aggregator.dto.FullInfoOutDto;
import edu.school21.aggregator.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@Autowired
	private InfoService infoService;

	/**
	 * Get info about country and COVID-19 statistics by country name
	 *
	 * @param name country name
	 * @return information
	 */
	@GetMapping("/information-management/countries/{name}")
	public FullInfoOutDto getInfoByCountryName(@PathVariable("name") String name) {
		return infoService.getCountryInformationByName(name);
	}

}
