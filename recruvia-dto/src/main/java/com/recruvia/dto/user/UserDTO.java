package com.recruvia.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String company;
	private String phone;

}
