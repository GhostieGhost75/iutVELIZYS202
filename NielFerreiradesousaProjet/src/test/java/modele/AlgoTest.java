package modele;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.TreeMap;

/** Classe de test des fonctions liées au Algorithmes */
public class AlgoTest {

    /**
     * Appelle l'algorithme TriSelect sur le premier scénario du dossier map.
     * Pas d'erreur si les positions correspondent au résultat fait manuellement en
     * suivant les principes du tri par sélection.
     */
    @Test
    public void TriSelect() {
        Player joueur = new Player();
        TreeMap<Position, Temple> templesTest = LectureScenario.lecture(new File("maps/scenario0.txt"));
        joueur.setTemples(templesTest);
        LinkedList<Position> posVoulues = new LinkedList<>();
        Position [] posVouluesTab = {
                new Position(14,18),new Position(14,14),
                new Position(14,18),new Position(18,14),
                new Position(14,18),new Position(18,14),
                new Position(18,14),new Position(18,18),
                new Position(18,14)
        };
        for (Position pos:posVouluesTab)
            posVoulues.add(pos);
        LinkedList<Position> resultatSelect = Algorithmes.TriSelect(joueur);
        while (resultatSelect.size() != 0)
            assert(resultatSelect.poll().equals(posVoulues.poll()));
    }

    /**
     * Appelle l'algorithme Heuristique sur le deuxième scénario du dossier map.
     * Pas d'erreur si les positions correspondent au résultat fait manuellement en
     * suivant les principes de l'algorithme.
     */
    @Test
    public void Heuristique() {
        Player joueur = new Player();
        TreeMap<Position, Temple> templesTest = LectureScenario.lecture(new File("maps/scenario1.txt"));
        joueur.setTemples(templesTest);
        LinkedList<Position> posVoulues = new LinkedList<>();
        Position [] posVouluesTab = {
                new Position(21,19),new Position(23,20),
                new Position(27,19),new Position(30,18),
                new Position(25,25),new Position(21,19),
        };
        for (Position pos:posVouluesTab)
            posVoulues.add(pos);
        LinkedList<Position> resultatHeuristique = Algorithmes.heuristique(joueur);
        while (resultatHeuristique.size() != 0)
            assert(resultatHeuristique.poll().equals(posVoulues.poll()));
    }

    /**
     * Renvoie la longueur des parcours donnés par les algorithmes TriSelect et Heuristique.
     * Pas d'erreur si les nombres correspondent aux nombres de pas obtenus manuellement
     * en employant les deux algorithmes.
     */
    @Test
    public void longueurParcoursAlgo() {
        TreeMap<Position, Temple> templesTest1 = LectureScenario.lecture(new File("maps/scenario1.txt"));
        TreeMap<Position, Temple> templesTest2 = LectureScenario.lecture(new File("maps/scenario1.txt"));
        Player joueur1 = new Player();
        joueur1.setTemples(templesTest1);
        Player joueur2 = new Player();
        joueur2.setTemples(templesTest2);
        LinkedList<Position> resultatSelect = Algorithmes.TriSelect(joueur1);
        LinkedList<Position> resultatHeuristique = Algorithmes.heuristique(joueur2);
        assert(Algorithmes.longueurParcoursAlgo(resultatSelect) == 84);
        assert(Algorithmes.longueurParcoursAlgo(resultatHeuristique) == 44);
    }

}

