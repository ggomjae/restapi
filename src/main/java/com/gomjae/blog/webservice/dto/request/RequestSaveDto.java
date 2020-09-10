package com.gomjae.blog.webservice.dto.request;

import com.gomjae.blog.webservice.entity.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestSaveDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public RequestSaveDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntiy(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

