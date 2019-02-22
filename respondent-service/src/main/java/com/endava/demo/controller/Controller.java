package com.endava.demo.controller;

import com.endava.demo.service.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final Service service;

    @GetMapping("/ask")
    public ResponseEntity<String> answer() {
        return ResponseEntity.ok(service.answer());
    }
}
