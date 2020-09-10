package com.gomjae.blog.webservice.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class RequestUpdateDto {

    private String title;
    private String content;

    @Builder
    public RequestUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

