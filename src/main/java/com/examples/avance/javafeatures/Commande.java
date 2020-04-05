package com.examples.avance.javafeatures;

public class Commande implements Cloneable {

    private Client leClient;
    private LignesDeCommandes lesLignes;

    public Commande() {
        super();
        lesLignes = new LignesDeCommandes();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Commande cmd;
        cmd = (Commande) super.clone();
        // duplication des lignes de commandes : par defaut le clonnage de la commande
        // garde les objet refenrecé partagées entre leux objects original et copie
        cmd.lesLignes = (LignesDeCommandes) lesLignes.clone();
        return cmd;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    public LignesDeCommandes getLesLignes() {
        return lesLignes;
    }

    public void setLesLignes(LignesDeCommandes lesLignes) {
        this.lesLignes = lesLignes;
    }
}
