package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public Obstacle(double largeur, double hauteur, Color couleur, double x, double y) {
        super(largeur,hauteur);
        super.setFill(couleur);
        super.setX(x);
        super.setY(y);
    }
}
