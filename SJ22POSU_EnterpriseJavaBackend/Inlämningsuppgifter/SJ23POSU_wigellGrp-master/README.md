# SJ23POSU_wigellGrp

Wigell group looking for a new developer and would like you to create a simple api, for present your knowledge


**Funktionella krav:**

Ditt api ska ha funktionalitet för administratörer och medlemmar

**Admin ska kunna utföra följande aktiviteter**

[x] Lista medlemmar GET ”/admin/members” – All data på respektive medlem ska hämtas och visas

[x] Hämta enskild medlem GET ”/admin/members/{id}” – All data på vald medlem ska hämtas och visas

[x] Uppdatera uppgifter PUT ”/admin/members/{id}” – Data för vald medlem ska uppdateras

[x] Lägga till medlem POST ”/admin/members” – Ny medlem ska läggas till i databasen

[x] Ta bort medlem DELETE ”/admin/members/{id}” – Angiven medlem ska raderas från databasen

**Medlemmar ska kunna utföra följande aktiviteter**

[ ] Lista medlemmar GET ”/mypages/members” – firstName, lastName, address, email och phone på samtliga medlemmar ska hämtas och visas

[ ] Uppdatera uppgifter PUT ”/mypages/members/{id}” – Data för den inloggade medlemmen ska uppdateras

**Tekniska krav**

[X] Data ska lagras i en H2 databas och konfigureras så att du lägger in 5 medlemmar i databasen vid start av applikationen. Databasen ska heta memberdb

[X] Allokeringen av utrymme för kolumnerna ska specificeras med lämpliga värden utifrån vilken data som ska lagras

[X] Medlemmarna ska ha följande attribut: id, firstName, LastName, address, email, phone och dateOfBirth. Endast phone ska tillåtas vara null.

[X] Address ska innehålla id, street, postalCode, city. En medlem kan endast ha en adress, men en adress kan kopplas till flera medlemmar

[X]   All kommunikation med api:et ska ske via postmanJava 17 ska användas. Det är valfritt att använda spring boot 2.x eller 3.xProjektet ska skrivas på JPA-nivå

**Betygskrav G**

Api:et fungerar tillfredsställande. Det innebär att minst en av respektive CRUD operation fungerar, samt att minst en av CRUD operationerna för medlemmar fungerar korrekt.
Address är ett separat table i databasen och är kopplat på rätt sätt till en medlem.
Api:et är säkrat med basic security. Åtkomst till admins endpoints är begränsat till användare med rollen admin och medlemmar kan endast komma åt medlemmarnas endpoints
