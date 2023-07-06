package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.LikesRequestDto;
import com.sparta.Jmt.entity.Likes;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.repository.CountLikesRepository;
import com.sparta.Jmt.repository.LikesRepository;
import com.sparta.Jmt.repository.PostRepository;
import com.sparta.Jmt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void insert(LikesRequestDto likesRequestDto) throws Exception {
        User user = userRepository.findById(likesRequestDto.getUserId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        Post post = postRepository.findById(likesRequestDto.getPostId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        //같은 유저가 같은 게시글에 좋아요를 중복해서 누르지 못하게 하기
        if (likesRepository.findByUserAndPost(user, post).isPresent()){
            throw new Exception();
        }

        Likes likes = Likes.builder()
                .post(post)
                .user(user)
                .build();

        likesRepository.save(likes);
        likes.plusLikesCount();
    }

    @Transactional
    public void delete(LikesRequestDto likesRequestDto) throws Exception {
        User user = userRepository.findById(likesRequestDto.getUserId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Post post = postRepository.findById(likesRequestDto.getPostId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Likes likes = likesRepository.findByUserAndPost(user, post)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        likesRepository.delete(likes);
        likes.minusLikesCount();
    }
}
