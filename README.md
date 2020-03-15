# java-8-features
Demo java 8 features ...

Syntaxe Lambdas : ( utilisée dans les langage fonctionnel)

Elle contient une liste de paramètres, se présente comme une fonction Anonyme ( sans référence à aucune class ).
C’est un moyen d'écrire un code de traitement en java sans pour autant avoir à créer une classe ( tous les traitements en java sont dans les méthodes des class).
() -> {}

Besoin de ces expression Lambdas : le Quand ?

Fournir une expression courte qui n’existe pas et qu'on veut pas créer une class pour elle ( comme nous le savon en java tout est dans la class les méthodes; les membres)
Fournir des prédicats : fonction retourne True / False : simple test.
Fournir des consommateurs : fonction qui accepte une donnée.  

C’est une fonction anonyme qui est faite pour être assez courte, pour être utilisée à un moment donnée ou nous avons besoin ponctuellement de cette fonction/ bien évidemment la fonction n’est pas réutilisable.

Expression Lambda et class Anonyme
Class anonyme : création des objets sans même avoir à nommer la class

L’exemple le plus connu c’est les interface swing java ActionListener

button.addActionListener( new ActionListener() {
	@override
public void actionPerformed(ActionEvent ae){
//// traitement
}});

On a créé un objet de type interface ActionListener alors qu’on dispose pas d’une classe, elle est juste sans nom ( juste il faut implémenter les méthodes de l’interface )


L’utilisation des expressions lambdas :
La plus courte des expression
pas de class a declarer
focalisée sur le traitement à mettre en place
correspond à une interface à une seule méthode 

Avec l'expression Lambdas : button.addActionListener( ae -> // traitement );
Limites Lambdas :
La portée essentiellement des variables : les variables d’une expression lambda n’ont pas un espace propre : confusion des noms avec ceux de la méthode englobante ( variable already defined si j'utilise le même nom de variable/ plus le problème masquer les variable attribut). 

Références des méthodes :
en java les @ des variables ou des fonction ne sont pas manipulables !! évidemment on ne parle pas de pointeur sur une variable ou sur une fonction ( en C++ on peut manipuler directement la mémoire, on peut avoir des accès direct aux fonctions .. contrairement en java jusqu'à la version 8)  

En java 8 on peut fournir aux algorithmes qui en ont besoin directement un accès à des méthodes qui existent déjà , la solution nouvelle peut s’appliquer à des méthodes statiques, des méthodes d'instances et sur des constructeurs. 


Les interfaces fonctionnelles :
C’est une interface avec une seule méthode abstraite, peut contenir d’autres méthodes avec des implémentations par défaut.   


L'implémentation par défaut dans les interfaces
proposer une implantation dans une interface pour des méthodes qui seraient typiquement pas redefine dans les class qui implémentent l’interface

Le but d’une interface fonctionnelle est de définir la signature d’une méthode qui pourra être utilisée pour passer en paramètre :
1 - une référence vers une méthode statique
2 - une référence vers une méthode d’instance
3 - une référence vers un constructeur
4 - une expression lamba (je peux changer l'implémentation dans chaque appel, je suis plus libre)

Il y a quatre types d'interfaces fonctionnelles :
function   : avec une méthode R= apply(T) qui prend un paramètre T et renvoie un paramètre R
predicate : avec une méthode Boolean = test(T) qui prend un paramètre T et renvoie un Boolean
supplier   : avec une méthode T = get() qui renvoie paramètre T
consumer : avec une méthode void = accept(T) qui prend en paramètre T et renvoie rien
