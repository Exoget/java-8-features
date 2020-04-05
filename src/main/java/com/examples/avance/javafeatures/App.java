package com.examples.avance.javafeatures;

import java.time.LocalDate;

/**
 * Hello world!
 */

interface I1 {
    int AB = 10; // public static final AB

    void m1(); // public void abstract m1()

    static void m2() {
        System.out.println("m2 inside I1");
    }

    default void m3() {
        System.out.println("m3 inside I1");
    }
}

class AB implements I1 {

    @Override
    public void m1() {

    }

    static void m2() {

    }

    @Override
    public void m3() {

    }
}

public class App {
    //@SuppressWarnings("deprecation")
    public static void main(String[] args) throws CloneNotSupportedException {
        Personne per = new Personne("FERCHICHI", "Fares", LocalDate.of(1988, 10, 12));
        System.out.println(per.getNumero());
        System.out.println(Personne.getNbInstance());
        System.out.println("Hello World!");
        per.afficher();

//        Personne per2 = new Personne();
//        System.out.println(per2.getNumero());
//        System.out.println(Personne.getNbInstance());
//        System.out.println("Hello World!");

        EtreVivant e = new EtreVivant() {
            @Override
            protected void seDeplacer() {
                System.out.println("se deplacer");
            }

            @Override
            protected void seCourir() {
                System.out.println("se courir");
            }
        };
        e.seDeplacer();
        // Partie II Clonage
        /*
        il faut implémenter l'interfarce Cloneable pour etre sur que nous aurons des copies
         */

        Client c = new Client("ENI", "", LocalDate.of(1988, 10, 12));
        Commande cmd1, cmd2;

        cmd1 = new Commande();
        cmd1.setLeClient(c);
        cmd2 = (Commande) cmd1.clone();
        System.out.println("HashCode de la commande : " + cmd1.hashCode());
        System.out.println("HashCode de la copie : " + cmd2.hashCode());

        System.out.println("HashCode du client : " + cmd1.getLeClient().hashCode());
        System.out.println("HashCode du client de la copie: " + cmd2.getLeClient().hashCode());

        System.out.println("HashCode des lignes : " + cmd1.getLesLignes().hashCode());
        System.out.println("HashCode des lignes de la copie: " + cmd2.getLesLignes().hashCode());

        Client c12 = new Client("ENI", "fares", LocalDate.of(1988, 10, 12));
        Client c13 = new Client("ENI", "fares", LocalDate.of(1988, 10, 12));

        System.out.println(c12.hashCode());
        System.out.println(c13.hashCode());
        System.out.println(c12.hashCode() == c13.hashCode());
        System.out.println(c12.equals(c13));

        System.out.println(c12.getClass().getName());
        System.out.println(c12.getClass().getFields().length);
    }
}
