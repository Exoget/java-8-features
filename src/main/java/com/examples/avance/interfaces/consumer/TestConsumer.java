package com.examples.avance.interfaces.consumer;

import java.util.function.Consumer;
/*
 Class contenant des examples sur l'utilisation des interface fonctionnelle de type Consumer
 #Consumer<T>    : une interface fonctionnelle avec une methode accept() qui prend le type <T> et renvoi rien
 #DoubleConsumer : une interface fonctionnelle avec une methode accept() qui prend le type Double et renvoi rien
 #IntConsumer  : une interface fonctionnelle avec une methode accept() qui prend types Int et renvoi rien
 #LongConsumer : une interface fonctionnelle avec une methode accept() qui prend Long et renvoi rien
 #ObjDoubleConsumer; ObjIntConsumer; ObjLongConsumer : des consumer avec un objet et un parametre
 autres Methodes implementer par defaut:
    andThen(Consumer<T>)  :applique le Consumer courante puis celui en parametre
 */
class Fichier {

    private String tile;

    public Fichier(String tile) {
        this.tile = tile;
    }

    public String getTile() {
        return tile;
    }

    void affiche(Consumer<Fichier> consumer) {

        Consumer<Fichier> e = (d) -> {
            System.out.println(d.getTile() + " Second");
        };
        consumer.andThen(e).accept(this);
    }
}

public class TestConsumer {

    public static void main(String args[]) {
        Fichier file = new Fichier("JAVA_8_features");
        file.affiche(f -> System.out.println(f.getTile()));
    }
}
