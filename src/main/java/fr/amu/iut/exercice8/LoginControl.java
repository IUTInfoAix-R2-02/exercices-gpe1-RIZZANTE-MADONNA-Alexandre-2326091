package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField username;

    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        System.out.print(username.getText() + " ");
        for (int i = 0; i < pwd.getLength(); ++i) {
            System.out.print('*');
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        username.clear();
        pwd.clear();
    }
}