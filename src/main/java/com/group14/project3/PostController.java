package com.group14.project3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.group14.project3.repository.postRepo.Post;

@RestController
@RestControllerAdvice

@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/allPosts")
    public List<Post> getPosts() {
        return ObjectMapperUtils.mapAll(postService.getPosts(), Post.class);
    }

    @GetMapping(value = "/title/{title}")
    public Post getPostsByTitle(@PathVariable("title") String title) {
        return ObjectMapperUtils.map(postService.findByPostTitle(title), Post.class);
    }

    @GetMapping(value = "/userId/{userId}")
    public List<Post> getPostsByUserId(@PathVariable("userId") String userId) {
        return ObjectMapperUtils.mapAll(postService.findByUserId(userId), Post.class);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdatePost(@RequestBody Post post) {
        postService.saveOrUpdatePost(ObjectMapperUtils.map(post, Post.class));
        return new ResponseEntity("Post added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{title}")
    public ResponseEntity<?> deletePostByTitle(@PathVariable String title) {
        postService.deletePost(postService.findByPostTitle(title).getPostId());
        return new ResponseEntity("Post deleted successfully", HttpStatus.OK);
    }
    

}