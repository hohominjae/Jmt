package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.*;
import com.sparta.Jmt.security.UserDetailsImpl;
import com.sparta.Jmt.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jmt")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //댓글 작성
    @PostMapping("/comment")
    public ResponseEntity<MsgResponseDto> createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.createComment(userDetails ,commentRequestDto);
        return ResponseEntity.ok().body(new MsgResponseDto("댓글 생성 성공", HttpStatus.OK.value()));
    }

    @GetMapping("/comment/{CommentId}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long CommentId) {
        CommentResponseDto result = commentService.getComment(CommentId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/comments")
    public ResponseEntity<CommentListResponseDto> getComments() {
        CommentListResponseDto result = commentService.getComments();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/comment/{CommentId}")
    public ResponseEntity<MsgResponseDto> update(@AuthenticationPrincipal UserDetailsImpl userDetails,@PathVariable Long CommentId ,@RequestBody CommentRequestDto commentRequestDto) {
        commentService.update(userDetails.getUser(),CommentId,commentRequestDto);
        return ResponseEntity.ok().body(new MsgResponseDto("댓글 수정 완료", HttpStatus.OK.value()));
    }

    @DeleteMapping("/comment/{CommentId}")
    public ResponseEntity<MsgResponseDto> delet(@AuthenticationPrincipal UserDetailsImpl userDetails,@PathVariable Long CommentId) {
        commentService.delet(userDetails.getUser(),CommentId);
        return ResponseEntity.ok().body(new MsgResponseDto("댓글 삭제 완료", HttpStatus.OK.value()));
    }
}
