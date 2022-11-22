package edu.school21.covid.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.covid.CovidReportOutDto;
import edu.school21.covid.cloud.CovidApiClient;
import edu.school21.covid.cloud.CovidReportResponse;
import edu.school21.covid.rest.mapper.CovidMapper;
import edu.school21.shared.exception.MicroservicesInternalServerException;
import edu.school21.shared.exception.MicroservicesNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CovidService {

	@Autowired
	private CovidApiClient covidApiClient;
	@Autowired
	private CovidMapper covidMapper;
	@Autowired
	private ObjectMapper objectMapper;

	public CovidReportOutDto getReportByCountry(String iso) {
		String json = covidApiClient.getReportByCountry(iso);
		Assert.notNull(json, "Response from covid-api is null");

		CovidReportResponse response;
		try {
			response = objectMapper.readValue(json, CovidReportResponse.class);
		} catch (JsonProcessingException e) {
			throw new MicroservicesNotfoundException("Not found");
		}

		if (response.getMessage() != null) {
			throw new MicroservicesInternalServerException(response.getMessage());
		}

		Assert.notNull(response.getData(), "Covid report from covid-api is null");

		return covidMapper.map(response.getData());
	}

}
