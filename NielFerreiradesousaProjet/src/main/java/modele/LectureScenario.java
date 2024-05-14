package modele;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class LectureScenario {
    /**
     * la méthode de lecure prend en paramètre un fichier contenant un scénario
     * et retourne une collection contenant les temples à réaligner
     * @param fichierScenario : le fichier lu
     * @return une collection de temples (de la classe Temple)
     *
     */
    public static ArrayList<Temple> lecture(File fichierScenario){
        ArrayList<Temple> templesDuScenario  = new ArrayList<Temple>();
        try {
            Scanner scanner = new Scanner (fichierScenario);
            Temple temple;
            while(scanner.hasNext()){
                //LARGEUR_CANVA = 31 HAUTEU_CANVAS = 31
                //premet de traiter tous les scénarios proposés dans l'énoncé
                int posX = scanner.nextInt();
                int posY = scanner.nextInt();
                int couleur = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posY, posY),couleur,cristal);
                templesDuScenario.add(temple);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return templesDuScenario;
    }

}
