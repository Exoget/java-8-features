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

# API Stream
Classe introduite dans java 8 sous le package ```java.util.stream```.
```Stream``` est un objet qui represente un ensemble d'opérations, se base sur l'enchainement de plusieurs oépration appliquées en pipeLine
( recréer un flux à partir d'un autre flux ).
Le point de dépard est un conteneur ( quelque chose qui donne accés aux données ) souvent c'est des collections.
```maListe.stream().operation```.

```pipeline``` ensemble de transformations qui sont liées les unes aux autres.
* Des opérations intermidiaires
* Une opération terminale

```
maListe.stream() // récupération d'un objet Stream
          .filter(s-> s.length() > 5) // filtre des chaines
          .forEach(System.out::println) // affichage
```
          
L'ordre est trés important :
* point de vue résultat obtenu
* point de vue perfermance obtenu
Selon comment on va enchaîner les oéprations on oblige le compilateur à générer certains nombre d'opérations qui nous dépassent, les impact, inconvénients ).

#### Pourquoi 
* code plus clair, lisible.
* mise en oueuvre du parallélisme.
* éfficacité due à l'enchainement des oéprations qui ne détiennent pas d'état (filtre) ne cherche pas à executé du code en avance puisque le code va etre
déclancher lorsqu'on trouve l'operation terminal.

##### BaseStream<> interface
C'est l'interface de base de toutes les interfaces Stream. Elle est générique elle corresponde au type de données que vous générer.
Les méthodes : 
* ```close()``` Fermeture
* ```parallel(), isParallel``` Parallélisme
* ```sequential()``` En séquence
* ```iterator(), spliterator()``` Itération
* ```unordered()``` sans contrainte sur l'ordre, particulierement intéressante puisque on peut avoir un bénéfice si on libere la contrainte d'ordre
au moment d'execution des operations cela pourrait être rendu de manière plus efficace.


##### Stream<> interface
C'est l'interface représentatif , sous interface de BaseStream. Une interface dédier aux objects.
L'objet Stream peut etre obtenu à partir d'une source ( tableau, collection, fonction génératrice, canal IO ..)  
Les opérations sans etats: l'opération qui est declanché va transformé le flux mais fournit un nouveau flux à partir d'un premier.
Le Stream est déclanché une seule fois. Peut se faire en séquentielle ou en parallele.

##### Interface Spécialisées
elles concernent les types prémétifs : ```DoubleStream,IntStream, LongStream```

##### Stream.Builder
Existent aussi pour les interfaces spécialisées : DoubleStream.Builder, IntStream.Builder ...
Permet de créer un Stream et de le modifier avant d'appliquer les oéprations.
```
DoubleStream.Builder  b = DoubleStream.builder();
// construction de flux en amont
b.accept(1.1);
b.accept(2.2);
b.accept(3.3);
// on peut decaler l'alimentation de Stream de l'appilcation de la methode
b.build().forEach(System.out::println);
```
Le Stream sera générer lors de l'appel de ```build()```.
##### Les Opérations
Méthodes intermédiaires : qui reproduissent des flux ( en général avec un accées restrainte : transformer limité au flux d'origine).

* ```distinct``` : retourne un Stream avec des élements distincts
* ```filter(Predicate)``` : va nous retourner un Stream dont les élement correspondent au prédicat.
* ```flatMap(Function)``` : va nous fournir un Stream dont les élements sont remplacés par les elements du Stream fournit par la fonction.
* ```limit(long)``` : va nous fournir un obejt Stream mais limité en nombre d'élements.
* ```map(Function)``` : va nous fournir un Stream dont les élements sont l'application de la fonction à chaque élement.
* ```peek(Consumer)``` : va nous fournir un Stream dont les élements sont les memes, mais la fonction est appliquée à chaque élément.
* ```skip(long)``` : va nous fournir un flux dont les élements sont les memes, sauf en réalité ce sont les éléments ceux qui restent aprés l'élimination des premiers.
* ```sorted()``` : va nous fournir un Stream dont les élements sont triés dans l'ordre naturel ( ou avec des parametres comparateurs ).

Méthodes terminales : vont produire un résulat ( ne produissent pas un flux).
* ```allMatch(Predicate)``` : retourne vrai si chaque élément vérifie le prédicat.
* ```anyMatch(Predicate)``` : retourne vrai si l'un des éléments vérifie le prédicat.
* ```findAny()``` : retourne un Optional qui représente un des éléments du Stream.
* ```findFirst()``` : retourne un Optional qui représente le premier éléments du Stream.
* ```noneMatch(Predicate)``` : retourne vrai si aucun élément ne vérifie le prédicat.
* ```forEach(Consumer)``` : applique la fonction sur chacun des éléments.
* ```reduce(BinaryOperator)``` : réduit les éléments en les accumulant grace à la fonction fournie, retourne un Optional.

Classe Collectors : fournit des methodes qui facilite un peut les réduction ( les transformations des données du flux en quelque chose de plus réduit)
classe de service dans le package java.util.Stream.
Méthodes : ```averaging(), counting(), groupingBy(), joining(), partitioningBy(), summing(), toMap(), toSet() ..```

# API Date
La gestion des dates a été complètement revu, on est passé d'une classe ```Date``` dans le package ```java.util``` à une organisation beaucoup mieux faite, des classes de dates
des classes du zone, des classes du durée, des classes de periode etc...
* Objectif de l'API Date : tous est dans le package ```java.time```, les classes sont des ```immutable value``` ( exp: les classes String. ce sont des classes qui correpondent a des objets 
que vous ne pouvez pas modifier) ce sont des classe organisées de tel facon que lorsqu'on cherche a modifier les données qui sont dans ces classes, on vous recrée entièrement un nouvel objet 
qui va prendre en compte ces modifications. Du fait que ces classes sont immutables, on aura pas de problemes avec le multithreading car les thread ne peuvent pas modifier les donnée à l'interieur des objets.

* ```LocalDate```, ```LocalTime```, ```LocalDateTime``` : gérant une date locale , methode de création : ```now, of, from, parse```.
tres util lorsqu'on travail sur une poste isolée
Les modifications des données se font via l'operateur ```with```.
```
//Set the value, returning a new object
LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);								
/* You can use direct manipulation methods, or pass
a value and field pair */
LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
```
				
Les ```Ajusteurs```, certains sont des standards et on peut créer nos propre ajusteurs
```
//importation static
import static java.time.temporal.TemporalAdjusters.*;

LocalDateTime timePoint = ...
foo = timePoint.with(lastDayOfMonth()); // importation static
bar = timePoint.with(previousOrSame(ChronnoUnit.WEDNESDAY)); // importation static
//using value classes as adjusters
timePoint.with(LocalTime.now());
```
avec la possibilité de tronquer les infos.
```
LocalTime truncedTime = time.trancatedTo(ChronoUnit.SECONDS);
```
* Classe de zone : zone horaire lorsqu'on an va gerer des heures dans des zones différentes.
une zone peut etre representée par une chaine de caractere
```
you can specify the zone id when creating a zoned date time
ZoneId id = ZoneId.of("Europe/Paris");
ZonedDateTime zoned = ZonedDateTime.of(dateTime, id);//ZonedDateTime est date / heure avec les informations de zone
assertEquals(id, ZoneId.from(zoned));
```
offset c'est le decalage par rapport au temp universel, OffsetDateTime/OffsetTime.

```
OffsetTime time = OffsetTime.now();
// changes offset, while keeping the same point on the timeline
OffsetTime sameTimeDifferentOffset = time.withOffsetSameInstant(offset);

```
* Class ```Period```, ```Duration``` : pour noter les durées de l'ordre jours-mois-années( Period ) ou de l'ordre heure, minutes (Duration) c'est plus précis que la periode.
```
// 3 years, 2 months, 1 day
Period period = Period.of(3, 2, 1);
//You can modify the values of dates using periods
LocalDate newDate = oldDate.plus(period);
```
* Les Chronologies dans ```java.time.chrono``` une interface Chronology qui represent un systeme calendaire ( qui sont pas standard au sens de norme ISO).
 ```
 Chronolgy : ISO
 Chronolgy : Hijrah-umalqura
 Chronolgy : ThaiBuddhist
 Chronolgy : Minguo
 Chronolgy : Japanese
```
* formatages des dates: a partir d'une date ou heure on va sortir une chaine de caractère ou l'inverse.
le package ```java.time.format``` fourni des classes pour afficher et parser des dates, contient deux classes :```DateTimeFormatter``` et ```DateTimeFormatterBuilder```.
```
// recupération d'un texte a partir d'une date
LocalDate date = LocalDate.now();
String chaine = date.format(formatter);
// recupération d'une date a partir d'un texte
LocalDate parsedDate = LocalDate.parse(text, formatter)
```

Dans le cas ou on a un format trés spécifique on passe par le Builder.
```
DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("New Year In").appendValue(ChronoField.YEAR)
.appendLiteral("is on")
.appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
.toFormatter();
```