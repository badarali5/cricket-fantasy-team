package com.example.cricket_zone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/player")
public class PlayerController {
    final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    List<Player> getPlayers(@RequestParam(required = false) String name,
                            @RequestParam(required = false) Float sr,
                            @RequestParam(required = false) Integer runs) {
        if (name != null) {
            return playerService.getPlayersByName(name);
        } else if (sr != null) {
            return playerService.getPlayersBySr(sr);
        } else if (runs != null) {
            return playerService.getPlayersByRunsGreaterThan(runs);
        } else {
            return playerService.getPlayers();
        }
    }

    @PostMapping
    ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted Successfully", HttpStatus.OK);
    }
}
