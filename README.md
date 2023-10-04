# CI/CD och Git i projektet

### Branches
Vi jobbar i feature branches. När du ska börja jobba på en ny feature, kör:  
```$ git checkout -b kort-feature-beskrivning```

### Commit
Commita ofta och med tydliga meddelanden:  
``` $ git commit -am "beskrivning av vad du har ändrat/lagt till/tagit bort"```

### Push
När du skrivit kod som fungerar och som du vill att andra ska kunna merga in i sina branches för att
undvika stora merge conflicts längre fram, kör:  
```$ git push```  
Skicka ut ett PM om att du just pushat ny kod, så snart du ser att alla checks gått igenom i Github actions

### Merge
När andra pushar till sina feature branches eller till main, se till att merga in deras ändringar i din branch:  
```$ git checkout din-branch```  
```$ git merge namn-på-branch```

### Kvalitetskontroll
Eftersom andra mergar in din kod i sina branches, se till att din kod är av hög kvalitet, annars kanske andra
får problem med checks på sina pull requests orsakade av brister i din kod. När du pushar körs först en git hook
lokalt som säkerställer att dina enhetstester går gröna innan push kan ske. Efter push körs både enhetstester och
integrationstester på din kod i Github actions - håll koll på dessa, lös eventuella problem och pusha på nytt innan
andra får merga din kod. Sträva efter hög täckning vad gäller tester, se *Pull requests* nedan.

### Integrationstester
Tester som gör nätverksanrop mot körande applikation ligger under mappen intTest. Dessa körs i Github actions
vid push och innan kod kan mergas till main. Kör dessa tester lokalt innan du pushar för att undvika att
dina checks fallerar i Github actions. Starta din applikation och kör sedan:  
```$ ./gradlew integrationTest```

### Pull requests
När du är färdig med en feature, pusha och skapa en pull request mot main. Följande kriterier måste uppfyllas för
att branchen ska kunna mergas:

1.[ ] Enhetstester går igenom
2.[ ] Integrations/systemtester går igenom
3.[ ] Test coverage är över 60% på hela projektet
4.[ ] Test coverage är över 80% på de filer du arbetat i
5.[ ] En senior utvecklare har granskat och godkänt din kod
6.[ ] En serior utvecklare har gjort manuella tester av deployment av applikationen till testmiljö  

Om din pull request inte uppfyller alla kriterier, fixa och pusha igen. Om du inte kan lösa problemet, be en senior utvecklare
om hjälp. När alla kriterier är uppfyllda kan en senior utvecklare merga din branch till main.




