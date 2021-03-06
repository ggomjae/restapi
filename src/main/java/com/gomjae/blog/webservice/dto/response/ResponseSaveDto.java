package com.gomjae.blog.webservice.dto.response;

import lombok.Getter;

@Getter
public class ResponseSaveDto {

    private final Long id;
    private final Boolean status;

    public ResponseSaveDto(Long id, Boolean status){

        this.id = id;
        this.status = status;
    }
}

