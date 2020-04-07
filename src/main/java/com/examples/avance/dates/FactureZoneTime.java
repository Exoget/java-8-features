package com.examples.avance.dates;

import java.time.Period;
import java.time.ZonedDateTime;

public class FactureZoneTime {
    private String numero;
    private ZonedDateTime date;
    private ZonedDateTime dateEcheance;

    private static Period dureeMAX = Period.of(0, 2, 0);


    public FactureZoneTime(String numero) {
        this.numero = numero;
        date = ZonedDateTime.now();
        dateEcheance = date.plus(dureeMAX);
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
