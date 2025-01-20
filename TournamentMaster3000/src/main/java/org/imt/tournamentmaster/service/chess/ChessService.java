package org.imt.tournamentmaster.service.chess;

import org.imt.tournamentmaster.dto.GameDTO;
import org.imt.tournamentmaster.dto.GameResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChessService {

    private String apiUrl = "https://api.chess.com/pub";

    private final RestTemplate restTemplate;

    public ChessService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GameDTO getLatestGame(String username) {
        String url = String.format("%s/player/%s/games/2025/01", apiUrl, username);
        GameResponseDTO response = restTemplate.getForObject(url, GameResponseDTO.class);
        if (response != null && response.getGames() != null && !response.getGames().isEmpty()) {
            return response.getGames().get(response.getGames().size() - 1); // Return the latest game
        }
        return null;
    }
}