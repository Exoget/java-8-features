package com.sofrateam.javafeatures;

import java.time.LocalDate;

public class Client extends Personne {

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance) {
        super(nom, prenom, dateNaissance);
    }

    @Override
    public boolean equals(Object obj) {
        Client c;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        else {
            c = (Client) obj;
            return (this.getNom().equals(c.getNom()) & this.getPrenom().equals(c.getPrenom()));
        }

    }


    @Override
    public int hashCode() {
        return this.getNom().hashCode() + this.getPrenom().hashCode();
    }
}
