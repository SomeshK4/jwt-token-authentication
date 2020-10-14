package com.recruvia.service.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import com.recruvia.dao.configuration.DatabaseConfiguration;

@Configuration
@ComponentScan(basePackages = {
		"com.recruvia.service" }, excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.recruvia.service.configuration"))
@Import(value = { DatabaseConfiguration.class })
public class ServiceConfiguration {

}
