package modele;

import java.util.LinkedList;
import java.util.TreeMap;

public class Algorithmes {

    public static LinkedList<Position> TriSelect(Player parPlayer) {
        TreeMap<Position, Temple> templeMap = parPlayer.getTemples();
        Temple [] temples = new Temple[templeMap.keySet().size()];
        LinkedList<Position> parcours = new LinkedList<>();
        for (Position pos : parPlayer.getTemples().keySet())
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
        System.out.println(temples);
        System.out.println(parcours);
        return parcours;
    }
}
