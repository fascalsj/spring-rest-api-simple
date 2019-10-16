package com.belajar.restapi.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Setter
@Getter
public class ResponseSuccess<T> {
    private String service;
    private String message;
    private Timestamp timestamp;
    T data;
}