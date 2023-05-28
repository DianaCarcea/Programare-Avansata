package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class Client {

    private final WebClient webClient;

    @Autowired
    public Client(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public List<Player> getPlayers() {
        return webClient.get()
                .uri("http://localhost:8080/players")
                .retrieve()
                .bodyToFlux(Player.class)
                .collectList()
                .block();
    }

    public int postPlayer(String name) {
        return webClient.post()
                .uri("http://localhost:8080/players")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("name", name))
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
    }

    public ResponseEntity<Void> putPlayer(int id, String name) {
        return webClient.put()
                .uri("http://localhost:8080/players/{id}", id)
                .body(BodyInserters.fromFormData("name", name))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public ResponseEntity<Void> deletePlayer(int id) {
        return webClient.delete()
                .uri("http://localhost:8080/players/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
