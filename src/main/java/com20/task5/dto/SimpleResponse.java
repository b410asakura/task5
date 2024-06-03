package com20.task5.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Setter
@Getter
public class SimpleResponse {
    private HttpStatus httpStatus;
    private String message;
    private String note;

    public SimpleResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public SimpleResponse(HttpStatus httpStatus, String message, String note) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.note = note;
    }
}