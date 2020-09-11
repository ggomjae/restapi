package com.gomjae.blog.webservice.controllers;

import com.gomjae.blog.webservice.dto.request.RequestSaveDto;
import com.gomjae.blog.webservice.dto.request.RequestUpdateDto;
import com.gomjae.blog.webservice.dto.response.ResponsePostDto;
import com.gomjae.blog.webservice.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    // 게시물 저장 - C
    @PostMapping("/api/v1/post")
    public Long save(@RequestBody RequestSaveDto requestSaveDto) {

        return postService.save(requestSaveDto);
    }

    // 게시물 읽기 - R
    @GetMapping("/api/v1/post/{id}")
    public ResponsePostDto findById(@PathVariable Long id) {

        return postService.findById(id);
    }

    // 게시물 수정 - U
    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody RequestUpdateDto requestUpdateDto) {

        return postService.update(id,requestUpdateDto);
    }

    // 게시물 삭제 - D
    @DeleteMapping("/api/v1/post/{id}")
    public Long delete(@PathVariable Long id){

        postService.delete(id);
        return id;
    }
}
