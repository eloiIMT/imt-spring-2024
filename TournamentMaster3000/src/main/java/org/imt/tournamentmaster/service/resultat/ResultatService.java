package org.imt.tournamentmaster.service.resultat;

import org.imt.tournamentmaster.model.resultat.Resultat;
import org.imt.tournamentmaster.repository.resultat.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {

    private final ResultatRepository resultatRepository;

    @Autowired
    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }

    public Resultat getById(int id) {
        return resultatRepository.findById(id);
    }

    public List<Resultat> getAll() {
        return resultatRepository.findAll();
    }
}
