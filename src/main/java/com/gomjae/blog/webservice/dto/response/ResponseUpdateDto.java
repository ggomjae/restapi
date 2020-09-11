package com.gomjae.blog.webservice.dto.response;
import lombok.Getter;

@Getter
public class ResponseUpdateDto {

    private final Long id;
    private final Boolean status;

    public ResponseUpdateDto(Long id, Boolean status){

        this.id = id;
        this.status = status;
    }
}
