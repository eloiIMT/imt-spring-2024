package org.imt.tournamentmaster.service.equipe;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.imt.tournamentmaster.model.equipe.Joueur;
import org.imt.tournamentmaster.repository.equipe.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Joueur> getById(long id) {
        return joueurRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Joueur> getAll() {
        return StreamSupport.stream(joueurRepository.findAll().spliterator(), false)
                .toList();
    }

    @Transactional
    public Joueur save(Joueur joueur) {
        Validator validator = Validation
                .buildDefaultValidatorFactory().getValidator();

        if (validator.validate(joueur).isEmpty()) {
            return joueurRepository.save(joueur);
        } else {
            throw new IllegalArgumentException("Invalid Joueur");
        }
    }

    public void delete(long id) {
        joueurRepository.deleteById(id);
    }
}
