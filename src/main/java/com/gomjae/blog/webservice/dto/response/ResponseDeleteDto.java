package com.gomjae.blog.webservice.dto.response;
import lombok.Getter;

@Getter
public class ResponseDeleteDto {

    private final Long id;
    private final Boolean status;

    public ResponseDeleteDto(Long id, Boolean status){

        this.id = id;
        this.status = status;
    }
}
