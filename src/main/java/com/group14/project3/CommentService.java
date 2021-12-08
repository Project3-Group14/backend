package com.group14.project3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.group14.project3.repository.commentRepo.Comment;
import com.group14.project3.repository.commentRepo.CommentRepo;

import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

public class CommentService {
    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
         this.commentRepo = commentRepo;
    }

    public Comment findByCommentComment(String comment) {
        return commentRepo.findCommentByComment(comment);
    }

    public List<Comment> getComments() {
        return commentRepo.findAll();
    }

    public Comment saveOrUpdateComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public void deleteComment(String id) {
        commentRepo.deleteById(id);
    }


}
