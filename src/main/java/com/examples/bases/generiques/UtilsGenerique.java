package com.examples.bases.generiques;

import com.examples.bases.interfaces.Classable;

public class UtilsGenerique {

    // cette fonction permet de trier des element generique
    static <T extends Classable> void tri(ListeGenerique<T> tab) throws Exception{
        int i, j;
        T c;

        for (i = 0; i < tab.getNbElements()-1; i++) {
            for (j = i + 1; j < tab.getNbElements(); j++) {
                if ((tab.getElement(j).compare(tab.getElement(i))) == Classable.INFERIEUR) {
                    c = tab.getElement(i);
                    tab.remplace(tab.getElement(j),i);
                    tab.remplace(c,j);
                } else if ((tab.getElement(j).compare(tab.getElement(i))) == Classable.ERREUR) {
                    throw new Exception("erreur pendant le tri");
                }
            }
        }
    }
}