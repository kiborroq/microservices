package edu.school21.countries.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.countries.CountryReportOutDto;
import edu.school21.countries.cloud.CountriesApiClient;
import edu.school21.countries.cloud.CountryReportResponse;
import edu.school21.countries.cloud.FailResponse;
import edu.school21.countries.rest.mapper.CountriesMapper;
import edu.school21.shared.exception.MicroservicesInternalServerException;
import edu.school21.shared.exception.MicroservicesNotfoundException;
import edu.school21.shared.exception.MicroservicesRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CountriesService {

	@Autowired
	private CountriesApiClient countriesApiClient;
	@Autowired
	private CountriesMapper countriesMapper;
	@Autowired
	private ObjectMapper objectMapper;

	public CountryReportOutDto getReportByName(String name) {
		String json = countriesApiClient.getReportByName(name);
		Assert.notNull(json, "Response from countries-api is null");

		try {
			List<CountryReportResponse> reports = objectMapper.readValue(json, new TypeReference<List<CountryReportResponse>>() {});
			if (reports.size() != 1) {
				throw new MicroservicesNotfoundException("Not found");
			}

			return countriesMapper.map(reports.get(0));
		} catch (JsonProcessingException e) {
			try {
				FailResponse fail = objectMapper.readValue(json, FailResponse.class);
				throw new MicroservicesRuntimeException(fail.getMessage(), HttpStatus.valueOf(fail.getStatus()));
			} catch (JsonProcessingException ex) {
				throw new MicroservicesInternalServerException("Error during countries-api calling");
			}
		}
	}

}
