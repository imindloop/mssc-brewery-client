package com.example.msscbreweryclient.web.config;

import org.springframework.web.client.RestTemplate;

@FunctionalInterface
public interface RestTemplateCustomizer {

    /**
     * A method to customize a {@Link RestTemplate} instance
     * @param restTemplate the rest template instance to customize.
     */
    void customize(RestTemplate restTemplate);
}
