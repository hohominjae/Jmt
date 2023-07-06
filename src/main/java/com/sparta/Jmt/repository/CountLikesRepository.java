package com.sparta.Jmt.repository;

import com.sparta.Jmt.entity.Post;

public interface CountLikesRepository {
    void plusLikeCount(Post post);

    void minusLikeCount(Post post);
}
