package vue;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import modele.Player;
import modele.Position;
import modele.Temple;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

/** Classe fille de VBox : affiche la grille de jeux et le nombre de pas */
public class VboxCanva extends VBox implements ConstantesCanvas {

    /** objet Canvas : la grille,la map */
    public Canvas canvasCarte;

    /** objet Label : label pour le nombre de pas*/
    public Label labelNombreDePas;

    /** objet GraphicsContext : permet le changement des couleurs et le dessin de formes */
    public GraphicsContext graphicsContext2D;

    /** Constructeur de l'objet VboxCanva : affiche la grille de jeux, les temples et le joueur */
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

    /**
     * Permet le deplacement du joueur lors d'un clique
     * @param player objet Player : l'apprenti ordonnateur
     */
    public void cliquemouv(Player player) {
        canvasCarte.setOnMouseClicked(event -> {
            if (player.getMoving())
                return;
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
                        Position destination;
                        player.setMoving(true);
                        player.getPosPlayer().deplacementUneCase(positionCliquee);
                        player.getPosPlayer().incrementerNombreDePas();

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
                        if (player.getPosPlayer().equals(positionCliquee)) {
                            // Répéter la tâche toutes les secondes
                            timer.cancel();
                            player.setMoving(false);
                        }
                    });
                }
            };
            timer.schedule(task, 0, 100); // Démarrage initial immédiat, puis répétition toutes les secondes
        });

    }

    /**
     * permet le deplacement de l'apprenti en fonction l'algorithme
     * @param positionsCibles objet List : la liste des positions à suivre
     */
    public void deplacementAvecTimerListe( LinkedList<Position> positionsCibles) {
        int[] indice = {0};
        Timer timer = new Timer();
        Player apprenti = HBoxRoot.getApprenti();


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                if (indice[0] < positionsCibles.size()) {
                    Position positionCible = positionsCibles.get(indice[0]);

                    if (!apprenti.getPosPlayer().equals(positionCible)) {
                        // Calculer les pas pour se rapprocher de la position cible uniquement horizontalement ou verticalement
                        int stepX = 0;
                        int stepY = 0;
                        if (apprenti.getPosPlayer().getAbscisse() != positionCible.getAbscisse()) {
                            stepX = Integer.compare(positionCible.getAbscisse(), apprenti.getPosPlayer().getAbscisse());
                        } else if (apprenti.getPosPlayer().getOrdonnee() != positionCible.getOrdonnee()) {
                            stepY = Integer.compare(positionCible.getOrdonnee(), apprenti.getPosPlayer().getOrdonnee());
                        }
                        apprenti.getPosPlayer().deplacementUneCase(new Position(apprenti.getPosPlayer().getAbscisse() + stepX,apprenti.getPosPlayer().getOrdonnee() + stepY));
                        apprenti.getPosPlayer().incrementerNombreDePas();
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
                            Controleur.checkwin();
                        }
                    }
                } else {
                    // Arrêter le timer une fois toutes les positions atteintes
                    apprenti.permutation();
                    timer.cancel();
                }

            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 100);
    }

    /**
     * affiche le chemin via un joueur invisible qui depose un carré bleu derrière lui
     * @param positionsCibles objet List : la liste des positions à suivre
     */
    public void deplacementAvecTimerListeChemin( LinkedList<Position> positionsCibles) {
        int[] indice = {0};
        Timer timer = new Timer();
        Player apprenti = new Player();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (indice[0] < positionsCibles.size()) {
                    Position positionCible = positionsCibles.get(indice[0]);

                    if (!apprenti.getPosPlayer().equals(positionCible)) {
                        // Calculer les pas pour se rapprocher de la position cible uniquement horizontalement ou verticalement
                        int stepX = 0;
                        int stepY = 0;
                        if (apprenti.getPosPlayer().getAbscisse() != positionCible.getAbscisse()) {
                            stepX = Integer.compare(positionCible.getAbscisse(), apprenti.getPosPlayer().getAbscisse());
                        } else if (apprenti.getPosPlayer().getOrdonnee() != positionCible.getOrdonnee()) {
                            stepY = Integer.compare(positionCible.getOrdonnee(), apprenti.getPosPlayer().getOrdonnee());
                        }
                        apprenti.getPosPlayer().deplacementUneCase(new Position(apprenti.getPosPlayer().getAbscisse() + stepX,apprenti.getPosPlayer().getOrdonnee() + stepY));

                        // Effacer l'ancienne position et redessiner les éléments
                        Platform.runLater(() -> {
                            for (Temple temple : apprenti.getTemples().values()) {
                                dessinerTemple(temple);
                            }
                            graphicsContext2D.setFill(COULEUR_CHEMIN);
                            graphicsContext2D.fillRect((apprenti.getPosPlayer().getAbscisse()+1)*CARRE,(apprenti.getPosPlayer().getOrdonnee()+1)*CARRE,CARRE,CARRE);
                        });
                    } else {
                        // Si la position cible est atteinte, passer à la prochaine position
                        indice[0]++;
                        if (indice[0] < positionsCibles.size()) {
                        }
                    }
                } else {
                    // Arrêter le timer une fois toutes les positions atteintes
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 25);
    }


    /** methode qui dessine la map */
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

    /** affiche le joueur et son cristal
     * @param player objet Player : l'apprenti ordonnateur
     * */
    public void afficherJoueur(Player player) {
        Position position = player.getPosPlayer();
        double posX = (position.getAbscisse()+1) * CARRE;
        double posY = (position.getOrdonnee()+1)* CARRE;
        graphicsContext2D.setFill(COULEUR_JOUEUR);
        graphicsContext2D.fillOval(posX, posY, CARRE, CARRE);
        afficher_cristal_apprenti(player);
    }

    /**
     * affiche le cristal du joueur
     * @param player objet Player : l'apprenti ordonnateur
     */
    public void afficher_cristal_apprenti(Player player){
        Position pos= player.getPosPlayer();
        double posX = (pos.getAbscisse()+1) * CARRE;
        double posY = (pos.getOrdonnee()+1)* CARRE;
        graphicsContext2D.setFill(COULEUR_TEMPLES[player.getCristalCol()]);
        graphicsContext2D.fillOval(posX, posY,CARRE/1.2 ,CARRE/1.2 );

    }

    /**
     * affiche le cristal du temple
     * @param temple objet Temple : le temple dont le cristal doit être affiché
     */
    public void afficher_cristal_temple(Temple temple){
        Position pos= new Position (temple.getPos().getAbscisse(),temple.getPos().getOrdonnee());
        double posX = (pos.getAbscisse()+1) * CARRE;
        double posY = (pos.getOrdonnee()+1)* CARRE;
        graphicsContext2D.setFill(COULEUR_TEMPLES[temple.getCristal()]);
        graphicsContext2D.fillOval(posX, posY,CARRE/1.2 ,CARRE/1.2 );

    }

    /**
     * dessine un temple
     * @param temple objet Temple : le temple à dessiner
     */
    public void dessinerTemple(Temple temple) {
        Position position = temple.getPos();
        double posX = (position.getAbscisse() + 1) * CARRE;
        double posY = (position.getOrdonnee() + 1) * CARRE;
        graphicsContext2D.setFill(COULEUR_TEMPLES[temple.getNum()]);
        graphicsContext2D.fillRect(posX, posY, CARRE, CARRE);
        afficher_cristal_temple(temple);
    }

    /** efface toute la map et la redessine */
    public void effacerTout() {
        graphicsContext2D.clearRect(0, 0, LARGEUR_CANVAS, HAUTEUR_CANVAS);
        dessinerGrille();
    }

}
