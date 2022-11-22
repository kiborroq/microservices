package edu.school21.aggregator.config;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "edu.school21.aggregator.cloud")
@EnableHystrix
public class CloudConfig {
}
