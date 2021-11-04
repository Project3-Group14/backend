package com.group14.project3.repository.postRepo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Post {
	
	@Id
	public String postId;
	
	public String userId;
	public String postTitle;
	public String postDesc;
	
	public Post() {}
	
	public Post(String postId, String userId, String postTitle, String postDesc) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.postDesc = postDesc;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", postTitle=" + postTitle + ", postDesc=" + postDesc
				+ "]";
	}
	
	
}
