package modele;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
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
            boolean formatNegatif = false;
            while(scanner.hasNext()){
                int posX = scanner.nextInt();
                int posY = scanner.nextInt();
                if (posX<0 || posY<0)
                    formatNegatif = true;
                int couleur = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX, posY),couleur,cristal);
                templesDuScenario.add(temple);
            }
            scanner.close();
            if (formatNegatif) {
                Iterator fixer = templesDuScenario.iterator();
                while(fixer.hasNext()) {

                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return templesDuScenario;
    }

}
