package com.examples.avance.collections;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class TestEncodage {

    public static void main(String args[]) {
        /**
         * Encodage Basic: chaine traduite sous l'encodage basic
         */
        String str64 = Base64.getEncoder().encodeToString("Ma première chaine codée".getBytes(StandardCharsets.UTF_8));
        System.out.println(str64);

        //décodage
        byte[] tableauOctets = Base64.getDecoder().decode(str64);
        System.out.println(new String(tableauOctets, StandardCharsets.UTF_8));

        /**
         * Encodage URL : la diff entre encodage url et basic , c'est qu' il y des caracteres qui sont protégés dans le cas des urls,
         * parce que dans les URLs il y a des caractères qui ne sont pas bien gérés par l'encodage basic.
         */
        String strURL64 = Base64.getUrlEncoder().encodeToString("serveur/donnee?param=1".getBytes(StandardCharsets.UTF_8));
        System.out.println(strURL64);

        /**
         * Encodage MIME: pour encoder des données binaires
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // queleques chose qui n'est pas du text, non lisible ce qui represent un cas binaire ( exp : des images )
            sb.append(UUID.randomUUID().toString());
        }
        byte[] donnees = sb.toString().getBytes(StandardCharsets.UTF_8);
        String strMIME64 = Base64.getMimeEncoder().encodeToString(donnees);
        System.out.println(strMIME64);
    }
}