package com.recruvia.rs.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.recruvia.rs.configuration.RecruviaApplicationConfiguration;

/**
 * 
 * @author someshkumar
 *
 */
@SpringBootApplication
public class RecruviaBoot extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new RecruviaBoot().configure(new SpringApplicationBuilder(RecruviaApplicationConfiguration.class)).run(args);
	}

}
