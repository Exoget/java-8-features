package com.sofrateam.optional;

import java.util.Optional;

/*
 * Problème : récupération d'une donnée mais elle n'existe pas
 * Solution avant java 8 : va être contourné avec les valeurs remarquables en fonction de la valeur de type qu'on récupère
 * exemple retourner une valeur fixe -9999 pour desingner la non-présence d'une valeur entiere dans une methode !!!
 * Seules les références peuvent être null en java
 * Solution avec java 8 : Optional encapsule n'importe quel type avec la possibilité de manipuler un objet qui est réputé être
 * présent mais en réalité n'est pas présent
 */
public class TestOptional {

    public static void main(String args[]) {
        Optional donnee = getValue("bonjour");

        if (donnee.isPresent()) {
            System.out.println("Donnee present: " + donnee.get());
        } else {
            System.out.println("Donne non present: " + donnee.orElse("non dipso"));
        }

        donnee = getValue("non conforme");

        if (donnee.isPresent()) {
            System.out.println("Donnee present: " + donnee.get());
        } else {
            System.out.println("Donne non present: " + donnee.orElse("non dipso"));
        }

        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.ofNullable - je tolère que le paramètre A peut etre null
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - paramètre B est obligatoire, si non present je lance une exception NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a,b));
    }

    private static Optional getValue(String str) {

        if (str.equals("bonjour")) {
            return Optional.of(1);
        } else {
            return Optional.empty();
        }
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}
