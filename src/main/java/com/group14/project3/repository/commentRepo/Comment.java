package com.group14.project3.repository.commentRepo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Comment {
	@Id
	public String commentId;
	
	public String userId;
	public String comment;
	
	public Comment() {}

	public Comment(String commentId, String userId, String comment) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.comment = comment;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", comment=" + comment + "]";
	}
	
}
