package com.blog.repository;

import org.springframework.stereotype.Repository;

import com.blog.vo.Comment;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, Serializable> {
    @Query("SELECT c FROM Comment c WHERE c.postId = :postId ORDER BY c.regDate DESC")
    List<Comment> findAllByPostIdOrderByRegDateDesc(Long postId);

    List<Comment> findByPostIdAndCommentContaining(Long postId, String query);

    Comment findOneById(Long id);
}
