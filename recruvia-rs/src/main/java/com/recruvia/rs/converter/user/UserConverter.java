package com.recruvia.rs.converter.user;

import com.recruvia.dto.user.UserDTO;
import com.recruvia.model.user.User;

/**
 * @author ad
 *
 */
public final class UserConverter {
	
	private UserConverter () {}

	
	/**
	 * Convert UserDTO to user.
	 * 
	 * @param accountDTO
	 * @return AcountDTO
	 */
	public static User fromAcountDTOToAcount (UserDTO userDTO) {
		return User.builder()
				.email(userDTO.getEmail())
				.password(userDTO.getPassword())
				.firstName(userDTO.getFirstName())
				.lastName(userDTO.getLastName())
				.phone(userDTO.getPhone())
				.company(userDTO.getCompany())
				.build();
	}
	
	
}
