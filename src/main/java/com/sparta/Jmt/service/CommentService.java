package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.*;
import com.sparta.Jmt.entity.Comment;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.repository.CommentRepository;
import com.sparta.Jmt.repository.PostRepository;
import com.sparta.Jmt.security.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    public void createComment(UserDetailsImpl userDetails, CommentRequestDto commentRequestDto) {
        Post post = postRepository.findById(commentRequestDto.getPostId()).orElseThrow(()->new RuntimeException());

        Comment comment = new Comment(userDetails.getUser(),post,commentRequestDto.getContent());

        commentRepository.save(comment);
    }

    public CommentResponseDto getComment(Long CommentId) {
        Comment comment = findComment(CommentId);

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);

        return commentResponseDto;
    }

    public CommentListResponseDto getComments() {
        List<CommentResponseDto> CommentList = commentRepository.findAllByOrderByModifiedAtDesc()
                .stream().map(CommentResponseDto::new).collect(Collectors.toList());

        return new CommentListResponseDto(CommentList);
    }

    @Transactional
    public void update(User user, Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = findComment(commentId);

        if (!comment.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        comment.update(commentRequestDto);
    }

    public void delet(User user, Long commentId) {
        Comment comment = findComment(commentId);

        if (!comment.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        commentRepository.delete(comment);
    }

    private Comment findComment(Long CommentId) {
        return commentRepository.findById(CommentId).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글이 존재하지 않습니다."));
    }


}
