package com.gomjae.blog.webservice.services;

import com.gomjae.blog.webservice.advice.RestException;
import com.gomjae.blog.webservice.dto.request.RequestSaveDto;
import com.gomjae.blog.webservice.dto.request.RequestUpdateDto;
import com.gomjae.blog.webservice.dto.response.ResponseDeleteDto;
import com.gomjae.blog.webservice.dto.response.ResponsePostDto;
import com.gomjae.blog.webservice.dto.response.ResponseSaveDto;
import com.gomjae.blog.webservice.dto.response.ResponseUpdateDto;
import com.gomjae.blog.webservice.entity.post.Post;
import com.gomjae.blog.webservice.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시물 저장 - C
    @Transactional
    public ResponseSaveDto save(RequestSaveDto requestSaveDto) {

        long id = postRepository.save(requestSaveDto.toEntiy()).getId();

        return new ResponseSaveDto(id,true);
    }

    // 게시물 List - R, All
    @Transactional
    public List<ResponsePostDto> findAllDesc(){

        return postRepository.findAllDesc().stream()
                .map(ResponsePostDto::new)
                .collect(Collectors.toList());
    }

    // 게시물 읽기 - R
    public ResponsePostDto findById (Long id){

        Post entity = postRepository.findById(id).orElseThrow(()->
                new RestException(HttpStatus.NOT_FOUND, "Not found Post"));

        return new ResponsePostDto(entity);
    }

    // 게시물 수정 - U
    @Transactional
    public ResponseUpdateDto update(Long id , RequestUpdateDto requestUpdateDto){
        Post post = postRepository.findById(id).orElseThrow(()->
                new RestException(HttpStatus.NOT_FOUND, "Not found Post"));

        post.update(requestUpdateDto.getTitle(), requestUpdateDto.getContent());
        return new ResponseUpdateDto(id,true);
    }

    // 게시물 삭제 - D
    @Transactional
    public ResponseDeleteDto delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->
                new RestException(HttpStatus.NOT_FOUND, "Not found Post"));

        postRepository.delete(post);
        return new ResponseDeleteDto(id,true);
    }
}
