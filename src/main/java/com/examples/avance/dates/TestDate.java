package com.examples.avance.dates;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class TestDate {

    public static void main(String args[]) {

        // creation date time local
        LocalDateTime tdt = LocalDateTime.now();
        LocalTime lt = LocalTime.of(12, 12);
        lt.minusMinutes(12);

        //informations zonées
        ZoneId zone = ZoneId.of("Europe/Paris");
        ZonedDateTime zd = ZonedDateTime.of(tdt, zone);

        Period p = Period.of(1, 0, 0);
        LocalDate ld = LocalDate.now();
        ld.plus(p);

        // sur du local Francais , chronology francais
        Chronology dt;
        int annee;
        dt = Chronology.ofLocale(Locale.FRANCE);
        ChronoLocalDate cld = dt.dateNow();
        annee = cld.get(ChronoField.YEAR);
        System.out.println(" année chronologie francais : " + annee);

        cld = JapaneseDate.now();
        annee = cld.get(ChronoField.YEAR);
        System.out.println(" année chronologie japonais : " + annee);

        // deuxieme partie

        Facture fac = new Facture("000001");
        System.out.println("affichage date sans formatter : " + fac);
        System.out.println("affichage date avec formatter : " + fac.showInFormat());
        System.out.println("affichage date avec formatterBuilder : " + fac.showInFormatBuilder());
        System.out.println("Temps qui rest : " + fac.resteAvantEcheance());
        System.out.println("Temps qui rest avant fin d'anne : " + fac.resteAvantFinAnnee());
        fac.accept("01 01 2020");
        System.out.println("affichage date avec formatter : " + fac.showInFormat());

        FactureZoneTime facZone = new FactureZoneTime("000001");
        System.out.println(facZone);
    }
}