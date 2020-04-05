package com.examples.avance.javafeatures;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Personne {

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Boolean valide;
    private int numero;
    private static int nbInstance;

    // il faut tjr creer un constructuer par defaut pour garantir le chinage des constructuer vers la class Objet
    public Personne() {
        nbInstance++;
        this.numero = nbInstance;
    }

    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        nbInstance++;
        this.numero = nbInstance;
    }

    public Boolean isValide() {
        return valide;
    }

    // si le type booelan est utilise en lecture seul on peut eliminer cette fonction
    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public long calculAge() {
        return dateNaissance.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    //@Deprecated
    public void afficher() {
        System.out.println("nom : " + nom);
        System.out.println("prenom : " + prenom);
        System.out.println("age : " + calculAge());
    }

    /*
    Fonction concu pour accepter un nombre variable de parametres
    exemple d'appel
    afficher("rouge")
    afficher("orange", "blue")
    afficher(null) pour forcer le passage par cette methode et non pas afficher()
     */
    public void afficher(String... params) {
        System.out.println("nombre de parametres : " + params.length);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom.toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom.toLowerCase();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static int getNbInstance() {
        return nbInstance;
    }

    public static void setNbInstance(int nbInstance) {
        Personne.nbInstance = nbInstance;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", valide=" + valide +
                ", numero=" + numero +
                '}';
    }
}