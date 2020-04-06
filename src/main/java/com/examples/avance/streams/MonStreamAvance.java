package com.examples.avance.streams;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MonStreamAvance {

    public static void main(String args[]) {

        List<Facture> list = new ArrayList<>();
        list.add(new Facture("123", "Fares", 200.15));
        list.add(new Facture("200", "Xavier", 605.99));
        list.add(new Facture("173", "Thomas", 300));
        list.add(new Facture("166", "Lassad", 167.78));
        list.add(new Facture("205", "Bertrand", 650.98));

        list.stream().filter(f -> f.getTotal() < 200).forEach(System.out::println);

        list.stream().map(f -> f.getTotal()).forEach(System.out::println);

        // some des valeurs
        Optional resulat1 = list.stream().map(f -> f.getTotal()).reduce((a, b) -> a + b);
        Optional resulat2 = list.stream().map(f -> f.getTotal()).reduce(Double::sum);
        System.out.println("Resulatats: " + resulat1.get());
        System.out.println("Resulatats: " + resulat2.get());

        //Stream Parallel
        String resulat = list.parallelStream().filter(str -> str.getTotal() > 250)
                // .map(Facture::getClient) la meme chose
                .map(fac -> fac.getClient())
                .collect(Collectors.joining("#"));
        System.out.println(resulat);

        // je peux obtenir le meme stream parallele en partant d'un stream sequentiel
        String rest = list.stream().filter(str -> str.getTotal() > 250)
                .parallel()
                .map(fac -> fac.getClient())
                .collect(Collectors.joining("#"));
        System.out.println(rest);

        //Il est tjr possible de mixer flux parallele et flux sequentiel
        // Dans l'effet du parallelisme, il faut prendre en considération que certain opérations ne supportent pas
        // le désordonnancement en particulier les opération d'affichage que l'on voudrait ordonner.
        list.parallelStream().filter(str -> str.getTotal() > 250)
                .sequential() // pour l'affichage en ordre
                .map(fac -> fac.getClient())
                .forEach(System.out::println);

    }
}