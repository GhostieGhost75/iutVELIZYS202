package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.GraphicsContext;
import modele.Player;
import modele.Position;
import modele.Temple;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

public class VboxCanva extends VBox implements ConstantesCanvas {
    public Canvas canvasCarte;
    public Label labelNombreDePas;
    public GraphicsContext graphicsContext2D;

    public VboxCanva() {
        labelNombreDePas = new Label("Nombre de pas : 0");
        canvasCarte = new Canvas(LARGEUR_CANVAS, HAUTEUR_CANVAS);
        graphicsContext2D = canvasCarte.getGraphicsContext2D();

        // Dessiner la grille
        dessinerGrille();

        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));
    }


    public void cliquemouv(Player player) {
        canvasCarte.setOnMouseClicked(event -> {
            double abscisse = (event.getX() / CARRE)-1;
            double ordonnee = (event.getY() / CARRE)-1;
            Position positionCliquee = new Position((int) abscisse, (int) ordonnee);

            // Stockez une référence au Timer dans une variable locale
            Timer timer = new Timer();

            // Créez une tâche Timer pour le déplacement
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        player.getPosPlayer().deplacementUneCase(positionCliquee);

                        effacerTout();
                        for (Position temple : player.getTemples().keySet()) {
                            System.out.println("Temple à la position : " + player.getTemples().get(temple).getPos());
                            dessinerTemple(player.getTemples().get(temple));
                        }

                        // Mettre à jour l'interface graphique pour la nouvelle position
                        afficherJoueur(player);

                        // Mettre à jour le nombre de pas
                        labelNombreDePas.setText("Nombre de pas : " + player.getPosPlayer().getNombreDePas());


                        // Si le joueur n'est pas encore arrivé à sa position cible, répéter la tâche
                        if (!player.getPosPlayer().equals(positionCliquee)) {
                            // Répéter la tâche toutes les secondes
                            timer.schedule(this, 100);
                        } else {
                            timer.cancel();
                        }
                    });
                }
            };
            timer.schedule(task, 0, 100); // Démarrage initial immédiat, puis répétition toutes les secondes
        });

    }
    public void deplacementAvecTimerListe(Position positionCourante, LinkedList<Position> positionsCibles) {
        int[] indice = {0};
        Timer timer = new Timer();
        Player apprenti = HBoxRoot.getApprenti();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (indice[0] < positionsCibles.size()) {
                    Position positionCible = positionsCibles.get(indice[0]);

                    if (!positionCourante.equals(positionCible)) {
                        // Calculer les pas pour se rapprocher de la position cible uniquement horizontalement ou verticalement
                        int stepX = 0;
                        int stepY = 0;

                        if (positionCourante.getAbscisse() != positionCible.getAbscisse()) {
                            stepX = Integer.compare(positionCible.getAbscisse(), positionCourante.getAbscisse());
                        } else if (positionCourante.getOrdonnee() != positionCible.getOrdonnee()) {
                            stepY = Integer.compare(positionCible.getOrdonnee(), positionCourante.getOrdonnee());
                        }
                        apprenti.getPosPlayer().deplacementUneCase(new Position(positionCourante.getAbscisse() + stepX,positionCourante.getOrdonnee() + stepY));
                        // Incrémenter le nombre de pas

                        // Effacer l'ancienne position et redessiner les éléments
                        Platform.runLater(() -> {
                            effacerTout(); // Effacer toute la carte pour mettre à jour correctement

                            for (Temple temple : apprenti.getTemples().values()) {
                                dessinerTemple(temple);
                            }
                            afficherJoueur(apprenti);
                            labelNombreDePas.setText("Nombre de pas : " + apprenti.getPosPlayer().getNombreDePas());
                        });
                    } else {
                        // Si la position cible est atteinte, passer à la prochaine position
                        indice[0]++;
                        if (indice[0] < positionsCibles.size()) {
                            apprenti.permutation();
                        }
                    }
                } else {
                    // Arrêter le timer une fois toutes les positions atteintes
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 100);
    }





    public void dessinerGrille() {
        graphicsContext2D.setStroke(COULEUR_CANVAS);
        for (int i = 0; i < LARGEUR_CANVAS; i += CARRE) {
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }

        // Dessiner les indices de colonnes
        int numCol = -15;
        graphicsContext2D.setFill(COULEUR_CANVAS);
        for (double i = CARRE; i < LARGEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numCol), i + CARRE / 7, CARRE / 2);
            numCol++;
        }

        // Dessiner les indices de lignes
        int numLigne = -15;
        graphicsContext2D.setFill(COULEUR_CANVAS);
        for (double i = CARRE; i < HAUTEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARRE / 7, i + CARRE / 2);
            numLigne++;
        }
    }

    public void afficherJoueur(Player player) {
        Position position = player.getPosPlayer();
        double posX = (position.getAbscisse()+1) * CARRE;
        double posY = (position.getOrdonnee()+1)* CARRE;
        graphicsContext2D.setFill(COULEUR_JOUEUR);
        graphicsContext2D.fillOval(posX, posY, CARRE, CARRE);
        System.out.println("Dessiner joueur à : (" + posX + ", " + posY + ")");
        afficher_cristal_apprenti(player);
    }
    public void afficher_cristal_apprenti(Player player){
        Position pos= player.getPosPlayer();
        double posX = (pos.getAbscisse()+1) * CARRE;
        double posY = (pos.getOrdonnee()+1)* CARRE;
        graphicsContext2D.setFill(COULEUR_TEMPLES[player.getCristalCol()]);
        graphicsContext2D.fillOval(posX, posY,CARRE/1.2 ,CARRE/1.2 );

    }
    public void afficher_cristal_temple(Temple temple){
        Position pos= new Position (temple.getPos().getAbscisse(),temple.getPos().getOrdonnee());
        double posX = (pos.getAbscisse()+1) * CARRE;
        double posY = (pos.getOrdonnee()+1)* CARRE;
        graphicsContext2D.setFill(COULEUR_TEMPLES[temple.getCristal()]);
        graphicsContext2D.fillOval(posX, posY,CARRE/1.2 ,CARRE/1.2 );

    }

    public void dessinerTemple(Temple temple) {
        Position position = temple.getPos();
        double posX = (position.getAbscisse() + 1) * CARRE;
        double posY = (position.getOrdonnee() + 1) * CARRE;
        System.out.println("Dessiner temple à : (" + posX + ", " + posY + ")");
        graphicsContext2D.setFill(COULEUR_TEMPLES[temple.getNum()]);
        graphicsContext2D.fillRect(posX, posY, CARRE, CARRE);
        afficher_cristal_temple(temple);
    }

    public void effacerTout() {
        graphicsContext2D.clearRect(0, 0, LARGEUR_CANVAS, HAUTEUR_CANVAS);
        dessinerGrille();
    }

    public void effacerPosition(Position position) {
        double posX = (position.getAbscisse() + 1) * CARRE;
        double posY = (position.getOrdonnee() + 1) * CARRE;
        graphicsContext2D.clearRect(posX, posY, CARRE, CARRE);
        graphicsContext2D.setStroke(COULEUR_CANVAS);
        graphicsContext2D.strokeRect(posX, posY, CARRE, CARRE);
    }
}
