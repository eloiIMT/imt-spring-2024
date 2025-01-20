package org.imt.tournamentmaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GameResponseDTO {
    private List<GameDTO> games;

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }
}