package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        int nbVies = 5;
        Dico dictionnaire = new Dico();
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        VBox affichage = new VBox();
        TextField champUtilisateur = new TextField("Veuillez entrer une lettre");
        Label labelVie = new Label("Nombre de vie : "+ nbVies);
        labelVie.setFont(Font.font("Arial", FontWeight.BOLD,18));
        String motAChercher = dictionnaire.getMot();
        ArrayList<Character> motCachee = new ArrayList<>();
        StringBuilder motCacheeBuilder = new StringBuilder();
        for (int i = 0; i < motAChercher.length(); ++i){
            motCachee.add('*');
            motCacheeBuilder.append('*');
        }
        Label labelMot = new Label(motCacheeBuilder.toString());
        Button boutonRejouer = new Button("Rejouer");

        affichage.getChildren().addAll(labelVie,labelMot,champUtilisateur,boutonRejouer);
        affichage.setAlignment(Pos.CENTER);

        Scene scene = new Scene(affichage);
        primaryStage.setScene(scene);
        primaryStage.show();

        champUtilisateur.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            for (int i = 0; i < motCachee.size(); ++i) {
                String caractere = champUtilisateur.getText();
                if (motAChercher.charAt(i) == motCacheeBuilder.charAt(i));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
