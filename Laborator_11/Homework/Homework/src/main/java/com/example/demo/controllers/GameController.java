package com.example.demo.controllers;

import com.example.demo.models.Game;
import com.example.demo.models.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final List<Game> games = new ArrayList<>();
    public GameController() {
    }
    @GetMapping
    public List<Game> getGames() {
        return games;
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") int id) {
        return games.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }


    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createPlayer(@RequestBody Game game) {
        games.add(game);
        return new ResponseEntity<>("Game created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGame(@PathVariable int id, @RequestParam int numberGame) {
        Game game =null;

        for(Game gamePlay:games)
        {
            if(gamePlay.getId()==id) {
                game = gamePlay;
                break;
            }
        }

        if (game == null) {
            return new ResponseEntity<>("Game not found", HttpStatus.NOT_FOUND); //or GONE
        }
        game.setNumberGame(numberGame);
        return new ResponseEntity<>("Game updated successsfully", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable int id) {
        Game game =null;

        for(Game gamePlay:games)
        {
            if(gamePlay.getId()==id) {
                game = gamePlay;
                break;
            }
        }

        if (game == null) {
            return new ResponseEntity<>("Game not found", HttpStatus.NOT_FOUND); //or GONE
        }
        games.remove(game);
        return new ResponseEntity<>("Game deleted successsfully", HttpStatus.OK);
    }



}
