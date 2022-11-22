package edu.school21.countries;

import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
public class CountryReportOutDto {

	/** ISO code */
	String iso;
	/** Full name */
	String name;
	/** Native name */
	String nativeName;
	/** Capital city */
	String capital;
	/** Region */
	String region;
	/** Subregion */
	String subregion;
	/** Numeric code */
	Integer numericCode;
	/** Population */
	Long population;
	/** Area, m*m */
	Long area;
	/** Top level domains */
	Set<String> domains;
	/** Calling codes (area codes) */
	Set<String> callingCodes;
	/** Currencies */
	List<CurrencyDto> currencies;
	/** Official languages */
	List<LanguageDto> languages;

	@Value
	public static class CurrencyDto {
		String code;
		String name;
		String symbol;
	}

	@Value
	public static class LanguageDto {
		String iso;
		String name;
		String nativeName;
	}

}
