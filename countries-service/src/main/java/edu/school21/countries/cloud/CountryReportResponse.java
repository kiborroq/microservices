package edu.school21.countries.cloud;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
public class CountryReportResponse {

	String iso;
	String name;
	String nativeName;
	String capital;
	String region;
	String subregion;
	Integer numericCode;
	Long population;
	Long area;
	Set<String> domains;
	Set<String> callingCodes;
	List<Currency> currencies;
	List<Language> languages;

	@JsonCreator
	public CountryReportResponse(@JsonProperty("alpha3Code") String iso,
								 @JsonProperty("name") String name,
								 @JsonProperty("nativeName") String nativeName,
								 @JsonProperty("capital") String capital,
								 @JsonProperty("region") String region,
								 @JsonProperty("subregion") String subregion,
								 @JsonProperty("numericCode") Integer numericCode,
								 @JsonProperty("population") Long population,
								 @JsonProperty("area") Long area,
								 @JsonProperty("topLevelDomain") Set<String> domains,
								 @JsonProperty("callingCodes") Set<String> callingCodes,
								 @JsonProperty("currencies") List<Currency> currencies,
								 @JsonProperty("languages") List<Language> languages) {
		this.iso = iso;
		this.name = name;
		this.nativeName = nativeName;
		this.capital = capital;
		this.region = region;
		this.subregion = subregion;
		this.numericCode = numericCode;
		this.population = population;
		this.area = area;
		this.domains = domains;
		this.callingCodes = callingCodes;
		this.currencies = currencies;
		this.languages = languages;
	}

	@Value
	public static class Currency {
		String code;
		String name;
		String symbol;

		@JsonCreator
		public Currency(@JsonProperty("code") String code,
						@JsonProperty("name") String name,
						@JsonProperty("symbol") String symbol) {
			this.code = code;
			this.name = name;
			this.symbol = symbol;
		}
	}

	@Value
	public static class Language {
		String iso;
		String name;
		String nativeName;

		@JsonCreator
		public Language(@JsonProperty("iso639_1") String iso,
						@JsonProperty("name") String name,
						@JsonProperty("nativeName") String nativeName) {
			this.iso = iso;
			this.name = name;
			this.nativeName = nativeName;
		}
	}

}
