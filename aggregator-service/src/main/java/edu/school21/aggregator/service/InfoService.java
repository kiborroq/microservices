package edu.school21.aggregator.service;

import edu.school21.aggregator.cloud.CountriesClient;
import edu.school21.aggregator.cloud.CovidClient;
import edu.school21.aggregator.dto.FullInfoOutDto;
import edu.school21.aggregator.rest.mapper.InfoMapper;
import edu.school21.countries.CountryReportOutDto;
import edu.school21.covid.CovidReportOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static edu.school21.shared.utils.WebUtils.doFeignRequest;

@Service
public class InfoService {

	@Autowired
	private CovidClient covidClient;
	@Autowired
	private CountriesClient countriesClient;
	@Autowired
	private InfoMapper infoMapper;

	public FullInfoOutDto getCountryInformationByName(String name) {
		CountryReportOutDto countryReport = doFeignRequest(() -> countriesClient.getReportByName(name));
		CovidReportOutDto covidReport = doFeignRequest(() -> covidClient.getReportByCountry(countryReport.getIso()));

		return new FullInfoOutDto(infoMapper.map(countryReport), infoMapper.map(covidReport));
	}

}
