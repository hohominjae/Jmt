package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.LikesRequestDto;
import com.sparta.Jmt.dto.MsgResponseDto;
import com.sparta.Jmt.service.LikesService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/jmt/likes")
public class LikesController {
    private final LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping
    public ResponseEntity<MsgResponseDto> insert(@Valid LikesRequestDto likesRequestDto) throws Exception {
        likesService.insert(likesRequestDto);
        return ResponseEntity.ok().body(new MsgResponseDto("좋아요 누르기 성공", HttpStatus.OK.value()));
    }

    @DeleteMapping
    public ResponseEntity<MsgResponseDto> delete(@Valid LikesRequestDto likesRequestDto) throws Exception {
        likesService.delete(likesRequestDto);
        return ResponseEntity.ok().body(new MsgResponseDto("좋아요 취소 성공", HttpStatus.OK.value()));
    }
}
