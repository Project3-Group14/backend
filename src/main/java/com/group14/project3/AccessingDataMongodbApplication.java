package com.group14.project3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.group14.project3.repository.commentRepo.CommentRepo;
import com.group14.project3.repository.commentRepo.Comment;
import com.group14.project3.repository.postRepo.PostRepo;
import com.group14.project3.repository.postRepo.Post;
import com.group14.project3.repository.userRepo.UserRepo;
import com.group14.project3.repository.userRepo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

  @Autowired
  private UserRepo repository;

  @Autowired

  public static void main(String[] args){
    SpringApplication.run(AccessingDataMongodbApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
	repository.save(new User("test", "test"));
  }
}
