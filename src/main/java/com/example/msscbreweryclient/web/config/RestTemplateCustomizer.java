package com.example.msscbreweryclient.web.config;

import org.springframework.web.client.RestTemplate;

public abstract class RestTemplateCustomizer {

    /**
     * Callback to customize a {@Link RestTemplate} instance.
     * @param restTemplate the template to customize
     */
    abstract void customize(RestTemplate restTemplate);
}
