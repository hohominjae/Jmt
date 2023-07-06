package com.sparta.Jmt.repository;

import com.sparta.Jmt.entity.Comment;
import com.sparta.Jmt.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();
}
