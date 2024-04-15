package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label rond = new Label();
        Label croix = new Label();
        Label vide = new Label();
        ImageView imageCroix = new ImageView("../../resources/exercice2/Croix.png");
        croix.setGraphic(imageCroix);
        ImageView imageRond = new ImageView("../../resources/exercice2/Rond.png");
        rond.setGraphic(imageRond);
        ImageView imageVide = new ImageView("../../resources/exercice2/Vide.png");
        vide.setGraphic(imageVide);
        GridPane grille = new GridPane();
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j) {
                Random random = new Random();
                int nombreAleatoire = random.nextInt(3);
                if (nombreAleatoire == 0) {
                    grille.add(imageVide,i,j);
                }
                else if (nombreAleatoire == 1) {
                    grille.add(imageCroix,i,j);
                }
                else {
                    grille.add(imageRond, i, j);
                }
            }
        }
        Scene scene = new Scene(grille,300,300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("TicTacToe");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

