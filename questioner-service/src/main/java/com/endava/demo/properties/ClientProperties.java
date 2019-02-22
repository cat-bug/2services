package com.endava.demo.properties;

import java.net.URI;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "respondent")
@Getter
@Setter
@Validated
@Component
public class ClientProperties {

    @NotNull
    private String url;

    public String getRequestPath() {
        return UriComponentsBuilder.fromUri(getRequestUri())
                .path("/ask")
                .build()
                .toUriString();
    }

    private URI getRequestUri() {
        return URI.create(url);
    }
}
