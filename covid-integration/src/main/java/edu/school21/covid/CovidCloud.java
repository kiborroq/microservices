package edu.school21.covid;

import edu.school21.shared.model.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CovidCloud {

	String PATH_PREFIX = "/covid-management";
	String PATH_REPORT_COUNTRY = PATH_PREFIX + "/countries/{iso}";

	/**
	 * Get COVID-19 report for defined country
	 *
	 * @param iso country code
	 * @return report
	 */
	@GetMapping(PATH_REPORT_COUNTRY)
	ResponseWrapper<CovidReportOutDto> getReportByCountry(@PathVariable("iso") String iso);

}
