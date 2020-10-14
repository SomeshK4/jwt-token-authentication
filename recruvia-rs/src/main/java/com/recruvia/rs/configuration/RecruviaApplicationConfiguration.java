/**
 * 
 */
package com.recruvia.rs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import com.recruvia.security.configuration.SecurityConfiguration;

/**
 * @author ad
 *
 */
@Configuration
@Import({SecurityConfiguration.class})
@ComponentScan(basePackages = { "com.recruvia.rs" }, excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.recruvia.rs.configuration"))
public class RecruviaApplicationConfiguration {
	

}
