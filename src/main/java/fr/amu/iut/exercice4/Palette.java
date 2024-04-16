package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Haut de page
        HBox hBoxHautDePage = new HBox();
        this.label = new Label();
        this.label.setFont(Font.font(18));
        HBox.setHgrow(hBoxHautDePage,Priority.ALWAYS);
        hBoxHautDePage.getChildren().add(this.label);
        hBoxHautDePage.setAlignment(Pos.CENTER);

        //Milieu de page
        this.panneau = new Pane();
        this.panneau.setStyle("-fx-background-color: transparent;");

        //Bas de page
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");
        this.bas = new HBox();
        this.bas.setAlignment(Pos.CENTER);
        HBox.setHgrow(this.bas, Priority.ALWAYS);
        this.bas.setPadding(new Insets(10));;
        this.bas.setSpacing(10);
        this.bas.getChildren().addAll(this.vert,this.rouge,this.bleu);

        //Création borderpane
        this.root = new BorderPane();
        this.root.setTop(hBoxHautDePage);
        this.root.setCenter(this.panneau);
        this.root.setBottom(this.bas);
        Scene scene = new Scene(this.root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(200);
        primaryStage.setWidth(400);
        primaryStage.show();

        //Gestions d'évènements
        this.rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.panneau.setStyle("-fx-background-color: red;");
            this.label.setText("Rouge choisi " + ++this.nbRouge + " fois");
        });
        this.bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.panneau.setStyle("-fx-background-color: blue;");
            this.label.setText("Bleu choisi " + ++this.nbBleu + " fois");
        });
        this.vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.panneau.setStyle("-fx-background-color: green;");
            this.label.setText("Vert choisi " + ++this.nbVert + " fois");
        });
    }
}

