package com.examples.avance.dates;

import java.time.Period;
import java.time.ZonedDateTime;

public class FactureZoneTime {
    private String numero;
    private ZonedDateTime date;
    private ZonedDateTime dateEcheance;

    // l'echance pour tous les facture c'est deux mois
    private static final Period DUREEMAX = Period.of(0, 2, 0);


    public FactureZoneTime(String numero) {
        this.numero = numero;
        date = ZonedDateTime.now();
        dateEcheance = date.plus(DUREEMAX);
    }

    @Override
    public String toString() {
        return "Facture[" +
                "numero='" + numero + '\'' +
                ", date=" + date +
                ", dateEcheance=" + dateEcheance +
                ']';
    }
}