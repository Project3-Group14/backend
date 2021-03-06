package com.group14.project3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.group14.project3.repository.userRepo.User;
import com.group14.project3.repository.userRepo.UserRepo;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findByUserUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User findByUserId(String userId) {
        return userRepo.findByUserId(userId);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User saveOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user, User userInformation) {
        user.setId(userInformation.getUserId());
        user.setUsername(userInformation.getUsername());
        user.setPassword(userInformation.getPassword());

        return userRepo.save(user);
    }

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }


}