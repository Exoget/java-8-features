package com.examples.avance.javafeatures;

public abstract class EtreVivant {

    private double taille;
    private double poids;

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    // Cette Methode devra etre implémentée dans les classes dériviées
    protected abstract void seDeplacer();

    // Cette Methode devra etre implémentée dans les classes dériviées
    protected abstract void seCourir();
}
