package edu.school21.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	@Value("${edu.school21.gateway.aggregator.app.name}")
	private String aggregatorAppName;
	@Value("${edu.school21.gateway.aggregator.path}")
	private String aggregatorPath;

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("aggregator-service", route -> route.path(aggregatorPath).uri("lb://" + aggregatorAppName))
				.build();
	}

}
