package org.imt.tournamentmaster.repository.resultat;

import org.imt.tournamentmaster.model.match.Match;
import org.imt.tournamentmaster.model.resultat.Resultat;
import org.imt.tournamentmaster.repository.equipe.EquipeRepository;
import org.imt.tournamentmaster.repository.equipe.EquipeRepositoryImpl;
import org.imt.tournamentmaster.repository.equipe.JoueurRepository;
import org.imt.tournamentmaster.repository.equipe.JoueurRepositoryImpl;
import org.imt.tournamentmaster.repository.match.MatchRepository;
import org.imt.tournamentmaster.repository.match.MatchRepositoryImpl;
import org.imt.tournamentmaster.repository.match.RoundRepository;
import org.imt.tournamentmaster.repository.match.RoundRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.List;

public class ResultatRepositoryTest {

    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(ResultatRepositoryTest.class);

    private final JoueurRepository joueurRepository = new JoueurRepositoryImpl();

    private final EquipeRepository equipeRepository = new EquipeRepositoryImpl(joueurRepository);

    private final RoundRepository roundRepository = new RoundRepositoryImpl(equipeRepository);

    private final MatchRepository matchRepository = new MatchRepositoryImpl(equipeRepository, roundRepository);

    private final ResultatRepository resultatRepository = new ResultatRepositoryImpl(matchRepository);

    @Test
    public void testFindById() {
        // find a resultat
        Resultat resultat = resultatRepository.findById(1L);

        // assert
        Assertions.assertNotNull(resultat);
        Assertions.assertEquals(1L, resultat.getId());

        Assertions.assertNotNull(resultat.getMatch());
        Assertions.assertEquals(1L, resultat.getMatch().getId());

        Assertions.assertNotNull(resultat.getMatch().getEquipeA());
        Assertions.assertEquals(1L, resultat.getMatch().getEquipeA().getId());

        Assertions.assertNotNull(resultat.getMatch().getEquipeB());
        Assertions.assertEquals(2L, resultat.getMatch().getEquipeB().getId());

        Assertions.assertNotNull(resultat.getMatch().getRounds());
        Assertions.assertEquals(3, resultat.getMatch().getRounds().size());

        Assertions.assertEquals(Match.Status.TERMINE, resultat.getMatch().getStatus());

        Assertions.assertEquals(resultat.getMatch().getEquipeA(), resultat.determineWinner());
    }

    @Test
    public void testFindAll() {
        // find all resultats
        List<Resultat> resultats = resultatRepository.findAll();

        // assert
        Assertions.assertNotNull(resultats);
        Assertions.assertEquals(1, resultats.size());
    }

}
