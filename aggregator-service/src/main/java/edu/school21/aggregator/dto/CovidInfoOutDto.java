package edu.school21.aggregator.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class CovidInfoOutDto {

	/** Last date time report update */
	LocalDateTime dateTimeLastUpdate;
	/** Total confirm */
	Integer confirmedTotal;
	/** Confirm cases from {@link #dateTimeLastUpdate} */
	Integer confirmedDiff;
	/** Total deaths */
	Integer deathsTotal;
	/** Death cases from {@link #dateTimeLastUpdate} */
	Integer deathsDiff;
	/** Total recovered */
	Integer recoveredTotal;
	/** Active cases from {@link #dateTimeLastUpdate} */
	Integer recoveredDiff;
	/** Total active */
	Integer activeTotal;
	/** Active cases from {@link #dateTimeLastUpdate} */
	Integer activeDiff;
	/** Fatality rate */
	BigDecimal fatalityRate;

}
