package com.examples.avance.streams;

public class Facture {

    private String numero;
    private String client;
    private double total;

    public Facture(String numero, String client, double total) {
        this.numero = numero;
        this.client = client;
        this.total = total;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Facture[" +
                "Numero='" + numero + '\'' +
                ", Client='" + client + '\'' +
                ", Total=" + total +
                ']';
    }
}