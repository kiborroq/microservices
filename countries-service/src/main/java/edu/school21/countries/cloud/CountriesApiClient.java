package edu.school21.countries.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "countries-api", url = "${edu.school21.countries.third-party.api.url}")
public interface CountriesApiClient {

	@GetMapping("/name/{name}")
	String getReportByName(@PathVariable("name") String name);

}
