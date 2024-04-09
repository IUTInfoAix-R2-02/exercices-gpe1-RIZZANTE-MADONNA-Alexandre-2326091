package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import static javafx.geometry.HPos.CENTER;
import static javafx.geometry.HPos.RIGHT;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        //Menu de base
        HBox barreMenu = new HBox();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");

        //Sous-menus
        SeparatorMenuItem separateurMenu = new SeparatorMenuItem();
        SeparatorMenuItem separateurMenu2 = new SeparatorMenuItem();
        SeparatorMenuItem separateurMenu3 = new SeparatorMenuItem();
        SeparatorMenuItem separateurMenu4 = new SeparatorMenuItem();
        SeparatorMenuItem separateurMenu5 = new SeparatorMenuItem();
        MenuItem menuNew = new MenuItem("New");
        MenuItem menuOpen = new MenuItem("Open");
        MenuItem menuSave = new MenuItem("Save");
        MenuItem menuClose = new MenuItem("Close");
        menuFile.getItems().addAll(menuNew,separateurMenu3,menuOpen,separateurMenu4,
                menuSave,separateurMenu5,menuClose);
        MenuItem menuCut = new MenuItem("Cut");
        MenuItem menuCopy = new MenuItem("Copy");
        MenuItem menuPaste = new MenuItem("Paste");
        menuEdit.getItems().addAll(menuCut,separateurMenu,menuCopy,separateurMenu2,menuPaste);

        //Cration barre de menu
        MenuBar menuBarre = new MenuBar(menuFile,menuEdit,menuHelp);
        barreMenu.getChildren().add(menuBarre);
        HBox.setHgrow(barreMenu,Priority.ALWAYS);
        borderPane.setTop(barreMenu);

        //Boutons
        HBox corps = new HBox();
        VBox boutons = new VBox();
        Label labelBoutons = new Label("Boutons:");
        Button bouton1 = new Button("Bouton 1");
        Button bouton2 = new Button("Bouton 2");
        Button bouton3 = new Button("Bouton 3");
        boutons.getChildren().addAll(labelBoutons,bouton1,bouton2,bouton3);
        boutons.setSpacing(10.0);
        boutons.setAlignment(Pos.CENTER);

        //Grille
        GridPane coordonnees = new GridPane();
        Label labelName = new Label("Name:");
        GridPane.setRowIndex(labelName,0);
        GridPane.setColumnIndex(labelName,0);
        Label labelEmail = new Label("Email:");
        GridPane.setRowIndex(labelEmail,1);
        GridPane.setColumnIndex(labelName,0);
        Label labelPassword = new Label("Password:");
        GridPane.setRowIndex(labelPassword,2);
        GridPane.setColumnIndex(labelPassword,0);
        Button boutonSubmit = new Button("Submit");
        GridPane.setRowIndex(boutonSubmit,3);
        GridPane.setColumnIndex(boutonSubmit,0);
        TextField champName = new TextField();
        champName.setMaxWidth(300);
        GridPane.setRowIndex(champName,0);
        GridPane.setColumnIndex(champName,1);
        TextField champEmail = new TextField();
        champEmail.setMaxWidth(300);
        GridPane.setRowIndex(champEmail,1);
        GridPane.setColumnIndex(champEmail,1);
        TextField champPassword = new TextField();
        champPassword.setMaxWidth(300);
        GridPane.setRowIndex(champPassword,2);
        GridPane.setColumnIndex(champPassword,1);
        Button boutonCancel = new Button("Cancel");
        GridPane.setRowIndex(boutonCancel,3);
        GridPane.setColumnIndex(boutonCancel,1);
        coordonnees.setHgap(10);
        coordonnees.setVgap(10);
        coordonnees.getChildren().addAll(labelName,labelEmail,labelPassword,
                champName,champEmail,champPassword,boutonSubmit,boutonCancel);
        coordonnees.setAlignment(Pos.CENTER);

        //Corps
        Separator separateurVertical = new Separator(Orientation.VERTICAL);
        corps.getChildren().addAll(boutons,separateurVertical);
        borderPane.setLeft(corps);
        borderPane.setCenter(coordonnees);

        //Pied de page
        VBox basDePage = new VBox();
        Separator separateurPiedDePage = new Separator();
        HBox piedDePage = new HBox();
        Label texteBasDePage = new Label("Ceci est un label de bas de page");
        piedDePage.getChildren().add(texteBasDePage);
        piedDePage.setAlignment(Pos.BOTTOM_CENTER);
        basDePage.getChildren().addAll(separateurPiedDePage,piedDePage);
        borderPane.setBottom(basDePage);

        //Création scène
        Scene scene = new Scene(borderPane,400,400);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

