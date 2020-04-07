package com.examples.avance.dates;

import java.time.LocalDate;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

public class Facture {

    private String numero;
    private LocalDate date;
    private LocalDate dateEcheance;

    private static Period dureeMAX = Period.of(0, 2, 0);


    public Facture(String numero) {
        this.numero = numero;
        date = LocalDate.now();
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

    public long resteAvantEcheance(){
        //Todo imprtation static a voir
        return LocalDate.now().until(dateEcheance, DAYS);
    }

    // ajouter un adjuster pour faire des calcules plus complexes
    public long resteAvantFinAnnee(){
        //Todo imprtation static a voir
        return LocalDate.now().until(dateEcheance.with(lastDayOfYear()), DAYS);
    }
}