# CI/CD och Git i projektet

### Branches
Vi jobbar i feature branches. När du ska börja jobba på en ny feature, kör:  

```$ git checkout -b kort-feature-beskrivning```

### Commit
Commita ofta och med tydliga meddelanden:  

``` $ git commit -am "beskrivning av vad du har ändrat/lagt till/tagit bort"```

### Push
När du skrivit kod som fungerar, som följer våra riktlinjer för clean code och formattering (se *Kvalitetskontroll* nedan)
och som du vill att andra ska kunna merga in i sina branches för att
undvika stora merge conflicts längre fram, kör:  

```$ git push```  

Skicka ut ett PM om att du just pushat ny kod, så snart du ser att alla checks gått igenom i Github actions

### Merge
När andra pushar till sina feature branches eller till main, se till att merga in deras ändringar i din branch:  

```$ git checkout din-feature-branch```  

```$ git merge namn-på-branch```

### Kvalitetskontroll
Eftersom andra mergar in din kod i sina branches, se till att din kod är av hög kvalitet, annars kanske andra
får problem med checks på sina pull requests orsakade av brister i din kod. När du pushar körs först en git hook
lokalt som säkerställer att dina enhetstester går gröna innan push kan ske.  

Efter push körs både enhetstester och
integrationstester på din kod i Github actions - håll koll på dessa, lös eventuella problem och pusha på nytt innan
andra får merga din kod. Sträva efter hög täckning vad gäller tester, se *Pull requests* nedan.  

Test coverage
kontrolleras endast vid pull request, vilket innebär att det är upp till var och en att se till att coverage för
egen kod är så hög som möjligt. Kontrollera täckningen i ditt repo genom att köra:

```$ ./gradlew jacocoTestreport```

Rapporten hittar du sedan här: build/reports/jacoco/test/html/index.html. Total coverage bör ligga över 60%, respektive 80% för
de klasser du arbetat med.

Se separata riktlinjer för kodformattering, namngivning, importer med mera. Vi använder Checkstyle för att kontrollera
att reglerna följs - en build lokalt eller vid push kommer fallera om det finns några varningar, håll därför koll
på om din kod följer vår standard genom att regelbundet köra dessa kommandon:  

```$ ./gradlew checkstyleMain```  

```$ ./gradlew checkstyleTest```  

```$ ./gradlew checkstyleIntTest```

Eller kontrollera hela bygget med:  

```$ ./gradlew build```



### Integrationstester
Tester som gör nätverksanrop mot körande applikation ligger under mappen intTest. Dessa körs i Github actions
vid push och innan kod kan mergas till main. Kör dessa tester lokalt innan du pushar för att undvika att
dina checks fallerar i Github actions. Starta din applikation och kör sedan:  

```$ ./gradlew integrationTest```

### Pull requests
När du är färdig med en feature, pusha och skapa en pull request mot main. Följande kriterier måste uppfyllas för
att branchen ska kunna mergas:

- Enhetstester går igenom  
- Integrations/systemtester går igenom  
- Checkstyle har 0 varningar
- Test coverage är över 60% på hela projektet  
- Test coverage är över 80% på de filer du arbetat i  
- En senior utvecklare har granskat och godkänt din kod  
- En serior utvecklare har gjort manuella tester av deployment av applikationen till testmiljö  

Om din pull request inte uppfyller alla kriterier, fixa och pusha igen. Om du inte kan lösa problemet, be en senior utvecklare
om hjälp. När alla kriterier är uppfyllda kan en senior utvecklare merga din branch till main.




