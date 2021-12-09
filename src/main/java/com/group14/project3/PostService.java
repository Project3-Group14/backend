package com.group14.project3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.group14.project3.repository.postRepo.Post;
import com.group14.project3.repository.postRepo.PostRepo;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> findByPostTitle(String title) {
        return postRepo.findAllByPostTitle(title);
    }

    public List<Post> findByUserId(String userId) {
        return postRepo.findAllByUserId(userId);
    }

    public Post findByPostId(String postId) {
        return postRepo.findByPostId(postId);
    }

    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    public Post saveOrUpdatePost(Post post) {
        return postRepo.save(post);
    }

    public void deletePost(String id) {
        postRepo.deleteById(id);
    }


}