package com.recruvia.rs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.recruvia.rs.provider.ObjectMapperProvider;
import com.recruvia.rs.refreshtoken.RefreshTokenRS;
import com.recruvia.rs.user.UserRS;

/**
 * 
 * @author SomeshKumar
 *
 */
@Component
@ApplicationPath("/api/v1")
public class JerseyConfiguration extends ResourceConfig
{
	public JerseyConfiguration() {
		// register endpoints
		//packages("com.recruvia.rs"); //not compatible with spring boot and jersey
		this.registerEndpoints();
		register(ObjectMapperProvider.class);
	}
	
	/**
	 * Register REST Endpoints 
	 */
	private void registerEndpoints() {
		register(RefreshTokenRS.class);
		register(UserRS.class);
	}
}

