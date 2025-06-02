# 🍽️ Aplicație Food Delivery – Proiect Java (PAOJ)

Acest proiect reprezintă o aplicație de tip Food Delivery, dezvoltată în limbajul Java, ca parte a temei de semestru pentru disciplina Programare Avansată pe Obiecte (PAO). Aplicația permite gestionarea utilizatorilor, restaurantelor, produselor, comenzilor și recenziilor, cu persistența datelor în PostgreSQL și un sistem de audit pe fișier CSV.

---

## 🧰 Tehnologii utilizate

- Java 
- JDBC (Java Database Connectivity)
- PostgreSQL
- pgAdmin 4 v7.5
- IntelliJ IDEA
- PL/SQL (pentru manipularea datelor în pgAdmin)
- OOP + Design Pattern: Singleton

---

## ✅ Funcționalități implementate

- ✅ Înregistrarea și autentificarea utilizatorilor
- ✅ Adăugarea de produse în coșul de cumpărături
- ✅ Plasarea comenzilor cu opțiuni de plată (numerar/card)
- ✅ Salvarea comenzilor și afișarea istoricului
- ✅ Adăugarea de recenzii pentru restaurante
- ✅ Persistență cu PostgreSQL pentru următoarele entități:
  - `Card`
  - `Produs`
  - `Review`
  - `Cod`
- ✅ Operații CRUD pentru clasele de mai sus
- ✅ Serviciu de audit: scriere în fișier CSV pentru fiecare acțiune semnificativă

---

## 🗂️ Structura proiectului

```
src.com.unibuc.pao.proiect
├── audit
  ├── AuditService
├── model
  ├── cardCredit
  ├── Cod
  ├── Comanda
  ├── Cos
  ├── Persoana
  ├── Produs
  ├── Restaurant
  ├── Review
  ├── User
├── service
  ├── CardService
  ├── CodService
  ├── DBConnection
  ├── ProdusService
  ├── Service
  ├── UserService
├── ui
  ├── Main
audit.csv
README.md       
```

---

## 🛠️ Configurare bază de date PostgreSQL

1. Creează o bază de date:  
   `food_delivery`

2. Creează tabelele corespunzătoare:

```sql
CREATE TABLE card (
  id SERIAL PRIMARY KEY,
  numar_card VARCHAR(50),
  tip_card VARCHAR(50),
  cvv varchar(3)
);

CREATE TABLE codes (
  id SERIAL PRIMARY KEY,
  cod VARCHAR(10),
  valabilitate VARCHAR(50)
);

CREATE TABLE cos (
  id SERIAL PRIMARY KEY,
  nume VARCHAR(50),
  pret DOUBLE PRECISION,
  disponibilitate VARCHAR(50),
  restaurant_id INTEGER
);

CREATE TABLE produs (
  id SERIAL PRIMARY KEY,
  nume VARCHAR(50),
  pret DOUBLE PRECISION,
  disponibilitate VARCHAR(50)
);

CREATE TABLE review (
  id SERIAL PRIMARY KEY,
  scor DOUBLE PRECISION,
  comentariu VARCHAR(100)
);

CREATE TABLE utilizator (
  id SERIAL PRIMARY KEY,
  nume VARCHAR(50),
  prenume VARCHAR(50),
  varsta INTEGER,
  oras VARCHAR(50),
  strada VARCHAR(50)
);
```

3. Asigură-te că ai adăugat driver-ul JDBC în IntelliJ:  
   `File > Project Structure > Libraries > + > From Maven > org.postgresql:postgresql:42.7.1`

4. Configurează conexiunea în clasa `DBConnection`:

```java
String url = "jdbc:postgresql://localhost:5432/food_delivery";
String user = "postgres";
String password = "parola_ta";
```

# Operațiile CRUD pe clase

## Pentru clasa Cod:
1. Create:  `Se alege 20 din meniul interactiv -> Se introduce un cod (GLOVO10) -> Se verifica modificarile in baza de date.`
   
2. Read: `Se alege 21 din meniul interactiv -> In backend se face un call la baza de date pentru a prelua codurile -> utilizatorul observa cum apar toate codurile salvate.`
   
3. Update: `Se alege 22 din meniul interactiv -> Se alege indexul codului pe care vrem sa il modificam -> Introducem noile date care voi inlocui datele vechi -> Se verifica modificarile in baza de date.`

4. Delete: `Se alege 23 din meniul interactiv -> Se alege indexul codului pe care vrem sa il stergem -> Se verifica modificarile in baza de date.`


## Pentru clasa Card:
1. Create: `Se alege 13 din meniul interactiv -> Se introduc datele corespunzator -> Se verifica modificarile in baza de date.`

2. Read: `Se adauga in cos cel putin un produs prin metoda 9 din meniul interactiv -> Se plaseaza o comanda prin metoda 6 din meniul interactiv -> La selectarea metodei de plata se alege "Card de credit, online" -> Se observa cum apar cardurile stocate in baza de date.`

