package com.recruvia.service.user;

import java.util.Optional;

import com.recruvia.model.user.User;

public interface UserService {
	Optional<User> getUserByEmail(String email);
	void saveUser(User user);
}