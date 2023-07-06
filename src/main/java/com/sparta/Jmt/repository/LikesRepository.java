package com.sparta.Jmt.repository;

import com.sparta.Jmt.entity.Likes;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserAndPost(User user, Post post);


}
