package com.examples.bases.ClassesImbriquees;

public class ClassesImbriqueeStatique {

    static double taux = 1.96;

    /*
    class static accede suelement aux membres statiques de la class container
     */
    static class Interne {
        public double calculTTC(double prix) {
            return prix * taux;
        }
    }

    public static void main(String args[]) {
        // peut etre instanciee sans qu'il existe une instance de sa classe container
        ClassesImbriqueeStatique.Interne c = new ClassesImbriqueeStatique.Interne();

        System.out.println(c.calculTTC(100));
    }
}
