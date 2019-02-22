package com.endava.demo.service;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    public String answer() {
        return "good morning!";
    }
}
