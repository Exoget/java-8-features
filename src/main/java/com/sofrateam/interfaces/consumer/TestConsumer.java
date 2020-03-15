package com.sofrateam.interfaces.consumer;


import java.util.function.Consumer;

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
