package com.sofrateam.interfaces.functions;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
 Class contenant des examples dsur l'interface fonctionnelle type Function
 #Function<T, R>    : une interface fonctionnelle avec une methode apply() qui prend le type <T> et renvoi le type <R>
 #UnaryOperator<T>  : une interface fonctionnelle avec une methode apply() qui prend le type <T> et renvoi le type <T>
 #BiFunction<T, U, R>  : une interface fonctionnelle avec une methode apply() qui prend types <T>,<U> et renvoi type <R>
 #BinaryOperator<T> : une interface fonctionnelle avec une methode apply() qui prend types <T>,<T> et renvoi type <T>
 */
public class Client {

    private String name;
    private String numero;

    public Client(String name, String numero) {
        this.name = name;
        this.numero = numero;
    }

    // j'ai besoin dune fonction qui prend un parametre et qui renvoie un autre parametre : Function Interface
    public String transformer(Function<Client, String> function) {
        return function.apply(this);
    }

    // j'ai besoin dune fonction qui prend un parametre et qui renvoie un autre parametre : Function Interface
    public String incrimenter(UnaryOperator<String> unaryOperator) {
        return unaryOperator.apply(numero);
    }

    public String getName() {
        return name;
    }

    public String getNumero() {
        return numero;
    }

    public static void main(String args[]) {

        Client c = new Client("Fares Ferchichi", "2016-01");
        System.out.println(c.transformer(c1 -> {
            return c1.name;
        }));

        //Avant
        System.out.println("Avant : " + c.numero);
        //Apres
        System.out.println("Apres : " + c.incrimenter(st -> {
            return st + "1";
        }));

        // Les objet String sont imutable, on garde la meme valeur
        System.out.println(c.numero);
    }
}
