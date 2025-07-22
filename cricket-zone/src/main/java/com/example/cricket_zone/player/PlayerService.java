package com.example.cricket_zone.player;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    List<Player> getPlayersByName(String name) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    List<Player> getPlayersBySr(double sr) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getSr() >= sr)
                .collect(Collectors.toList());
    }

    List<Player> getPlayersByRunsGreaterThan(int runs) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getRuns() >= runs)
                .collect(Collectors.toList());
    }

    Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository
                .findByName(updatedPlayer.getName());
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setMatches(updatedPlayer.getMatches());
            playerToUpdate.setRuns(updatedPlayer.getRuns());
            playerToUpdate.setAvg(updatedPlayer.getAvg());
            playerToUpdate.setSr(updatedPlayer.getSr());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
