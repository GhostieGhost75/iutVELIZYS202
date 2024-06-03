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
            while(scanner.hasNext()){
                int posX = scanner.nextInt();
                int posY = scanner.nextInt();
                int couleur = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX+15, posY+15),couleur,cristal);
                templesDuScenario.put(temple.getPos(),temple);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return templesDuScenario;
    }

}
