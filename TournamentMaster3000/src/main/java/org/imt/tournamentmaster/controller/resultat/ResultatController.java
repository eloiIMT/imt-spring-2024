package org.imt.tournamentmaster.controller.resultat;

import org.imt.tournamentmaster.model.resultat.Resultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.imt.tournamentmaster.service.resultat.ResultatService;

import java.util.List;

@RestController
@RequestMapping("/api/resultat")
public class ResultatController {

    private final ResultatService resultatService;

    @Autowired
    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @GetMapping("/{id}")
    public Resultat getById(@PathVariable int id) {
        return resultatService.getById(id);
    }

    @GetMapping
    public List<Resultat> getAll() {
        return resultatService.getAll();
    }
}
