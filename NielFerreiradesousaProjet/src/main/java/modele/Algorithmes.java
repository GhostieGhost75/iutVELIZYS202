package modele;

import java.util.LinkedList;
import java.util.TreeMap;

public class Algorithmes {

    public static LinkedList<Position> TriSelect(Player parPlayer) {
        TreeMap<Position, Temple> templeMap = parPlayer.getTemples();
        Temple [] temples = new Temple[templeMap.keySet().size()];
        LinkedList<Position> parcours = new LinkedList<>();
        for (Position pos : templeMap.keySet())
            temples[templeMap.get(pos).getNum()-1] = templeMap.get(pos);
        for (int i=0; i< temples.length;i++) {
            int min = i;
            for (int j=i+1; j< temples.length;j++) {
                if (temples[j].getCristal()<temples[min].getCristal())
                    min = j;
            }
            if (min != i) {
                parcours.add(temples[min].getPos());
                parcours.add(temples[i].getPos());
                parcours.add(temples[min].getPos());
                Temple temp = temples[i];
                temples[i] = temples[min];
                temples[min] = temp;

            }
        }
        System.out.println(longueurParcoursAlgo(parcours));
        System.out.println(parcours);
        return parcours;
    }

    public static LinkedList<Position> Heuristique(Player parPlayer) {
        TreeMap<Position, Temple> templeMap = parPlayer.getTemples();
        TreeMap<Integer, Temple> temples = new TreeMap<>();
        LinkedList<Position> parcours = new LinkedList<>();
        for (Position pos : templeMap.keySet()) {
            if (templeMap.get(pos).getNum() != templeMap.get(pos).getCristal())
                temples.put(templeMap.get(pos).getNum(), templeMap.get(pos));
        }
        while (!temples.isEmpty()) {
            Temple first = temples.get(temples.firstKey());
            parcours.add(first.getPos());
            Temple next = temples.get(first.getCristal());
            Temple previous;
            while (temples.get(next.getCristal()) != null) {
                System.out.println(next);
                System.out.println(temples);
                parcours.add(next.getPos());
                previous = next;
                next = temples.get(previous.getCristal());
                if (previous.getCristal() == next.getNum())
                    temples.remove(next.getNum());
            }
        }
        System.out.println(longueurParcoursAlgo(parcours));
        System.out.println(parcours);
        return parcours;
    }

    public static int longueurParcoursAlgo(LinkedList<Position> parParcours) {
        int longueur = 0;
        Position previous = new Position (15,15);
        for (Position pos : parParcours) {
            longueur += previous.distancePos(pos);
            previous = pos;
        }
        return longueur;
    }
}
