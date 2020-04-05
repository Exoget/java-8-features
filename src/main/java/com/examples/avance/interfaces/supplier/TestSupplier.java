package com.examples.avance.interfaces.supplier;

import com.examples.avance.javafeatures.Personne;

import java.time.LocalDate;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
 Class contenant des examples sur l'utilisation des interface fonctionnelle de type Supplier
 #Supplier<T>    : une interface fonctionnelle avec une methode fonctionnelle #get() qui renvoi un parametre T
 #IntSupplier  : une interface fonctionnelle avec une methode fonctionnelle #getAsInt() qui renvoi un int
 #DoubleSupplier  : une interface fonctionnelle avec une methode fonctionnelle #getAsDouble() qui renvoi un Double
 #LongSupplier : une interface fonctionnelle avec une methode fonctionnelle #getAsLong() qui renvoi un Long
 #BooleanSupplier : une interface fonctionnelle avec une methode fonctionnelle #getAsBoolean() qui renvoi un Bolean
 */
public class TestSupplier {

    public static void main(String[] args) {
        // supplier pour un String
        Supplier<String> s1 = () -> new String("hello !");
        System.out.println(s1.get());
        // supplier pour un Objet Personne
        Supplier<Personne> s2 = () -> new Personne("FERCHICHI", "Fares", LocalDate.of(1988, 10, 12));
        System.out.println(s2.get());
        // supplier avec une expression Lamba qui renvoie un int fixe
        enrimentation(() -> 10);
    }

    static void enrimentation(IntSupplier intSupplier) {
        for (int i = 0; i <= 5; i++) {
            System.out.println(intSupplier.getAsInt());
        }
    }
}