3. Update: `Se alege 14 din meniul interactiv -> Se alege indexul cardului pe care vrem sa il modificam -> Introducem noile date care vor inlocui datele vechi -> Se verifica modificarile in baza de date.`

4. Delete: `Se alege 16 din meniul interactiv -> Se alege indexul cardului pe care vrem sa il stergem -> Se verifica modificarile in baza de date.`

## Pentru clasa Produs (care e folosita pentru a adauga produse in cosul de cumparaturi):
1. Create: `Se alege 9 din meniul interactiv -> Daca nu aveti produse in cos, alegeti restaurantul, apoi un produs din meniul acelui restaurant. !! O comanda se poate plasa doar cu produse din acelasi restaurant !!. Daca aveti deja produse in cos va trebui sa alegeti daca sa incepeti o comanda noua (astfel revenind la pasul initial in care nu aveti produse in cos) sau sa adaugati alt produs din cadrul meniului aceluiasi restaurant. -> Indiferent de metoda aleasa anterior, noul produs va fi adaugat in baza de date.`

2. Read: `Se alege 10 din meniul interactiv -> Se observa toate produsele din clasa cos din baza de date.`

3. Update: `Se alege 11 din meniul interactiv -> Se alege indexul produsului pe care vrem sa il modificam !! Vom putea modifica produsul doar cu un altul din cadrul aceluiasi restaurant !! -> Se alege indexul noului produs -> Se observa modificarile in baza de date.`

4. Delete: `Se alege 12 din meniul interactiv -> Se alege indexul produsului pe care vrem sa il stergem -> Se observa modificarile in baza de date.`

## Pentru clasa Review:
1. Create: `Se plaseaza mai intai cel putin o comanda din meniul interactiv -> Se alege 16 - review pentru restaurant - sau 17 - review pentru curier - din meniul interactiv -> Se alege indexul comenzii pentru care vrem sa lasam review -> Introducem nota si comentariul recenziei -> Se observa modificarile in baza de date.`

2. Read:
   - Pentru restaurant: `Se alege 5 din meniul interactiv -> Se introduce tipul unui restaurant (Ex. "Italian") -> Se observa cum apar detaliile unui restaurant alaturi de recenzii.`
   - Pentru curieri: `Recenziile unui curier apar in momentul in care utilizatorul plaseaza o comanda. Astfel, daca a fost lasat un review pentru Curierul-1, vom putea vedea noua recenzie lasata in momentul in care plasam o alta comanda asupra careia este asignat tot Curierul-1. (!! Un curier este asignat unei comanzi in mod randomizat, folosind functii matematice).`

3. Update: `Se alege 18 din meniul interactiv -> Se alege indexul recenziei pe care vrem sa o modificam -> Introducem noile date care vor inlocui datele vechi in baza de date -> Se observa schimbarile in baza de date.`

4. Delete: `Se alege 19 din meniul interactiv -> Se alege indexul recenziei pe care vrem sa o stergem -> Se observa modificarile in baza de date.`

## Bonus - Pentru clasa User:
1. Create: `In momentul in care aplicatia este pornita pentru prima data, utilizatorul va fi fortat sa isi introduca datele personale. Astfel, data viitoare cand porneste aplicatia, in loc de introducerea datelor personale, se va afisa un mesaj de bun venit. Practic, datele sale personale sunt create si adaugate in baza de date in mod automat.`

2. Read: `Se alege 1 din meniul interactiv -> Se observa datele personale extrase din baza de date.`

3. Update: `Se alege 2 din meniul interactiv -> Se introduc datele personale corespunzator -> Se observa modificarile in baza de date.`

4. Delete: `Se alege 3 din meniul interactiv -> Datele se vor sterge automat din baza de date iar aplicatia se va inchide -> La urmatoarea rulare a aplicatiei, utilizatorul va fi iar fortat sa isi introduca datele personale.`
---

## 🧪 Serviciu de audit

La fiecare acțiune efectuată în aplicație (de exemplu, adăugare produs, stergere review, modificare produs in cos), se loghează automat o linie în fișierul `audit.csv` cu formatul:

```csv
actiune,timestamp
adauga_produs,2025-05-24 14:35:22
plasare_comanda,2025-05-24 14:36:01
```

---

## 💻 Rulare aplicație

1. Clonează proiectul local și deschide-l în IntelliJ
2. Asigură-te că baza de date este pornită
3. Rulează clasa `Main.java`
4. Urmează meniul interactiv pentru a utiliza aplicația

---

## 📌 Observații finale

- Structura OOP poate fi extinsă prin introducerea de clase abstracte și interfețe, în funcție de nevoi.
- Ar fi ideal să se folosească Hibernate sau JPA pentru proiecte reale, dar s-a folosit JDBC conform cerințelor temei.

---

## 👨‍🎓 Autor

**Rares-Andrei I.**  
Student la Facultatea de Matematică și Informatică, Universitatea din București  
Proiect realizat pentru disciplina PAOJ – anul 2, semestrul 2

---

## 📝 Licență

Acest proiect este realizat strict în scop educațional și nu este destinat utilizării comerciale.
