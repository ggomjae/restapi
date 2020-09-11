package com.gomjae.blog.webservice.advice;

import org.springframework.http.HttpStatus;

/*
    상태코드와 메시지만 받도록 함.
    이 클래스로 객체를 만들어서 throw하여 예외를 발생시킴.
    HttpStatus는 스프링프레임워크에서 만들어 놓은 enum 클래스로 상태코드와 상태메시지를 미리 정의.
 */

public class RestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus status;
    private final String message;

    public RestException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}