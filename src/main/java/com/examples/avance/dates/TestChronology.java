package com.examples.avance.dates;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.util.Set;

public class TestChronology {

    public static void main(String argc[]) {

        Set<Chronology> listChronlog = Chronology.getAvailableChronologies();
        for (Chronology c : listChronlog) {
            System.out.println(" Chronolgy : " + c);
        }

        Chronology Japanese = Chronology.of("Japanese");
        ChronoLocalDate date = Japanese.dateNow();
        System.out.println(date);
        System.out.println(date.getEra());
        System.out.println("longeur de l'année : " + date.lengthOfYear() + ",  longeur de mois " + date.lengthOfMonth());
    }
}