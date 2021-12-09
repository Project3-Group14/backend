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

import com.group14.project3.repository.commentRepo.Comment;

@RestController
@RestControllerAdvice

@RequestMapping(path = "/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/allComments")
    public List<Comment> getComments() {
        return ObjectMapperUtils.mapAll(commentService.getComments(), Comment.class);
    }

    @GetMapping(value = "/comment/{content}")
    public List<Comment> getCommentsByTitle(@PathVariable("content") String content) {
        return ObjectMapperUtils.mapAll(commentService.findByComment(content), Comment.class);
    }

    @GetMapping(value = "/userId/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable("userId") String userId) {
        return ObjectMapperUtils.mapAll(commentService.findByUserId(userId), Comment.class);
    }

    @GetMapping(value = "/postId/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable("postId") String postId) {
        return ObjectMapperUtils.mapAll(commentService.findByPostId(postId), Comment.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateComment(@RequestBody Comment content) {
        commentService.saveOrUpdateComment(ObjectMapperUtils.map(content, Comment.class));
        return new ResponseEntity("Comment added successfully", HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/delete/{commentId}")
    public ResponseEntity<?> deleteCommentByCommentId(@PathVariable String commentId) {
        commentService.deleteComment(commentService.findByCommentId(commentId).getCommentId());
        return new ResponseEntity("Comment deleted successfully", HttpStatus.OK);
    }

}