package com.group14.project3.repository.commentRepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepo extends MongoRepository<Comment, String>{
	public Comment findCommentByComment(String comment);
}
