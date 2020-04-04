# java-8-features
Les points importants dans La version Java 8

# Syntaxe Lambdas : ( utilisée en langage fonctionnel)

Elle contient une liste de paramètres, se présente comme une fonction Anonyme ( sans référence à aucune class ).
C’est un moyen d'écrire un code de traitement en java sans pour autant avoir à créer une classe ( tous les traitements en java sont dans les méthodes des class).
() -> {}

## Besoin de ces expressions Lambdas : le Quand ?

Fournir une expression courte qui n’existe pas et qu'on veut pas créer une class pour elle ( comme nous le savons, en java tout est dans les clas: les méthodes, les membres)
Fournir des prédicats : fonction retourne True / False : simple test.
Fournir des consommateurs : fonction qui accepte une donnée.  
d'une maniere général elle est utlisée pour les interfaces fonctionnelles ( fonctions, predicates, consumers et suppliers ).

C’est une fonction anonyme qui est faite pour être assez courte, pour être utilisée à un moment donnée ou nous avons besoin ponctuellement de cette fonction/ bien évidemment la fonction n’est pas réutilisable.

# Expression Lambda et class Anonyme
Class anonyme : un moyen de créer des objets sans même avoir à nommer des class

L’exemple le plus connu c’est les interface swing java ActionListener

```
button.addActionListener( new ActionListener() {
	@override
public void actionPerformed(ActionEvent ae){
//// traitement
}});
```

On a créé un objet de type interface ActionListener alors qu’on dispose pas d’une classe, elle est juste sans nom ( juste il faut implémenter les méthodes de l’interface, tous les methodes disponibles )


### L’utilisation des expressions lambdas
C'est la plus courte des expression
On a pas une class a declarer
On focalise sur le traitement à mettre en place
Corresponde à une interface avec une seule méthode 

Avec l'expression Lambdas : button.addActionListener( ae -> // traitement );
### Limites Lambdas
La portée essentiellement des variables : les variables d’une expression lambda n’ont pas un espace propre :
confusion des noms avec ceux de la méthode englobante ( variable already defined si j'utilise le même nom de variable/ plus le problème masquer les variable attribut).

### Références des méthodes
en java les @ des variables ou des fonctions ne sont pas manipulables !! évidemment on ne parle pas de pointeur sur une variable ou sur une fonction ( en C++ on peut manipuler directement la mémoire,
on peut avoir des accès direct aux fonctions .. contrairement en java jusqu'à la version 8)

En java 8 on peut fournir aux algorithmes qui en ont besoin directement un accès à des méthodes qui existent déjà , la nouvelle approche peut s’appliquer à des méthodes statiques, des méthodes d'instances et sur des constructeurs.

En ce qui concerne le cas d'usage, lorsqu'une expresion lambdas devient trop long(volumineuse), ou quelle doit etre réutilisée à plusierus emplacement dans l'application,
on peut deplacer son contenu dans une fonction et de simplement appeler cette fonction dans le corps de l'expression lambdas ( toutefois il faut bien respecter la signature de la methode )

# Les interfaces fonctionnelles
C’est une interface avec une seule méthode abstraite, peut contenir d’autres méthodes avec des implémentations par défaut.   


### L'implémentation par défaut dans les interfaces
proposer une implantation dans une interface pour des méthodes qui seraient typiquement pas redefine dans les class qui implémentent l’interface

Le but d’une interface fonctionnelle est de définir la signature d’une méthode qui pourra être utilisée pour passer en paramètre :
*  une référence vers une méthode statique
*  une référence vers une méthode d’instance
*  une référence vers un constructeur
*  une expression lamba (je peux changer l'implémentation dans chaque appel, je suis plus libre de choisir l'implementation que je veux)

### Il y a quatre types d'interfaces fonctionnelles
* ```function<T,R>```   : avec une méthode ```R= apply(T)``` qui prend un paramètre ```<T>``` et renvoie un paramètre ```<R>```
* ```predicate<T>``` : avec une méthode ```Boolean = test(T)``` qui prend un paramètre ```<T>``` et renvoie un ```<Boolean>```
* ```supplier```   : avec une méthode ```T = get()``` qui renvoie paramètre ```<T>```
* ```consumer<T>``` : avec une méthode ```void() = accept(T)``` qui prend en paramètre ```<T>``` et renvoie rien

# Optional<T>
Probleme : Comment exprimer l'abscence d'une valeur pour une variable. Au lieu d'utiliser une valeur de retour fixe dans certains cas de figure pour designer cette abscence.
	
Solution : Optional<T> est utliser pour encapsuler une valeur de type T, cette valeur peut etre abscente:
Methodes :
* ```isPresent()``` pour tester la presence de la valeur
* ```get()``` pour recuperer la valeur si elle existe

Consturction d'un objet de type Optional

* ```of(T)``` : construire un objet de type Optional a partir d'une valeur non nul (lance un exception si la valeur est null)
* ```ofNullable(T)``` : construire un objet de type Optional a partir d'une valeur qui peut etre non valide (non existante)
* ```empty()``` : constuire un Optional vide

Recuperation de la valeur :

* ```get()``` : bien sur
* ```orElse()``` : qui prend un parametre et retourner la valeur , mais si pas de valeur va retourner ce qui a été passé en parametre
* ```orElseGet()```: meme chose mais en parametre on passe un Supplier
* ```orElseThrow()```: meme chose , sinon on retourne une exception

# Générique
Rq : l'héritage n'est pas possible avec les génériques, nous savons qu'avec une variable d'un certain type nous pouvons référencer 
une instance de meme type mais aussi une instance de ses sous types.
```
Personne p;
Client c;
c = new Client();
p = c;
p.setNom()...
p.setPrenon()...
```
avec les classes génrique ce n'est pas possible
```
ListeGenerique<Personne> listePersonnes;
ListeGenerique<Client> listeClients;
listeClients = new ListeGenerique<Client>(10);
listePersonnes = listeClients !!!! erreur imcompatible types
```
Cette erreur est liée au mecanisme d'effacement de type utilisée par le compilateur.
Pour remédier à cette situation nous pouvons utiliser l'operateur Joker ```<?>```.
Si nous l'utilisons tout seul ```<?>``` nous pouvons accéder suelement aux methodes de la class ```Object```.
Pour cela on peut ajouter une contrainte pour desinger les types parametre a utiliser
```methode(ListeGenerique<? extends Personnes> list)```.
######  Limitation
* le type arguement de type parametre ```<T>``` ne peut pas etre un type primitif(il faut utiliser les wrapper sinon).
* le type parametre ```<T>``` ne peut pas etre utilisé pour creer une instance new T() à l'interieur de la calsse generique.
* le type parametre ```<T>``` ne peut pas etre utilisé pour déclarer des variables static dans la class generique.
* l'operateur ```instanceOf``` ne peut pas etre utilisé puisque le compilateur utilise le principe d'effacement de type.