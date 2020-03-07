package com.sofrateam.alphorme;

public class PointEntree {


    public static void appelInterface(MyFonctionalInterface i) {
        i.execute();
    }

    public static void main(String[] args) {

        // anonyme class
        appelInterface(new MyFonctionalInterface() {
            @Override
            public void execute() {
                System.out.println("execute Interface - Class Anonyme");
            }
        });

        // lambdas expression
        appelInterface(() -> System.out.println("execute Interface - Lambdas expression"));

    }
}
