package edu.school21.covid.cloud;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Value;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class CovidReportResponse {

	CovidReport data;
	@Nullable
	String message;

	public CovidReportResponse(@JsonProperty("data") CovidReport data, @JsonProperty("message") @Nullable String message) {
		this.data = data;
		this.message = message;
	}

	@Value
	public static class CovidReport {

		LocalDateTime dateTimeLastUpdate;
		Integer confirmedTotal;
		Integer confirmedDiff;
		Integer deathsTotal;
		Integer deathsDiff;
		Integer recoveredTotal;
		Integer recoveredDiff;
		Integer activeTotal;
		Integer activeDiff;
		BigDecimal fatalityRate;

		@JsonCreator
		public CovidReport(@JsonProperty("last_update") @JsonDeserialize(using = DateTimeDeserializer.class) LocalDateTime dateTimeLastUpdate,
						   @JsonProperty("confirmed") Integer confirmedTotal,
						   @JsonProperty("confirmed_diff") Integer confirmedDiff,
						   @JsonProperty("deaths") Integer deathsTotal,
						   @JsonProperty("deaths_diff") Integer deathsDiff,
						   @JsonProperty("recovered") Integer recoveredTotal,
						   @JsonProperty("recovered_diff") Integer recoveredDiff,
						   @JsonProperty("active") Integer activeTotal,
						   @JsonProperty("active_diff") Integer activeDiff,
						   @JsonProperty("fatality_rate") BigDecimal fatalityRate) {
			this.dateTimeLastUpdate = dateTimeLastUpdate;
			this.confirmedTotal = confirmedTotal;
			this.confirmedDiff = confirmedDiff;
			this.deathsTotal = deathsTotal;
			this.deathsDiff = deathsDiff;
			this.recoveredTotal = recoveredTotal;
			this.recoveredDiff = recoveredDiff;
			this.activeTotal = activeTotal;
			this.activeDiff = activeDiff;
			this.fatalityRate = fatalityRate;
		}
	}

}
