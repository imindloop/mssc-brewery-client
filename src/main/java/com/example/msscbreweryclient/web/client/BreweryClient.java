package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.Beer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "imindloop.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public Beer getBeerById(UUID beerId) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), Beer.class);
    }

    public URI saveNewBeer(Beer beer) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beer);
    }

    public void updateBeer(UUID beerId, Beer beer) {
        restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beer);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId.toString());
    }
}
