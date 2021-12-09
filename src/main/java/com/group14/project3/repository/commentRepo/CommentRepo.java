package com.group14.project3.repository.commentRepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepo extends MongoRepository<Comment, String>{
	public Comment findByCommentId(String commentId);
	public List<Comment> findAllByComment(String comment);
	public List<Comment> findAllByUserId(String userId);
	public List<Comment> findAllByPostId(String postId);
}
