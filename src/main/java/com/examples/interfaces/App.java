package com.examples.interfaces;

import java.util.Arrays;

public class App {

    // cette fonction permet de trier des element classables
    public static Classable[] tri(Classable[] tab) {
        int i, j;
        Classable c;

        for (i = 0; i < tab.length; i++) {
            for (j = i + 1; j < tab.length; j++) {
                if ((tab[j].compare(tab[i])) == Classable.INFERIEUR) {
                    c = tab[i];
                    tab[i] = tab[j];
                    tab[j] = c;
                } else if ((tab[j].compare(tab[i])) == Classable.ERREUR) {
                    return null;
                }
            }
        }
        return tab;
    }


    public static void main(String args[]) {

        Classable[] tab = new Classable[]{new Personne("test4"), new Personne("test1"), new Personne("test2")};

        Arrays.stream(tab).forEach(System.out::println);

        // pour trié le tableau ja passe la methode tri, je passe un tableau avec des elements classable
        Classable[] nouveau = tri(tab);
        System.out.println("Apres Tri");
        Arrays.stream(nouveau).forEach(System.out::println);

    }
}
