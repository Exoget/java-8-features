package com.examples.avance.streams;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional resulat1 = list.stream().map(f -> f.getTotal()).reduce( (a, b) -> a+b);
        Optional resulat2 = list.stream().map(f -> f.getTotal()).reduce( Double::sum);
        System.out.println("Resulatats: " + resulat1.get());
        System.out.println("Resulatats: " + resulat2.get());
    }
}