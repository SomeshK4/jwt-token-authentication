package com.recruvia.rs.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.recruvia.dto.user.UserDTO;

@Path("/user")
@Produces(value = {MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
public interface UserRS {
	
	/**
	 * Register User Endpoint
	 */
	@POST
	@Path("/register")
	void registerUser(UserDTO userDTO);
	
	@POST
	@Path("/changepassword")
	void changePassword();

}
