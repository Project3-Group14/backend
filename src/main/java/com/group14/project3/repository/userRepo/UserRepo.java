package com.group14.project3.repository.userRepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends MongoRepository<User, String> {
	public User findByUsername(String username);
	public User findByUserId(String userId);
}
