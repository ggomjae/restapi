package com.gomjae.blog.webservice.services;

import com.gomjae.blog.webservice.dto.request.RequestSaveDto;
import com.gomjae.blog.webservice.dto.request.RequestUpdateDto;
import com.gomjae.blog.webservice.dto.response.ResponsePostDto;
import com.gomjae.blog.webservice.entity.post.Post;
import com.gomjae.blog.webservice.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시물 저장 - C
    @Transactional
    public Long save(RequestSaveDto requestSaveDto) {

        return postRepository.save(requestSaveDto.toEntiy()).getId();
    }

    // 게시물 읽기 - R
    public ResponsePostDto findById (Long id){

        Post entity = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 사용자가 없습니다. id =" +id));

        return new ResponsePostDto(entity);
    }

    // 게시물 수정 - U
    @Transactional
    public Long update(Long id , RequestUpdateDto requestUpdateDto){
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));
        post.update(requestUpdateDto.getTitle(), requestUpdateDto.getContent());

        return id;
    }

    // 게시물 삭제 - D
    @Transactional
    public void delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postRepository.delete(post);
    }
}
