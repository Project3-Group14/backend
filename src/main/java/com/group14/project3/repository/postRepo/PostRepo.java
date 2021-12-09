package com.group14.project3.repository.postRepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PostRepo extends MongoRepository<Post, String>{
	public List<Post> findAllByPostTitle(String title);
	public List<Post> findAllByUserId(String userId);
	public Post findByPostId(String postId);
}
