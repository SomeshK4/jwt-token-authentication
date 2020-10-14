package com.recruvia.dao.user;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recruvia.model.user.User;

/**
 * 
 * @author someshkumar
 *
 */
public interface UserRepository extends  MongoRepository<User, String>{
   Optional<User> findByEmail(String email);
}
