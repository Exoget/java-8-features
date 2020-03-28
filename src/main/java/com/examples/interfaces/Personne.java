package com.examples.interfaces;

public class Personne implements Classable {

    private String nom;


    public Personne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Personne : nom " + getNom();
    }

    @Override
    public int compare(Object o) {
        Personne p;
        // si o est une instance de la class Personne
        if (o instanceof Personne) {
            p = (Personne) o;
        } else {

            return Classable.ERREUR;
        }

        if (this.getNom().compareTo(p.getNom()) < 0) return Classable.INFERIEUR;
        if (this.getNom().compareTo(p.getNom()) > 0) return Classable.SUPERIEUR;
        return Classable.EGAL;
    }
}
