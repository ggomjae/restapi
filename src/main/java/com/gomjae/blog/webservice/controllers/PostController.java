package com.gomjae.blog.webservice.controllers;

import com.gomjae.blog.webservice.dto.request.RequestSaveDto;
import com.gomjae.blog.webservice.dto.response.ResponsePostDto;
import com.gomjae.blog.webservice.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody RequestSaveDto requestSaveDto) {

        return postService.save(requestSaveDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public ResponsePostDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
