package fr.amu.iut.exercice10;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConteneursControl {
    @FXML
    private TextField nom;

    @FXML
    private TextField email;

    @FXML
    private PasswordField motDePasse;

    @FXML
    private Button envoyer;

    @FXML
    private Button annuler;

    @FXML
    private Button bouton1;

    @FXML
    private Button bouton2;

    @FXML
    private Button bouton3;

    @FXML
    public void envoyerDonnees(){
        String nomUtilisateur = nom.getText();
        String emailUtilisateur = email.getText();
        String motDePasseUtilisateur = motDePasse.getText();
        StringBuilder motDePasseUtilisateurCachee = new StringBuilder();
        for (int i = 0; i < motDePasseUtilisateur.length(); ++i){
            motDePasseUtilisateurCachee.append('*');
        }
        System.out.println("Nom = " + nomUtilisateur + ", Email = "+emailUtilisateur +
                ", Mot de passe = " + motDePasseUtilisateurCachee.toString());
    }

    @FXML
    public void supprimerDonnees(){
        nom.clear();
        email.clear();
        motDePasse.clear();
        System.out.println("Données supprimées");
    }

    @FXML
    public void agirSurBouton1(){
        System.out.println("Vous avez appuyé sur le bouton 1.");
    }

    @FXML
    public void agirSurBouton2(){
        System.out.println("Vous avez appuyé sur le bouton 2.");
    }

    @FXML
    public void agirSurBouton3(){
        System.out.println("Vous avez appuyé sur le bouton 3.");
    }
}
