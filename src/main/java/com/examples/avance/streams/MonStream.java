package com.examples.avance.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MonStream {

    private static List<String> maListe;

    public static void main(String args[]) {

        maListe = new ArrayList<>();
        maListe.add("Rayen");
        maListe.add("Abdo");
        maListe.add("Fares");
        maListe.add("Xavier");

        maListe.stream() // obtenir un flux sur une liste
                .filter(s -> s.contains("r")) // operation intermédiaire
                .forEach(f -> System.out.println(f));

        maListe.stream().forEach(System.out::println);
        //maListe.stream().forEach(s -> System.out.println(s));

        /*
        Le but d’une interface fonctionnelle est de définir la signature d’une méthode qui
        pourra être utilisée pour passer en paramètre :
        1 - une référence vers une méthode statique
        2 - une référence vers une méthode d’instance
        3 - une référence vers un constructeur
        4 - une expression lamba.

        void accept(T t);      => interface fonctionnnel Consumer
        void println(String x) => une référence vers une méthode statique
        forEach(Consumer<T>)
        maListe.stream().forEach(System.out::println);

        je ne peux pas faire parc ontre cet appel
        list.stream().forEach(s -> System.out::println(s));
        */

        Stream.of("fares", "test", "thomas", "rayen")
                .filter(s -> s.contains("r"))
                .map(s -> s + "map") // transformer une donnée en une autre
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Optional<Integer> somme = Stream.of("fabien", "xavier", "brissonneau")
                .filter(s -> s.length() < 7)
                .map(s -> s.length()) // transformer une donnée en une autre
                .reduce((a, b) -> a + b);

        System.out.println("Somme est : " + somme.get());

        Stream.of("ABC", "DEFG", "HIGK").forEach(System.out::println);

        // séparer l'obtention d'un builder qui permet la maipulation de flux de sa réalisation
        Stream.Builder<String> b = Stream.builder();
        b.accept("Fabien");
        b.accept("Xavier");
        // retarder l'application du pipeline
        b.build().forEach(System.out::println);

        // séparer l'obtention d'un builder qui permet la maipulation de flux de sa réalisation
        DoubleStream.Builder bd = DoubleStream.builder();
        bd.accept(3.2);
        bd.accept(1.5);
        // retarder l'application du pipeline
        bd.build().forEach(System.out::println);
    }
}