package edu.school21.covid.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "covid-api", url = "${edu.school21.covid.third-party.api.url}")
public interface CovidApiClient {

	@GetMapping("/reports/total")
	String getReportByCountry(@RequestParam("iso") String iso);

}
