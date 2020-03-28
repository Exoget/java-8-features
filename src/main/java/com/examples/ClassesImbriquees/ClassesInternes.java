package com.examples.ClassesImbriquees;

public class ClassesInternes {
    double taux = 1.96;

    // peut avoir acces a tous les membres de sa class conatiner
    class Interne {
        public double calculTTC(double prix) {
            return prix * taux;
        }
    }

    public static void main(String args[]) {
        // peut etre instanciee seulement s'il existe une instance de sa classe container
        ClassesInternes conatainer = new ClassesInternes();
        ClassesInternes.Interne interne = conatainer.new Interne();
        System.out.println(interne.calculTTC(100));
    }
}
