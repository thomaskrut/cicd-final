# CI/CD och Git i detta project

### Branches
Vi jobbar i feature branches. När du ska börja jobba på en ny feature, kör:  
```$ git checkout -b kort-feature-beskrivning```

### Push
När du skrivit kod som fungerar och som du vill att andra ska kunna merga in i sina feature branches för att
undvika stora merge conflicts längre fram, kör:  
```$ git push```  
Skicka ut ett PM om att du just pushat ny kod, så snart du ser att alla checks gått igenom på Github

### Merge
När andra pushar till sina feature branches eller till main, se till att merga in deras ändringar i din branch:  
```$ git checkout din-branch```  
```$ git merge namn-på-branch```

### Kvalitetskontroll
Eftersom andra mergar in din kod i sina branches, se till att din kod är av hög kvalitet, annars kanske andra
får problem med checks på sina pull requests på grund av brister i din kod. När du pushar körs först en git hook
som säkerställer att dina enhetstester går gröna innan push kan ske. Efter push körs både enhetstester och
integrationstester i Github actions - håll koll på dessa och fixa/pusha innan andra mergar din kod.




