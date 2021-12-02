package com.groupO.project2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.groupO.project2.repository.itemRepo.Item;
import com.groupO.project2.repository.itemRepo.ItemRepository;
import com.groupO.project2.repository.userRepo.User;
import com.groupO.project2.repository.userRepo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

  @Autowired
  private UserRepository repository;

  @Autowired

  public static void main(String[] args){
    SpringApplication.run(AccessingDataMongodbApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //epository.deleteAll();
	//repository.save(new User("test", "test", "test@gmail.com"));
	//repository.save(new User("admin", "admin", "admin@gmail.com"));
  }
}
