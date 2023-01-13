package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById() {
        Beer beer = client.getBeerById(UUID.randomUUID());

        assertNotNull(beer);
    }

    @Test
    void testSaveNewBeer() {
        Beer newBeer = Beer.builder().name("New Beer").build();

        URI uri = client.saveNewBeer(newBeer);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        Beer beerToUpdate = Beer.builder().name("Beer to update").build();

        client.updateBeer(UUID.randomUUID(), beerToUpdate);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

}