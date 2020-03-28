package com.examples;

public interface Classable {

    /*
    Methode de comparaison entre l'objet courant et l'objet en parametre
    @return 1 si l'objet courant est plus grand
    @return -1 si l'objet courant est plus petit
    @return 0 si les deux sont égaux
    @retunr -99 si comparaison imposssible
     */
    // les modifier sont par defaut public et abstract
    int compare(Object o);

    default boolean isInferieur(Object o) {
        return false;
    }

    default boolean isSuperieur(Object o) {
        return false;
    }

    /*
    Every field declaration in the body of an interface is implicitly public, static, and final.
    It is permitted to redundantly specify any or all of these modifiers for such fields.
     */
    int SUPERIEUR = 1;
    int INFERIEUR = -1;
    int EGAL = 0;
    int ERREUR = -99;

}
