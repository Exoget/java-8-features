package com.examples;

public interface Classable {

    /*
    Methode de comparaison entre l'objet courant et l'objet en parametre
    @return 1 si l'objet courant est plus grand
    @return -1 si l'objet courant est plus petit
    @return 0 si les deux sont égaux
    @retunr -99 si comparaison imposssible
     */
    int compare(Object o);

    public static final int SUPERIEUR = 1;
    public static final int INFERIEUR = -1;
    public static final int EGAL = 0;
    public static final int ERREUR = -99;

}
