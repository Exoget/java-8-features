package com.examples.knowledge;

import static com.examples.knowledge.Saisons.*;

public class ImportStaticKB {

    public interface A {
        Object cons1 = "val1";
        Object cons2 = "val2";
        Object cons3 = "val3";

        void method1();

        void method2();
    }

    /**
     * Parfois il vaut mieux utiliser un import static des constants depuis une classe/enum que les définir au niveau
     * d'une interface, le passage par une interface nécessite l'implémentation des méthodes qui viennent avec.
     * Cependant il est toujours possible de passer par les interfaces, regardez interface ObjectStreamConstants.
     */

    public String getSaison() {
        // import static accès direct
        return PRINTEMPS.toString();
    }
}
