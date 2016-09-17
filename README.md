#Pancake puzzle

Ez a kis projekt a 2016. évi nyári szakmai ösztöndíjhoz készült. Segítségével a pancake puzzle nevű probléma egy megoldását tudjuk megkeresni, egy erre a célre leimplementált A* algoritmus segítségével.

##Követelmény
A program lefordítható és működőképes minden olyan környezetben, ahol rendelkezésre állnak a következőek:
* JDK, minimum 1.8-as verziószámmal
* Apache Maven

##A projekt fordítása és indítása
A projekt mappájában adjuk ki a következő parancsot:
```
mvn package
```
Ezzel létrejön egy `target` mappa, azon belül pedig egy futtatható JAR állomány, melynek neve -jar-with-dependencies.jar végződésű lesz. Futtatni például az alábbi módon tudjuk:
```
java -jar target/pancake-puzzle-1.0-SNAPSHOT-jar-with-dependencies.jar
```

##Problémák megadása
A futó program a standard bemenetről olvas be tetszőleges számú problémát, az alábbi formában:
```
palacsinták száma
kezdő állapot
célállapot
```
A két állapot megadása szóközzel elválasztott számok felsorolásával történik, a számsorozat eleje a képzeletbeli palacsintás tányér teteje, a vége pedig az alja. Íme egy példa probléma:
```
5
2 4 1 5 3
1 2 3 4 5
```
Így a fent látható módon a program futtatásakor tetszőleges számú problémát begépelhetünk, de a problémáinkat akár egy szöveges fájlba is feljegyezhetjük, majd azt beirányíthatjuk a program bemeneteként. Az `inputs` mappán belül található egy `sample.in` nevű állomány, ami tartalmaz néhány példa problémát. Így a program akár az alábbi módon is futtatható:
```
java -jar target/pancake-puzzle-1.0-SNAPSHOT-jar-with-dependencies.jar < inputs/sample.in
```

##Aktuális
A program már képes tetszőleges problémát beolvasni, de csak helyesen megadott adatok esetén működik!