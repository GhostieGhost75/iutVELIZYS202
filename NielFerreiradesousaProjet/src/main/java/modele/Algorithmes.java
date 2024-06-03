package modele;

import java.util.LinkedList;
import java.util.TreeMap;

/**Classe ou chaque methode est un algotithme de tri  */
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

    /**
     * Applique un algorithme heuristique pour trouver un parcours optimal à travers les temples du joueur.
     * Cette méthode calcule un parcours qui passe par les temples du joueur, en choisissant à chaque étape
     * le temple le plus proche pas encore visité.
     *
     * @param parPlayer L'apprenti pour lequel on prend les temple et on fait l'algorithme as partir de ceux ci.
     * @return Une liste des positions représentant le parcours des temples du joueur.
     */
    public static LinkedList<Position> heuristique(Player parPlayer) {
        // TreeMap pour stocker les temples du joueur par leur position
        TreeMap<Position, Temple> templeMap = parPlayer.getTemples();

        // TreeMap pour stocker les temples pas encore visités par leur numéro
        TreeMap<Integer, Temple> temples = new TreeMap<>();

        // Liste pour stocker le parcours a éffectuer
        LinkedList<Position> parcours = new LinkedList<>();

        // Position actuelle du joueur
        Position posPlayer = new Position(15, 15);

        // Filtrage des temples non complétés
        for (Position pos : templeMap.keySet()) {
            if (templeMap.get(pos).getNum() != templeMap.get(pos).getCristal()) {
                temples.put(templeMap.get(pos).getNum(), templeMap.get(pos));
            }
        }

        // Boucle principale pour calculer le parcours
        while (!temples.isEmpty()) {
            // Recherche du temple le plus proche pas encore visité
            int plusProche = temples.firstKey();
            for (int i : temples.keySet()) {
                if (posPlayer.distancePos(temples.get(i).getPos()) <
                        posPlayer.distancePos(temples.get(plusProche).getPos())) {
                    plusProche = i;
                }
            }

            // Ajout du temple le plus proche au parcours
            Temple first = temples.get(plusProche);
            parcours.add(first.getPos());

            // Recherche des temples suivants dans le parcours optimal
            Temple next = temples.get(first.getCristal());
            Temple previous = null;
            while (temples.get(next.getCristal()) != null) {
                parcours.add(next.getPos());
                previous = next;
                next = temples.get(previous.getCristal());
                if (previous.getCristal() == next.getNum()) {
                    temples.remove(next.getNum());
                }
            }
            // Mise à jour de la position actuelle du joueur
            posPlayer = previous.getPos();
        }

        // Affichage de la longueur du parcours et du parcours lui-même
        System.out.println(longueurParcoursAlgo(parcours));
        System.out.println(parcours);

        // Retourne le parcours optimal calculé
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
