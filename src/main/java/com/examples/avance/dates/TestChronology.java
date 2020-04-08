package com.examples.avance.dates;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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


        // partie internalisation
        LocalDateTime birth = LocalDateTime.of(1988, 10, 12, 6, 10, 0);
        HijrahDate hdate = HijrahDate.from(birth);
        System.out.println(hdate);

        JapaneseDate jdate = JapaneseDate.from(birth);
        System.out.println(jdate);

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(birth.format(formatter));

        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(birth.format(formatter));
    }
}