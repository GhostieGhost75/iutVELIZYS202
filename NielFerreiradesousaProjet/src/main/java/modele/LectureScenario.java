package modele;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class LectureScenario {
    /**
     * la méthode de lecure prend en paramètre un fichier contenant un scénario
     * et retourne une collection contenant les temples à réaligner
     * @param fichierScenario : le fichier lu
     * @return une collection de temples (de la classe Temple)
     *
     */
    public static TreeMap<Position, Temple> lecture(File fichierScenario){
        TreeMap<Position, Temple> templesDuScenario  = new TreeMap<Position, Temple>();
        try {
            Scanner scanner = new Scanner (fichierScenario);
            Temple temple;
            boolean formatNegatif = false;
            while(scanner.hasNext()){
                int posX = scanner.nextInt();
                int posY = scanner.nextInt();
                if (posX<0 || posY<0)
                    formatNegatif = true;
                int couleur = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX, posY),couleur,cristal);
                templesDuScenario.put(temple.getPos(),temple);
            }
            scanner.close();
            if (formatNegatif) {
                Set<Position> positions = templesDuScenario.keySet();
                for (Position pos : positions) {
                    templesDuScenario.get(pos).negFormat();
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return templesDuScenario;
    }

}
