# Test- och branchstrategi

## Branches
I detta projekt jobbar vi med featurebranches som mergas till main när de är klara. Målet är att main
alltid ska innehålla produktionsduglig och vältestad kod och deployment till produktion sker så ofta som
möjligt. Feature branches är kortlivade, mellan en till tre dagar beroende på feature, och tas bort efter
merge till main. Större features bör delas upp på flera branches.

## Tester
### Enhetstester
Varje utvecklare skriver enhetstester för den kod han eller hon utvecklar. Enhetstestern bör kompletteras
med integrationstester där det är relevant. Dessa tester körs lokalt i utvecklingsmiljön under arbetet samt
automatiskt (för enhetstester) innan push med hjälp av en Git hook. I pipeline körs enhetstester vid push
och pull request. Eftersom övriga i teamet hela tiden mergar in ny kod som pushats i sina brancher behöver
den vara testad innan den delas.

### Integrationstester
Integrationstester körs kontinuerligt under utvecklingsarbetet men vad gäller tester som går över nätverk
mot körande applikation finns ingen automatisering lokalt; det är upp till utvecklaren att se till att
applikationen integrerar mot övriga system innan kod pushas till Github, där sedan integrationstester
körs i actions.

### Systemtester
Vid pull request görs, förutom automatiserade enhets- och integrationstester, en automatisk deploy till
testmiljö i form av en Azure Web App. Länken till denna hamnar som en kommentar till pull requesten, så att
man i samband med code review kan gå in och manuellt testa applikationen.

### Acceptanstester
Kod som mergats till main deployas automatiskt till en annan testmiljö där den genomgår ytterligare
manuella acceptanstester för att säkerställa att affärslogik och användarkrav uppfylls innan den går
i produktion.