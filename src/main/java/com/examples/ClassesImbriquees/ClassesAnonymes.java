package com.examples.ClassesImbriquees;

import com.examples.interfaces.Personne;

import java.util.Arrays;
import java.util.function.Predicate;

interface Comparateur {
    int compare(Object o1, Object o2);

    int INF = -1;
    int SUPP = 1;
    int EGA = 0;
    int ERR = -99;
}


// cette classe contient une methode qui va trier des objet
public class ClassesAnonymes {

    // Class interne
    class CompateurImp implements Comparateur {

        @Override
        public int compare(Object o1, Object o2) {
            Personne p1, p2;
            if (o1 instanceof Personne && o2 instanceof Personne) {
                p1 = (Personne) o1;
                p2 = (Personne) o2;
            } else return Comparateur.ERR;
            if (p1.getNom().compareTo(p2.getNom()) < 0) return Comparateur.INF;
            if (p1.getNom().compareTo(p2.getNom()) > 0) return Comparateur.SUPP;
            return Comparateur.EGA;
        }
    }

    public static Object[] sort(Object[] tab, Comparateur cmp) {

        int i, j;
        Object c;

        for (i = 0; i < tab.length; i++) {
            for (j = i + 1; j < tab.length; j++) {
                if (cmp.compare(tab[j], (tab[i])) == Comparateur.INF) {
                    c = tab[i];
                    tab[i] = tab[j];
                    tab[j] = c;
                } else if (cmp.compare(tab[j], (tab[i])) == Comparateur.ERR) {
                    return null;
                }
            }
        }
        return tab;
    }

    // Methode generale de recuperation d'un element ( on defini le critere au moment de l'appel )
    public static Object findOccurence(Object[] tab, Predicate<Object> predicate) {

        for (Object o : tab) {
            if (predicate.test(o)) return o;
        }
        return null;
    }

    public static void main(String args[]) {

        Personne[] tab = new Personne[]{new Personne("test4"), new Personne("test1"), new Personne("test2")};
        Arrays.stream(tab).forEach(System.out::println);


        // avec la class Anonyme
        tab = (Personne[]) sort(tab, new Comparateur() {

            @Override
            public int compare(Object o1, Object o2) {
                Personne p1, p2;
                if (o1 instanceof Personne && o2 instanceof Personne) {
                    p1 = (Personne) o1;
                    p2 = (Personne) o2;
                } else return Comparateur.ERR;
                if (p1.getNom().compareTo(p2.getNom()) < 0) return Comparateur.INF;
                if (p1.getNom().compareTo(p2.getNom()) > 0) return Comparateur.SUPP;
                return Comparateur.EGA;
            }
        });

        System.out.println(" Apres le Sport() ...");
        // avec la class interne
        ClassesAnonymes c = new ClassesAnonymes();
        ClassesAnonymes.CompateurImp cmpImp = c.new CompateurImp();
        tab = (Personne[]) sort(tab, cmpImp);
        Arrays.stream(tab).forEach(System.out::println);


        System.out.println(" Chercher l'ocurence ...");
        //TODO chercheer pourquoi je ne peux pas utiliser direct un cast sur (Personne) per.getNom().equals("test4")
        Personne p = (Personne) findOccurence(tab, per -> {
            Personne o = (Personne) per;
            return o.getNom().equals("test4");
        });
        System.out.println(p);
    }

}
