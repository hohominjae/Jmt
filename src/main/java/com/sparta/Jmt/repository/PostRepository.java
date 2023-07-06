package com.sparta.Jmt.repository;


import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

       List<Post> findAllByOrderByModifiedAtDesc();

       List<Post> findByPostCategory(PostCategory postCategory);

       List<Post> findByPostTitle(String postTitle);
}
