package edu.school21.aggregator.cloud;

import edu.school21.covid.CovidCloud;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "covid")
public interface CovidClient extends CovidCloud {
}
