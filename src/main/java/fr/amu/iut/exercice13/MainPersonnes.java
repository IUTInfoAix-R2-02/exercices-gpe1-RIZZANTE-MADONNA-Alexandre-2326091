package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;

    private static  ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne ->
                new Observable[] {
                        personne.ageProperty()
        });

        unChangementListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        List<Personne> listePersonneAjoutee = new ArrayList<Personne>();
                        for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                            listePersonneAjoutee.add(change.getAddedSubList().get(i));
                        }

                        for (int index = 0; index < listePersonneAjoutee.size(); ++index) {
                            System.out.println(listePersonneAjoutee.get(index).getNom());
                        }
                    }
                    else if (change.wasRemoved()) {
                        List<Personne> listePersonneSupprimee = new ArrayList<Personne>();
                        for (Personne personne: change.getRemoved()){
                            listePersonneSupprimee.add(personne);
                        }
                        System.out.println("Suppression de " +
                                listePersonneSupprimee.get(0).getNom());
                    }
                    else if (change.wasUpdated()) {
                        List<Personne> listePersonneAgeModifiee = new ArrayList<Personne>();
                        for (int i = change.getFrom(); i < change.getTo(); ++i) {
                            for (Personne personne: change.getList()) {
                                if (personne.getNom().equals(lesPersonnes.get(i).getNom())) {
                                    listePersonneAgeModifiee.add(personne);
                                    listePersonneAgeModifiee.get(
                                            listePersonneAgeModifiee.size()-1
                                    ).setAge(lesPersonnes.get(i).getAge());
                                }
                            }
                        }
                        System.out.println(listePersonneAgeModifiee.get(0).getNom() +
                                " a maintenant " + listePersonneAgeModifiee.get(0).getAge() +
                                " ans");
                    }
                }
            }
        };
        lesPersonnes.addListener(unChangementListener);
        System.out.println("Question 1:");
        question1();
        System.out.println("\nQuestion 2:");
        question2();
        System.out.println("\nQuestion 3:");
        question3();

        plusieursChangementsListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        List<Personne> listePersonneAjoutee = new ArrayList<Personne>();
                        for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                            listePersonneAjoutee.add(change.getAddedSubList().get(i));
                        }

                        for (int index = 0; index < listePersonneAjoutee.size(); ++index) {
                            System.out.print(listePersonneAjoutee.get(index).getNom() + "\t");
                        }
                        System.out.println();
                    } else if (change.wasRemoved()) {
                        List<Personne> listePersonneSupprimee = new ArrayList<Personne>();
                        for (Personne personne : change.getRemoved()) {
                            listePersonneSupprimee.add(personne);
                        }
                        for (int i = 0; i < listePersonneSupprimee.size(); ++i) {
                            System.out.print("Suppression de " +
                                    listePersonneSupprimee.get(i).getNom() + "\t");
                        }
                    }
                    else if (change.wasUpdated()) {
                        List<Personne> listePersonneAgeModifiee = new ArrayList<Personne>();
                        for (int i = change.getFrom(); i < change.getTo(); ++i) {
                            for (Personne personne: change.getList()) {
                                if (personne.getNom().equals(lesPersonnes.get(i).getNom())) {
                                    listePersonneAgeModifiee.add(personne);
                                    listePersonneAgeModifiee.get(
                                            listePersonneAgeModifiee.size()-1
                                    ).setAge(lesPersonnes.get(i).getAge());
                                }
                            }
                        }
                        for (int i = 0; i < listePersonneAgeModifiee.size(); ++i) {
                            System.out.println(listePersonneAgeModifiee.get(i).getNom() +
                                    " a maintenant " + listePersonneAgeModifiee.get(i).getAge() +
                                    " ans");
                        }
                    }
                }
            }
        };

        lesPersonnes.removeListener(unChangementListener);
        lesPersonnes.addListener(plusieursChangementsListener);
        System.out.println("\nQuestion 5:");
        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

