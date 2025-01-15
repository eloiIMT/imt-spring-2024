package org.imt.tournamentmaster.controller.match;

import org.imt.tournamentmaster.model.match.Match;
import org.imt.tournamentmaster.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getById(@PathVariable long id) {
        Optional<Match> match = matchService.getById(id);

        return match.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> update(@PathVariable long id, @RequestBody Match match) {
        Optional<Match> updatedMatch = Optional.ofNullable(matchService.save(match));

        return updatedMatch.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Match> getAll() {
        return matchService.getAll();
    }
}
