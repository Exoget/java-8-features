package com.examples.avance.streams;


import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MonStreamAvance {

    public static void main(String args[]) {

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