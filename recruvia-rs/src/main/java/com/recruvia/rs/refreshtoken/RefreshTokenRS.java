package com.recruvia.rs.refreshtoken;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.recruvia.security.model.JwtToken;

/**
 * 
 * 
 * @author someshkumar
 *
 */
@Path("/refreshtoken")
@Produces(value = { MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_JSON })
public interface RefreshTokenRS{

	@GET
	public JwtToken refreshToken(@Context HttpServletRequest request)
			throws IOException, ServletException;

}
