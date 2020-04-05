package com.examples.bases.generiques;

import java.util.ArrayList;

public class ListeGenerique<T> {

    //list items
    private ArrayList<T> list;

    //position
    private int position;

    //list size
    private int nbElements;

    // create a list with the passed number parameter
    public ListeGenerique(int taille) {
        list = new ArrayList<T>(taille);
        position = 0;
    }

    public void ajout(T e) {
        list.add(e);
        nbElements++;
    }

    public void insert(T e, int index) {
        // s'assurere que la position est correct
        if (index < 0 || index >= nbElements) {
            System.out.println("postion incorrecte, element non inseré");
        } else {
            list.add(index, e);
            nbElements++;
            System.out.println("element inseré a la position : " + index);
        }
    }

    public void remplace(T e, int index) {
        // s'assurere que la position est correct
        if (index < 0 || index >= nbElements) {
            System.out.println("postion incorrecte, element non remplacé");
        } else {
            list.set(index, e);
            System.out.println("element remplacé a la position : " + index);
        }
    }

    public void supprime(int index) {
        // s'assurere que la position est correct
        if (index < 0 || index >= nbElements) {
            System.out.println("postion incorrecte, element non supprimé");
        } else {
            list.remove(index);
            nbElements--;
            System.out.println("element supprimé a la position : " + index);
        }
    }

    public T premier() throws Exception {
        if (getNbElements() == 0) {
            throw new Exception("List Vide, pas de premier");
        }
        position = 0;
        return getElement(0);
    }

    public T dernier() throws Exception {
        if (getNbElements() == 0) {
            throw new Exception("List Vide, pas de dernier");
        }
        position = getNbElements() - 1;
        return getElement(position);
    }

    public T suivant() throws Exception {

        if (getNbElements()==0) {
            throw new Exception("pas de suivant : liste vide");
        }

        if (position == getNbElements()-1) {
            throw new Exception("pas de suivant");
        }
        position = position + 1;
        return getElement(position);
    }

    public T precedent() throws Exception {

        if (getNbElements()==0) {
            throw new Exception("pas de precedent : liste vide");
        }
        if (position == 0 ) {
            throw new Exception("pas de precedent");
        }
        position = position - 1;
        return getElement(position);
    }

    public T getElement(int index) {
        return list.get(index);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNbElements() {
        return nbElements;
    }

    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }
}
