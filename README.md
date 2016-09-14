#Pancake puzzle

Ez a kis projekt a 2016. évi nyári szakmai ösztöndíjhoz készült. Segítségével a pancake puzzle nevű probléma egy megoldását tudjuk megkeresni, egy erre a célre leimplementált A* algoritmus segítségével.

##Követelmény
A program lefordítható és működőképes minden olyan környezetben, ahol rendelkezésre állnak a következőek:
* JDK, minimum 1.8-as verziószámmal
* Apache Maven

##A program használata
A projekt mappájában adjuk ki a következő parancsot:
```
mvn package
```
Ezzel létrejön egy `target` mappa, azon belül pedig egy futtatható JAR állomány, melynek neve -jar-with-dependencies.jar végződésű lesz. Futtatni például az alábbi módon tudjuk:
```
java -jar target/pancake-puzzle-1.0-SNAPSHOT-jar-with-dependencies.jar
```

##Aktuális
A program jelenleg egy bedrótozott probléma megoldását adja vissza, hamarosan saját problémát is meg lehetlesz adni!