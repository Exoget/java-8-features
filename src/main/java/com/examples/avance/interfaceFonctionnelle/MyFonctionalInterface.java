package com.examples.avance.interfaceFonctionnelle;

/*
SAM : Single Abstract Methode : c'est le seul type qui peut etre substituer en lambdas expresssion
Le but d’une interface fonctionnelle est de définir la signature d’une méthode qui pourra être utilisée pour passer en paramètre :
1 - une référence vers une méthode statique
2 - une référence vers une méthode d’instance
3 - une référence vers un constructeur
4 - une expression lamba.
 */
@FunctionalInterface
public interface MyFonctionalInterface {

    void execute();
}
