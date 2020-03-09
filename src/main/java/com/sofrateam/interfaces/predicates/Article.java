package com.sofrateam.interfaces.predicates;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
 Class contenant des examples sur l'utilisation des interface fonctionnelle de type Predicate
 #Predicate<T>    : une interface fonctionnelle avec une methode fonctionnelle #test() qui prend le type <T> et renvoi un Bolean
 #BiPredicate<T, U>  : une interface fonctionnelle avec une methode fonctionnelle #test() qui prend les types <T> et <U> et renvoi un Bolean
 #DoublePredicate  : une interface fonctionnelle avec une methode fonctionnelle #test() avec parametre forcement Double et renvoi un Bolean
 #IntPredicate : une interface fonctionnelle avec une methode fonctionnelle #test() avec parametre forcement Int et renvoi un Bolean
 #LongPredicate : une interface fonctionnelle avec une methode fonctionnelle #test() avec parametre forcement Long et renvoi un Bolean
 autres Methodes :
    and(Predicate p) : composer avec un and
    negate() : retourne la negation logique
    or(Predicate p) : compose avec un or
    isEqual(Object o) : on teste l'egaliste entre deux objects

 */
public class Article {

    private String designation;
    private int prix;
    private int type;

    public Article(String designation, int prix, int type) {
        this.designation = designation;
        this.prix = prix;
        this.type = type;
    }

    public String getDesignation() {
        return designation;
    }

    public int getPrix() {
        return prix;
    }

    public int getType() {
        return type;
    }
}

class Catalogue {

    List<Article> listArticles = new ArrayList<Article>();

    void ajouter(Article e) {
        listArticles.add(e);
    }

    /*
    Predicate c'est une manière d'écrire un algorithme très générique qui va faire des choix sur des critères
    qui ne sont pas encore connus au moment où on écrit l'algorithme
     */
    //Ressortir des éléments avec un critère non encore défini:
    List<Article> getArticles(Predicate<Article> t) {
        List<Article> list = new ArrayList<Article>();
        for (Article e : listArticles) {
            if (t.test(e)) list.add(e);
        }
        return list;
    }

    public static void main(String args[]) {

        Catalogue cat = new Catalogue();
        cat.ajouter(new Article("Livre", 5, 0));
        cat.ajouter(new Article("Pomme", 1, 2));
        cat.ajouter(new Article("Poison", 4, 3));
        cat.ajouter(new Article("Eau", 3, 0));


        System.out.println("je cherche les articles dans le type est > 2");
        List<Article> tmp = cat.getArticles(article -> {
            return article.getType() > 2;
        });

        for (Article e : tmp) {
            System.out.println(e.getDesignation());

        }

        System.out.println("je cherche les articles dans le prix est < 4");
        tmp = cat.getArticles(article -> {
            return article.getPrix() < 4;
        });

        for (Article e : tmp) {
            System.out.println(e.getDesignation());

        }
    }

}