package com.endava.demo.controller;

import com.endava.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final ClientService clientService;

    @GetMapping("/start")
    public ResponseEntity<String> init(@RequestBody @Valid String request) {

        if (request.equals("hello?")) {
            clientService.ask();
            log.info("Request sent");
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }

    @ExceptionHandler({ClientService.SubmissionException.class})
    public ResponseEntity onSubmissionException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
