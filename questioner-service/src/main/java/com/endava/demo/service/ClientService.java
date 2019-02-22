package com.endava.demo.service;

import com.endava.demo.properties.ClientProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientProperties clientProperties;

    private final RestTemplate restTemplate;

    public String ask() {
        String requestUrl = clientProperties.getRequestPath();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        throw new SubmissionException(responseEntity.getStatusCodeValue());
    }

    @Getter
    public static class SubmissionException extends RuntimeException {

        private int statusCode;

        public SubmissionException(Throwable e) {
            super(e);
        }

        public SubmissionException(int statusCode) {
            this.statusCode = statusCode;
        }
    }
}
