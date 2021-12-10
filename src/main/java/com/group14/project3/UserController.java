package com.group14.project3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.group14.project3.repository.userRepo.User;

@RestController
@RestControllerAdvice

@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/allUsers")
    public List<User> getUsers() {
        return ObjectMapperUtils.mapAll(userService.getUsers(), User.class);
    }

    @GetMapping(value = "/username/{username}")
    public User getUsersByUsername(@PathVariable("username") String username) {
        return ObjectMapperUtils.map(userService.findByUserUsername(username), User.class);
    }

    @GetMapping(value = "/userId/{userId}")
    public User getUsersByUserId(@PathVariable("userId") String userId) {
        return ObjectMapperUtils.map(userService.findByUserId(userId), User.class);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody User user) {
        userService.saveOrUpdateUser(ObjectMapperUtils.map(user, User.class));
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }   

    @PutMapping(value = "/update/userId={userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String userId, @RequestBody User userInformation) {
        userService.updateUser(ObjectMapperUtils.map(userService.findByUserId(userId), User.class), userInformation);
        return new ResponseEntity("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUser(userService.findByUserUsername(username).getUserId());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable String userId) {
        userService.deleteUser(userService.findByUserId(userId).getUserId());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

}