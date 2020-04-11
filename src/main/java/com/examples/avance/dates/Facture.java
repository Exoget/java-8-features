package com.examples.avance.dates;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

public class Facture {

    private String numero;
    private LocalDate date;
    private LocalDate dateEcheance;

    // l'echance pour tous les facture c'est deux mois
    private static final Period DUREEMAX = Period.of(0, 2, 0);
    /*
    Pattern YYYY-MM-DD'T'hh:mm'Z' is wrong:
    YYYY - week-based-year       wrong: use uuuu year
    MM - month-of-year
    DD - day-of-year       wrong: use dd day-of-month
    hh - clock-hour-of-am-pm (1-12)       without AM/PM you probably want HH hour-of-day (0-23)
    mm - minute-of-hour
     */
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    private DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder()
            .appendLiteral("Le ").appendValue(ChronoField.DAY_OF_WEEK)
            .appendLiteral(" Du mois n° ").appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral(" De l'an ").appendValue(ChronoField.YEAR);
            //.appendLiteral(" Le Jour ").appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE);


    public Facture(String numero) {
        this.numero = numero;
        date = LocalDate.now();
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

    public String showInFormat() {
        return "Facture[" +
                "numero='" + numero + '\'' +
                ", date=" + date.format(formatter) +
                ", dateEcheance=" + dateEcheance.format(formatter) +
                ']';
    }

    public String showInFormatBuilder() {
        return "Facture[" +
                "numero='" + numero + '\'' +
                ", date=" + date.format(formatterBuilder.toFormatter()) +
                ", dateEcheance=" + dateEcheance.format(formatterBuilder.toFormatter()) +
                ']';
    }

    public void accept(String text) {
        date = LocalDate.parse(text, formatter);
    }

    public long resteAvantEcheance() {
        //Todo imprtation static a voir
        return LocalDate.now().until(dateEcheance, DAYS);
    }

    // ajouter un adjuster pour faire des calcules plus complexes
    public long resteAvantFinAnnee() {
        //Todo imprtation static a voir
        return LocalDate.now().until(dateEcheance.with(lastDayOfYear()), DAYS);
    }
}