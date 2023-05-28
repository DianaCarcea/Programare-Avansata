package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Client playerClient = context.getBean(Client.class);

		List<Player> players1 = playerClient.getPlayers();
		System.out.println("Players: " + players1);

		int playerId = playerClient.postPlayer("Gheorghe");
		System.out.println("New player ID: " + playerId);

		List<Player> players2 = playerClient.getPlayers();
		System.out.println("Players: " + players2);

		ResponseEntity<Void> updateResponse = playerClient.putPlayer(3 ,"Dinu");
		System.out.println("Update response: " + updateResponse.getStatusCode());

		List<Player> players3 = playerClient.getPlayers();
		System.out.println("Players: " + players3);

		ResponseEntity<Void> deleteResponse = playerClient.deletePlayer(1);
		System.out.println("Delete response: " + deleteResponse.getStatusCode());

		context.close();
	}
}
