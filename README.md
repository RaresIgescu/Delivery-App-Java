# 🍽️ Aplicație Food Delivery – Proiect Java (PAO)

Acest proiect reprezintă o aplicație de tip Food Delivery, dezvoltată în limbajul Java, ca parte a temei de semestru pentru disciplina Programare Avansată pe Obiecte (PAO). Aplicația permite gestionarea utilizatorilor, restaurantelor, produselor, comenzilor și recenziilor, cu persistența datelor în PostgreSQL și un sistem de audit pe fișier CSV.

---

## 🧰 Tehnologii utilizate

- Java 17
- JDBC (Java Database Connectivity)
- PostgreSQL
- pgAdmin 4
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
  - `Produs`
  - `User`
  - `Restaurant`
  - `Comanda`
- ✅ Operații CRUD pentru clasele de mai sus
- ✅ Serviciu de audit: scriere în fișier CSV pentru fiecare acțiune semnificativă

---

## 🗂️ Structura proiectului

```
src/
├── com.unibuc.pao.proiect.model        # Clase model: User, Restaurant, Produs, Comanda etc.
├── com.unibuc.pao.proiect.service      # Servicii pentru operații CRUD și interacțiunea cu DB
├── com.unibuc.pao.proiect.database     # Conexiunea cu baza de date (DBConnection)
├── com.unibuc.pao.proiect.audit        # Scrierea logurilor în audit.csv
├── com.unibuc.pao.proiect.ui           # Meniul principal (Main.java)
```

---

## 🛠️ Configurare bază de date PostgreSQL

1. Creează o bază de date:  
   `food_delivery`

2. Creează tabelele corespunzătoare (exemplu pentru `produs`):

```sql
CREATE TABLE produs (
    id SERIAL PRIMARY KEY,
    nume VARCHAR(100),
    pret DOUBLE PRECISION,
    categorie VARCHAR(50)
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

---

## 🧪 Serviciu de audit

La fiecare acțiune efectuată în aplicație (de exemplu, adăugare produs, plasare comandă, scriere recenzie), se loghează automat o linie în fișierul `audit.csv` cu formatul:

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

## 🧪 Exemple de operații CRUD

### Adăugare produs

```java
Produs produs = new Produs("Pizza Margherita", 32.5, "Italian");
produsService.adaugaProdus(produs);
```

### Afișare produse

```java
List<Produs> produse = produsService.getAllProduse();
produse.forEach(System.out::println);
```

### Actualizare produs

```java
produsService.updateProdus(3, "Pizza Quattro Formaggi", 37.0, "Italian");
```

### Ștergere produs

```java
produsService.deleteProdus(3);
```

---

## 📌 Observații finale

- Parolele utilizatorilor bazei de date nu sunt hardcodate în aplicațiile reale. Pentru uz academic, s-a acceptat această practică.
- Structura OOP poate fi extinsă prin introducerea de clase abstracte și interfețe, în funcție de nevoi.
- Ar fi ideal să se folosească Hibernate sau JPA pentru proiecte reale, dar s-a folosit JDBC conform cerințelor temei.

---

## 👨‍🎓 Autor

**Rares N.**  
Student la Facultatea de Matematică și Informatică, Universitatea din București  
Proiect realizat pentru disciplina PAO – anul 1, semestrul 2

---

## 📝 Licență

Acest proiect este realizat strict în scop educațional și nu este destinat utilizării comerciale.
