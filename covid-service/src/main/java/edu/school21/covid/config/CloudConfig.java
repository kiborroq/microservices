package edu.school21.covid.config;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
@EnableFeignClients(basePackages = "edu.school21.covid.cloud")
public class CloudConfig {
}
