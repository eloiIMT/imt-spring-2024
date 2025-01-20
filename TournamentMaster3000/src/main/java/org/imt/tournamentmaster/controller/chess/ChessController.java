package org.imt.tournamentmaster.controller.chess;

import org.imt.tournamentmaster.dto.GameDTO;
import org.imt.tournamentmaster.service.chess.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chess")
public class ChessController {

    private final ChessService chessService;

    @Autowired
    public ChessController(ChessService chessService) {
        this.chessService = chessService;
    }

    @GetMapping("/latest-game/{username}")
    public ResponseEntity<GameDTO> getLatestGame(@PathVariable String username) {
        GameDTO game = chessService.getLatestGame(username);
        if (game != null) {
            System.out.println("Game found: " + game);
            return ResponseEntity.ok(game);
        }
        return ResponseEntity.notFound().build();
    }
}