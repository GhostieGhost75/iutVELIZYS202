package modele;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgoTest {
    @Test
    void TriInsert() {
        Player joueur = new Player();
        TreeMap<Position, Temple> templesTest = LectureScenario.lecture(new File("maps/scenario1.txt"));
        LinkedList<Position> posVoulues = new LinkedList<>();
        Position [] posVouluesTab = {
                new Position(10,10),new Position(15,3),
                new Position(10,10),new Position(15,3),
                new Position(12,4),new Position(15,3),
                new Position(8,5),new Position(6,4),
                new Position(8,5),new Position(6,4),
                new Position(12,4),new Position(6,4),
        };
        for (Position pos:posVouluesTab)
            posVoulues.add(pos);
        LinkedList<Position> resultatInsert = Algorithmes.TriInsert(joueur);
        while (resultatInsert.size() != 0)
            assert(resultatInsert.poll()==posVoulues.poll());
    }

}

