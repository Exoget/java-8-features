package com.sofrateam.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MonStream {

    private static List<String> maListe;

    public static void main(String args[]) {

        maListe = new ArrayList<>();
        maListe.add("Rayen");
        maListe.add("Abdo");
        maListe.add("Fares");
        maListe.add("Xavier");

        maListe.stream()
                .filter(s -> s.contains("r"))
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

        je ne peux pas faire parcontre cet appel
        list.stream().forEach(s -> System.out::println(s));
        */

        Stream.of("fares", "test", "thomas", "rayen")
                .filter(s -> s.contains("r"))
                .map(s -> s + "map")
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
