package com.examples.avance.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics0 {

    public static void main(String[] args) {

        // filter() : construire un nouveau flux stream à partir de la condition (Predicate)
        String[] tab = {"tigre", "chat", "TIGRE", "Tigre", "léopard"};
        List<String> felins = Arrays.asList(tab);

        String search = "tigre";
        String resulat = felins.stream().filter(s -> s.equalsIgnoreCase(search))
                .collect(Collectors.joining(", "));

        System.out.println(resulat);

        // Predicate composé
        Predicate<String> pred1 = s -> s.equalsIgnoreCase(search);
        Predicate<String> pred2 = s -> s.equalsIgnoreCase("léopard");
        resulat = felins.stream().filter(pred1.or(pred2))
                .collect(Collectors.joining(", "));

        System.out.println(resulat);

        // on peut ajouter une regex dans l'étape filtre de Stream() , asPredicate() methode ajouté dans java 8
        //filter("Pattern p".asPredicate)
        //##########################################################################################

        // map() : convertir le type d'un flux vers un autre en utilisant (Function)

        List<Integer> namesLength = felins.stream().map(s -> s.length())
                .collect(Collectors.toList());
        // namesLength = felins.stream().map(String::length) // méthode reference
        // .collect(Collectors.toList());
        System.out.println(namesLength);

        //##########################################################################################

        // forEach() :  Traitement pour tous les éléments (Consumer)
        List<String> zanimo = Arrays.asList("chien", "chat", "poisson", "iguane", "furet");
        zanimo.stream().forEach(System.out::println);

        //##########################################################################################

        /*
         reduce() :  agréger tous les éléments pour obtenir une seule valeur.
         attend deux parametres :
            1) valeur initiale : identity
            2) fonction à appliquer BinaryOperation
         */

        double sumNbrPremier = Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23)
                .reduce(0, (x, y) -> {
                    return x + y;
                });
        System.out.println("Some nombre premiers : " + sumNbrPremier);

        // exemple

        String[] billyQuotes = {"car Brutus est un homme honorable",
                "Donnez-moi toutes vos mains, si nous sommes amis, ",
                "Le malheur donne à un homme d'étranges compagnons de lit"};

        List<String> quotes = Arrays.asList(billyQuotes);

        List<String> mots = quotes.stream().flatMap(s -> Stream.of(s.split(" +"))).collect(Collectors.toList());

        System.out.println(mots);
        System.out.println(mots.size());

        // longeur de mot moyenne dans cette liste

        double aveLength = ((double) mots.stream().map(String::length).reduce(0, (x, y) -> {
            return x + y;})) / (long) mots.size() ;

        System.out.println("Longueur de mot moyenne : " +aveLength);

    }
}
