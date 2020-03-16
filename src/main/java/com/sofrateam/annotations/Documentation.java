package com.sofrateam.annotations;

import java.lang.annotation.*;

//@Target(ElementType.METHOD) // pour etre applicable sur les methodes seulement
//@Target(ElementType.TYPE) // pour etre applicable sur les Type seulement ie Class
//@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Documentations.class) // utiliser plusieurs fois sur le meme element
public @interface Documentation {
    // Les attributs de l'annotation
    String auteur();

    String date();

    int version() default 1;

    String[] responsable();
}

