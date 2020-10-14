package com.recruvia.rs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.recruvia.dto.user.UserDTO;
import com.recruvia.rs.converter.user.UserConverter;
import com.recruvia.service.user.UserService;

@Component
public class UserRSImpl implements UserRS{
	
	@Autowired
	private UserService userService;
	
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public UserRSImpl(@Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bcryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void registerUser(UserDTO userDTO) {
		 String encryptedPasswd = bcryptPasswordEncoder.encode(userDTO.getPassword());
		 userDTO.setPassword(encryptedPasswd);
		 userService.saveUser(UserConverter.fromAcountDTOToAcount(userDTO));
	}

	@Override
	public void changePassword() {
		
	}

}
