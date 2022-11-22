package edu.school21.aggregator.cloud;

import edu.school21.countries.CountriesCloud;
import edu.school21.covid.CovidCloud;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "countries")
public interface CountriesClient extends CountriesCloud {
}
