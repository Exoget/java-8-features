package com.examples.bases.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesterRegex {

    // regarde livre page 323 tableau Regex
    public static void main(String[] args) {

        Pattern p = Pattern.compile("honou?r");
        String sUK = "For Brutus is an honourable man";
        String sUS = "For Brutus is an honorable man";

        Matcher mUK = p.matcher(sUK);
        Matcher mUS = p.matcher(sUS);

        System.out.println("Ortographe UK ? " + mUK.find());
        System.out.println("Ortographe US ? " + mUS.find());


        // on peut ajouter une regex dans l'étape filtre de Stream() , asPredicate() methode ajouté dans java 8
    }
}
