package com.blog.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.vo.Post;

import java.io.Serializable;
import java.util.List;


@Repository("PostJpaRepository")
public interface PostJpaRepository extends JpaRepository<Post, Serializable>{
    Post findOneById(Long id);
    List<Post> findAllByOrderByUpdtDateDesc();
    List<Post> findAllByOrderByUpdtDateAsc();
    List<Post> findByTitleContainingOrderByUpdtDateDesc(String query);
    List<Post> findByContentContainingOrderByUpdtDateDesc(String query);
}
