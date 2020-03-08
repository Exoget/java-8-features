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

        // lambdas expression : va remplacer la creation d'un object utilisant une class anonyme
        appelInterface(() -> System.out.println("execute Interface - Lambdas expression"));

        // a travers une variable interface qui declare une fonction
        MyFonctionalInterface monInterface = () -> System.out.println("execution de fonction retardée");
        monInterface.execute();
        // ou bien
        appelInterface(monInterface);

        // a travers des réferences sur Methodes, il faut que la methode a la meme signature que l'interface fonctionel
        MaClass maClass = new MaClass();
        appelInterface(maClass::execute);
        //ou bien
        MyFonctionalInterface monInterface2 = maClass::execute;
        appelInterface(monInterface2);
    }
}
