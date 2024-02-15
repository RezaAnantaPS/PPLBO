package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.repository.CommentJpaRepository;
import com.blog.vo.Comment;
import com.blog.vo.Post;

@Service
public class CommentService {
    
    @Autowired
    CommentJpaRepository commentJpaRepository;

    public boolean saveComment(Comment comment){
        Comment result = commentJpaRepository.save(comment);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public List<Comment> getCommentList(Long postId) {
        List<Comment> commentList = commentJpaRepository.findAllByPostIdOrderByRegDateDesc(postId);
        return commentList;
    }

    public Comment getComment(Long Id) {
        Comment comment = commentJpaRepository.findOneById(Id);
        return comment;
    }

    public boolean deleteComment(Long id) {
        Comment result = commentJpaRepository.findOneById(id);

        if (result == null) {
            return false;
        }

        commentJpaRepository.deleteById(id);
        return true;
    }

    public List<Comment> searchComments(Long postId, String query){
        List<Comment> commentList = commentJpaRepository.findByPostIdAndCommentContaining(postId, query);
        return commentList;
    }
}
