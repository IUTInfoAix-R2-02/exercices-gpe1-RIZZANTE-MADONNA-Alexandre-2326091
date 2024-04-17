package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private ArrayList<Obstacle> listeObstacles = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 32);
        fantome.deplacerAGauche();
        //panneau du jeu
        Obstacle obstacle1 = new Obstacle(100,100,Color.DARKORANGE,40,40);
        listeObstacles.add(obstacle1);
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        for (int i = 0; i < listeObstacles.size(); ++i) {
            jeu.getChildren().add(listeObstacles.get(i));
        }
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                System.exit(1);
            }
            for (int i = 0; i < listeObstacles.size(); ++i){
                if (j1.estEnCollision(listeObstacles.get(i))){
                    j1.setPersoX(j1.getOldX());
                    j1.setPersoY(j1.getOldY());
                }
                if (j2.estEnCollision(listeObstacles.get(i))){
                    j2.setPersoX(j2.getOldX());
                    j2.setPersoY(j2.getOldY());

                }
            }
        });
    }


}
