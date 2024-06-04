package modele;

import java.util.LinkedList;
import java.util.TreeMap;

/**Classe où chaque méthode est un algotithme de tri  */
public class Algorithmes {

    /**
     * Applique un algorithme de tri selection sur la liste des temple de manière a savoir quel chemin le joueur va emprunté
     * @param parPlayer objet Player : l'apprenti ordonnateur
     * @return objet LinkedList : liste des positions représentant le parcours des temples du joueur.
     */
    public static LinkedList<Position> triSelect(Player parPlayer) {
        TreeMap<Position, Temple> templeMap = parPlayer.getTemples();
        Temple [] temples = new Temple[templeMap.keySet().size()];
        LinkedList<Position> parcours = new LinkedList<>();
        for (Position pos : templeMap.keySet())
            temples[templeMap.get(pos).getCristal()-1] = templeMap.get(pos);
        System.out.println(temples);
        for (int i=0; i< temples.length;i++) {
            int min = i;
            for (int j=i+1; j< temples.length;j++) {
                if (temples[j].getNum()<temples[min].getNum())
                    min = j;
            }
            if (min != i) {
                parcours.add(temples[i].getPos());
                parcours.add(temples[min].getPos());
                parcours.add(temples[i].getPos());
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
     * Applique un algorithme heuristique sur la liste des temple de manière a savoir quel chemin le joueur va emprunter
     * Cette méthode calcule un parcours qui passe par les temples du joueur, en choisissant à chaque étape
     * le temple le plus proche pas encore visité et ramène le cristal trouvé a son temple et lorsque il n'a plus de cristal il recherche le plus proche pas encore visité .
     * @param parPlayer objet Player : l'apprenti ordonnateur
     * @return objet LinkedList : liste des positions représentant le parcours des temples du joueur.
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

    /**
     * Donne le nombre de pas que va faire l'apprenti pour associer chaque cristal à son temple
     * @param parParcours objet LinkedList : liste des positions où l'apprenti doit aller
     * @return objet int : longueur du parcours
     */
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
