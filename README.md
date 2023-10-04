# CI/CD och Git i detta project

### Branches
Vi jobbar i feature branches. När du ska börja jobba på en ny feature, kör:  
```$ git checkout -b kort-feature-beskrivning```

### Push
När du skrivit kod som fungerar och som du vill att andra ska kunna merga in i sina feature branches för att undvika stora merge conflicts längre fram, kör:  
```$ git push```  
Skicka ut ett PM om att du just pushat ny kod.

### Merge
När andra pushar till sina feature branches eller till main, se till att merga in deras ändringar i din branch:  
```$ git checkout din-branch```  
```$ git merge namn-på-branch```

### Kvalitetskontroll
För att koden du pushar ska hålla god standard vad gäller enhetstester




