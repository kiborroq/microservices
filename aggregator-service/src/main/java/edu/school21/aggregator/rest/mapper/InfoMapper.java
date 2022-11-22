package edu.school21.aggregator.rest.mapper;

import edu.school21.aggregator.dto.CountryInfoOutDto;
import edu.school21.aggregator.dto.CovidInfoOutDto;
import edu.school21.countries.CountryReportOutDto;
import edu.school21.covid.CovidReportOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InfoMapper {

	public abstract CountryInfoOutDto.CurrencyDto map(CountryReportOutDto.CurrencyDto dto);

	public abstract CountryInfoOutDto.LanguageDto map(CountryReportOutDto.LanguageDto dto);

	public abstract CountryInfoOutDto map(CountryReportOutDto dto);

	public abstract CovidInfoOutDto map(CovidReportOutDto dto);

}
