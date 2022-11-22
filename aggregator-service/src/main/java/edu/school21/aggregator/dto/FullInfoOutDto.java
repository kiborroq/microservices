package edu.school21.aggregator.dto;

import lombok.Value;

@Value
public class FullInfoOutDto {

	CountryInfoOutDto country;
	CovidInfoOutDto covid;

}
