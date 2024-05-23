package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.When;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;
    private IntegerProperty nbFois;
    private StringProperty message;
    private StringProperty couleurPanneau;

    public Palette() {
        this.nbFois = new SimpleIntegerProperty();
        this.message = new SimpleStringProperty();
        this.couleurPanneau = new SimpleStringProperty("#000000");
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */
        rouge.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: #F21411");
            couleurPanneau.setValue("#F21411");
            nbFois.setValue(nbRouge);
            message.setValue(rouge.getText());
            //texteDuHaut.setText(message.getValue() + " choisi " + nbFois.getValue() + " fois");
        });
        vert.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: #31BCA4");
            couleurPanneau.setValue("#31BCA4");
            nbFois.setValue(nbVert);
            message.setValue(vert.getText());
            //texteDuHaut.setText(message.getValue() + " choisi " + nbFois.getValue() + " fois");
        });
        bleu.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: #3273A4");
            couleurPanneau.setValue("#3273A4");
            nbFois.setValue(nbBleu);
            message.setValue(bleu.getText());
            //texteDuHaut.setText(message.getValue() + " choisi " + nbFois.getValue() + " fois");
        });

        //createBindings();
        texteDuHaut.textProperty().bind(texteDuHaut.textProperty().concat(message+" choisi "+nbFois.add(1).asString()+" fois"));
        panneau.styleProperty().bind(couleurPanneau.concat(couleurPanneau));

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings() {
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty();
        pasEncoreDeClic.bind(Bindings.equal(0,nbFois));
    }
}
