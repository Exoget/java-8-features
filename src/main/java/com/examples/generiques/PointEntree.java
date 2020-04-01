package com.examples.generiques;

import com.examples.interfaces.Classable;
import com.examples.interfaces.Personne;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PointEntree {


    // on a crée une classe génnérique en fournissant le type argument ( Personne )
    static ListeGenerique<Personne> list = new ListeGenerique<>(4);

    public static void main(String args[]) {

        list.ajout(new Personne("test4")); //position 0
        list.ajout(new Personne("test3")); //position 1
        list.ajout(new Personne("test1")); //position 2
        list.ajout(new Personne("test2")); //position 3

        try {
            UtilsGenerique.tri(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        main();
    }

    static void menu() {
        System.out.println("Programme principal");
        System.out.println("p: premier");
        System.out.println("<: précédent");
        System.out.println(">: suivant");
        System.out.println("d: dernier");
        System.out.println("f: fin");
    }

    static void main() {
        char choix = '\0';
        menu();
        while (choix != 'f') {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                choix = br.readLine().charAt(0);
                switch (choix) {
                    case 'p':
                        System.out.println("le premier dans la liste est : " + list.premier());
                        break;
                    case '<':
                        System.out.println("le precedant dans la liste est : " + list.precedent());
                        break;
                    case '>':
                        System.out.println("le suivant dans la liste est : " + list.suivant());
                        break;
                    case 'd':
                        System.out.println("le dernier dans la liste est : " + list.dernier());
                        break;
                    case 'f':
                        System.out.println("programme terminé");
                        break;
                    default:
                        menu();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}