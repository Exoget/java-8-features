package com.examples.avance.collections;

import java.util.Arrays;

public class TestArraysTri {

    public static void main(String args[]) {

        int MAX = 1000000;
        int[] tableau = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            tableau[i] = (int) (Math.random() * 100);
        }

        long t0 = System.currentTimeMillis();
        Arrays.sort(tableau);
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(tableau[i]);
        }
        System.out.println("Tri en mils :" + (t1 - t0));


        // sur des petites dimensions le tri en // c'est plus coûteux
        // a partir de cetain nombre le tri en // devient plus efficace que le séquentiel
        t0 = System.currentTimeMillis();
        Arrays.parallelSort(tableau);
        t1 = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            System.out.println(tableau[i]);
        }
        System.out.println("Tri parallèle en mils :" + (t1 - t0));
    }
}