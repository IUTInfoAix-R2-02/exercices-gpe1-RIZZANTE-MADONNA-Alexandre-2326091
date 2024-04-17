package fr.amu.iut.exercice5;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class Personnage extends Group {
    protected final static double LARGEUR_MOITIE_PERSONNAGE = 10;
    protected final static double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
    private final Circle corps;
    private String direction;

    private double x;
    private double oldX;
    private double y;
    private double oldY;

    public Personnage(String direction, Color couleurContour, Color couleurRemplissage) {
        this.direction = direction;
        corps = new Circle(10, 10, LARGEUR_MOITIE_PERSONNAGE, couleurContour);
        corps.setFill(couleurRemplissage);
        getChildren().add(corps);
        x = getLayoutX();
        y = getLayoutY();
    }

    public void deplacerAGauche() {
        //    ****
        //   *    *
        //  *---   *
        //   *    *
        //    ****

        //déplacement <----
        if (oldX != x && oldY != y){
            oldX = x;
            oldY = y;
        }
        if (getLayoutX() >= LARGEUR_PERSONNAGE) {
            setLayoutX(getLayoutX() - LARGEUR_PERSONNAGE);
        }
        if (!direction.equals("gauche")) {
            direction = "gauche";
        }
        x = getLayoutX();
        y = getLayoutY();
    }

    public void deplacerADroite(double largeurJeu) {
        //    ****
        //   *    *
        //  *   ---*
        //   *    *
        //    ****
        //déplacement ---->
        if (oldX != x && oldY != y){
            oldX = x;
            oldY = y;
        }
        if (getLayoutX() < largeurJeu - LARGEUR_PERSONNAGE) {
            setLayoutX(getLayoutX() + LARGEUR_PERSONNAGE);
        }
        if (!direction.equals("droite")) {
            direction = "droite";
        }
        x = getLayoutX();
        y = getLayoutY();
    }

    public void deplacerEnBas(double hauteurJeu) {
        //    *****
        //   *     *
        //  *   |   *
        //   *  |  *
        //    *****
        if (oldX != x && oldY != y){
            oldX = x;
            oldY = y;
        }
        if (getLayoutY() < hauteurJeu - LARGEUR_PERSONNAGE) {
            setLayoutY(getLayoutY() + LARGEUR_PERSONNAGE);
        }
        if (!direction.equals("bas")) {
            direction = "bas";
        }
        x = getLayoutX();
        y = getLayoutY();
    }

    public void deplacerEnHaut() {
        //    *****
        //   *  |  *
        //  *   |   *
        //   *     *
        //    *****
        if (oldX != x && oldY != y){
            oldX = x;
            oldY = y;
        }
        if (getLayoutY() >= LARGEUR_PERSONNAGE) {
            setLayoutY(getLayoutY() - LARGEUR_PERSONNAGE);
        }
        if (!direction.equals("haut")) {
            direction = "haut";
        }
        x = getLayoutX();
        y = getLayoutY();
    }

    boolean estEnCollision(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }

    public boolean estEnCollision(Obstacle autreObstacle){
        return getBoundsInParent().contains(autreObstacle.getBoundsInParent())
                || autreObstacle.getBoundsInParent().contains(getBoundsInParent());
    }

    //Getters/Setters des coordonnees
    public void setPersoX(double x){
        setLayoutX(x);
    }
    public void setPersoY(double y){
        setLayoutY(y);
    }

    public double getOldX() {
        return oldX;
    }
    public double getOldY() {
        return oldY;
    }
}
