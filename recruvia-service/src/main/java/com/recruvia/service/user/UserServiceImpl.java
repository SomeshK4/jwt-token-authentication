package com.recruvia.service.user;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruvia.dao.user.UserRepository;
import com.recruvia.model.user.User;

@Service
public class UserServiceImpl implements UserService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUserByEmail(String email) {
		logger.info("UserServiceImpl#getUserByEmail(String email) called with args {} ", email);
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}
