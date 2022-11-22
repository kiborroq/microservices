package edu.school21.covid.rest.mapper;

import edu.school21.covid.CovidReportOutDto;
import edu.school21.covid.cloud.CovidReportResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CovidMapper {

	public abstract CovidReportOutDto map(CovidReportResponse.CovidReport response);

}
