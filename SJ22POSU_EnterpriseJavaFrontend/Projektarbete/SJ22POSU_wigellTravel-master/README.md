# SJ23POSU_wigellTravel
SJ23POSU Grp backen project
Webbportal med spring boot


TO-DO
[X] - valuta växling. från SEK till PLN. en extern källa.


[x] - Hantera kunder
- Kunder ska ha unika ID-nummer, användarnamn och kunduppgifter  som namn och adress
- [ ] Hantera login information (skapa en Entity för login)

[X] - Skapta entiterer på kund information 

[x] - Hantara resor bokningar.

- Uppdatera pris på resor resor/vecka.

-  Namn på hotell  och destination (stad och land)

[x] - Skapta entiterer på Hotel information

[x] - Skapta entiterer på destination (location) information

[X] - Bokningar

- Bokningar ska inkludera avresedatum, destination

[ ] - Säkerhet - spring basic security.  (minst en användare med ROLEN ADMIN rep en för USER)

- Spring security (basic security) ska användas för autentisering och auktorisering.
- Använder informtion sparas i database (MYSQL)
- pwd crypterad med "bcrypt"
- All admin funktionalitet ska kräva att användare är inloggad och har rollen ADMIN.
- All kundfunktionalitet ska kräva inloggning med en användare som har rollen USER.
- Roller för användare ADMIN rep USER. 
- Rätt resurs till repektive endpoint. 
-

## External Dependency ##
- gson
- spring-boot-starter-validation
- log4j
- -modelmapper (Plan to use but didn')


** Bakgrund **
Wigellkoncernen har beslutat att samla några av affärstjänsterna under en portal för enklare
administration och underhåll. Två grupper jobbar med projektet där en grupp ansvarar för
användargränssnittet och en annan för de REST APIer som användargränssnittet kommunicerar med.
Ditt team arbetar med de REST APIer som ska utvecklas med Java Spring Boot
Lansering av portalen sker Söndag 29/10 kl 23:59 så samtliga projekt måste vara inlämnade då!
Kravspecifikation Wigell Travels
Funktionella krav
API:et ska ha funktionalitet för både kunder och admin.

Tekniska krav
Skapa de klasser som behövs för att lösa uppgiften och är vettiga designmässigt från informationen i
kraven.
Strukturera applikationen med lämpliga package så som controller, service, entities osv.
Data ska lagras i en MySQL databas. Databasen ska heta wigellsdb.
Verifiera med postman att alla endpoints går att använda enligt specifikation.
För att visa totalt pris i SEK och Zloth finns två alternativ. 1, du bygger din egen mikrotjänst som
hanterar konverteringen.
[x] 2, du använder en extern källa för konverteringen. Ex Forex öppna API.
Säkerhet


Användarens id och password hämtas från databasen. Lösenorden ska även vara krypterade med
bcrypt

Wigell travels
Systemet ska kunna hantera kunder, resor, bokningar. Resorna ska ha pris per vecka,. Kunder ska ha unika ID-nummer, användarnamn och kunduppgifter
som namn och adress. Bokningar ska inkludera avresedatum, destination, namn på hotell och
totalpris. Priset ska presenteras i SEK och Zloty.
Kunder
Kunderna ska kunna göra ett antal aktiviteter med följande endpoints:
• Lista resmål GET /api/v1/trips
[x] Lista på alla resemål (land/hotel/pris)

• Boka resa POST /api/v1/trips
[x] Boka en resa 

• Uppgradera resa PUT /api/v1/trips/{id}
[x] upgradera resa eller göra en förändring av resa

• Se tidigare och aktiva bokningar GET /api/v1/trips/{id}
[x] Lista över alla bokningar

Admin
Administratörer ska kunna göra ett antal aktiviteter med följande endpoints:
• Lista kunder GET /api/v1/customers


• [x] Lägga till kund POST /api/v1/customers
• [x] Ta bort kund DELETE /api/v1/customers/{id}
• [x] Uppdatera kund PUT /api/v1/customers/{id}
• [x] Lägga till resmål POST /api/v1/destinations
• [x] Ta bort resmål DELETE /api/v1/destinations/{id}
• [x] Uppdatera resmål PUT /api/v1/destinations/{id}
• [x] Lista resmål GET /api/v1/trips
Viktigt att alla endpoints följer specifikationen eftersom de ska fungera med användargränssnittet.

Loggning
Applikationen ska logga info till fil när något skapas, ändras eller tas bort. Skriv ett meddelande som
talar om vad som händer t.ex. ”admin created destination xxx”,
[ ] - Log4J är ett krav 
    [x] - console log
    [ ] - log till fil 

Övrigt
Ingen frontend ska implementeras. All kommunikation med API:et ska ske via Postman
[ ] API:et ska nås på port 8585
[X] Java 17 ska användas, valfri version av spring boot
[-] Lombok är ej tillåtet att använda
[ ] Se till att det finns minst 5 kunder och 5 resmål i databasen vid applikationens start
[X] Strukturen på API:et ska följa spring data jpa
