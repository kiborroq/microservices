package edu.school21.countries.rest.mapper;

import edu.school21.countries.CountryReportOutDto;
import edu.school21.countries.cloud.CountryReportResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CountriesMapper {

	public abstract CountryReportOutDto map(CountryReportResponse response);

	public abstract CountryReportOutDto.CurrencyDto map(CountryReportResponse.Currency currency);

	public abstract CountryReportOutDto.LanguageDto map(CountryReportResponse.Language currency);

}
