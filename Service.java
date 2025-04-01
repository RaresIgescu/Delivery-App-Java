import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class Service {
    private User user;
    private final Set<Restaurant> restaurants;
    private final Map<Restaurant, List<Produs>> meniuri;
    private final List<Curier> curieri;
    private Cos cos;
    private final List<Comanda> comenzi;
    private final Set<cardCredit> carduri;
    private final Random random;

    public Service() {
        this.random = new Random();

        this.user = null;
        this.restaurants = new LinkedHashSet<>();

        Restaurant aveForchetta = new Restaurant(1, "AveForchetta", "Aviatorilor", "Bucuresti", "Italian",
                Arrays.asList(
                        new Review(1, 5, "Foarte bun."),
                        new Review(2, 2, "Am gasit par in mancare.")
                )
        );

        Restaurant linea = new Restaurant(2, "Linea", "Calea Stefan cel Mare", "Iasi", "Romanesc",
                Arrays.asList(
                        new Review(1, 4, "Mancare delicioasa dar foarte zgomotos.")
                )
        );

        Restaurant big5 = new Restaurant(3, "Big 5", "Cerbului", "Sibiu", "American",
                new ArrayList<>()
        );

        this.restaurants.add(aveForchetta);
        this.restaurants.add(linea);
        this.restaurants.add(big5);

        this.meniuri = new LinkedHashMap<>();

        List<Produs> produseAveForchetta = Arrays.asList(
                new Produs(1, "Pizza Margherita", 35.0, "Disponibil!"),
                new Produs(2, "Paste Carbonara", 40.0, "Disponibil!"),
                new Produs(3, "Canoli cu Fistic", 22.50, "Disponibil!")
        );

        List<Produs> produseLinea = Arrays.asList(
                new Produs(4, "Ciorba de burta", 30.20, "Indisponibil"),
                new Produs(5, "Sarmale cu mamaliga", 45.70, "Disponibil!"),
                new Produs(6, "Mici la gratar cu mustar", 28.90, "Disponibil!")
        );

        List<Produs> produseBig5 = Arrays.asList(
                new Produs(7, "Burger American", 50.0, "Disponibil!"),
                new Produs(8, "Coaste BBQ", 70.0, "Disponibil!"),
                new Produs(9, "Clatite pufoase", 35.50, "Disponibil!")
        );

        for (Restaurant r : this.restaurants) {
            switch (r.getNume()) {
                case "AveForchetta" -> this.meniuri.put(r, produseAveForchetta);
                case "Linea" -> this.meniuri.put(r, produseLinea);
                case "Big 5" -> this.meniuri.put(r, produseBig5);
            }
        }

        this.curieri = new ArrayList<>();

        Curier aamir = new Curier(1, "Aamir", "Jiskani", "Pakistan",
                Arrays.asList(new Review(1, 4.5, "S-a miscat repede cu comanda."),
                              new Review(2, 3, "Nu a avut sa-mi dea rest."))
        );

        Curier abdul = new Curier(1, "Abdul", "Darzada", "Tibet",
                Arrays.asList(new Review(3, 1, "Am intarziat sa ridic comanda si mi-a mancat-o."),
                              new Review(4, 3, "Nu a stiut sa vorbeasca romana."))
        );

        Curier farid = new Curier(1, "Farid", "Kirmani", "Nepal",
                Arrays.asList(new Review(5, 2, "Nu am avut comanda completa."),
                              new Review(6, 5, "Mancarea inca era calda cand a ajuns."))
        );

        this.curieri.add(aamir);
        this.curieri.add(abdul);
        this.curieri.add(farid);

        this.cos = new Cos(1, null, new ArrayList<Produs>(), 0);
        this.comenzi = new LinkedList<>();
        this.carduri = new LinkedHashSet<>();
    }

    public void setareDatePersonale() {
        Scanner scanner = new Scanner(System.in);

        int id = 1;

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║     INTRODUCERE DATE PERSONALE     ║");
        System.out.println("╚════════════════════════════════════╝");

        System.out.println("\n┌────────────────────────────────────┐");
        System.out.println("│           DATE PERSONALE           │");
        System.out.println("├────────────────────────────────────┤");
        System.out.print("│ ➤ Nume (4-20 litere): ");
        String nume = scanner.nextLine();
        while (!nume.matches("^[a-zA-Z]{4,20}$")) {
            System.out.println("├────────────────────────────────────┤");
            System.out.println("│ ⚠ Nume invalid!                    │");
            System.out.println("│   - Doar litere (A-Z, a-z)         │");
            System.out.println("│   - Lungime 4-20 caractere         │");
            System.out.println("├────────────────────────────────────┤");
            System.out.print("│ ➤ Nume: ");
            nume = scanner.nextLine();
        }

        System.out.print("│ ➤ Prenume (4-20 litere): ");
        String prenume = scanner.nextLine();
        while (!prenume.matches("^[a-zA-Z-]{4,20}$")) {
            System.out.println("├────────────────────────────────────┤");
            System.out.println("│ ⚠ Prenume invalid!                 │");
            System.out.println("│   - Doar litere și cratime         │");
            System.out.println("│   - Lungime 4-20 caractere         │");
            System.out.println("├────────────────────────────────────┤");
            System.out.print("│ ➤ Prenume: ");
            prenume = scanner.nextLine();
        }

        System.out.print("│ ➤ Vârstă (16-100): ");
        int varsta;
        while (true) {
            try {
                varsta = scanner.nextInt();
                scanner.nextLine();
                if (varsta >= 16 && varsta <= 100) break;
                System.out.println("├────────────────────────────────────┤");
                System.out.println("│ ⚠ Vârstă invalidă!                 │");
                System.out.println("│   - Trebuie să fie între 16-100    │");
                System.out.println("├────────────────────────────────────┤");
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("├────────────────────────────────────┤");
                System.out.println("│ ⚠ Introduceți un număr valid!      │");
                System.out.println("├────────────────────────────────────┤");
            }
            System.out.print("│ ➤ Vârstă: ");
        }

        System.out.print("│ ➤ Oraș (max 25 caractere): ");
        String oras = scanner.nextLine();
        while (!oras.matches("^[a-zA-Z\\s]{1,25}")) {
            System.out.println("├────────────────────────────────────┤");
            System.out.println("│ ⚠ Oraș invalid!                    │");
            System.out.println("│   - Doar litere și spații          │");
            System.out.println("│   - Maxim 25 caractere             │");
            System.out.println("├────────────────────────────────────┤");
            System.out.print("│ ➤ Oraș: ");
            oras = scanner.nextLine();
        }

        System.out.print("│ ➤ Stradă (max 30 caractere): ");
        String strada = scanner.nextLine();
        while (!strada.matches("^[a-zA-Z0-9\\s]{1,30}$")) {
            System.out.println("├────────────────────────────────────┤");
            System.out.println("│ ⚠ Stradă invalidă!                 │");
            System.out.println("│   - Litere, cifre și spații        │");
            System.out.println("│   - Maxim 30 caractere             │");
            System.out.println("├────────────────────────────────────┤");
            System.out.print("│ ➤ Stradă: ");
            strada = scanner.nextLine();
        }
        System.out.println("└────────────────────────────────────┘");

        user = new User(id, nume, prenume, varsta, oras, strada);

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       DATE SALVATE CU SUCCES!      ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("\nBine ai venit, " + nume + " " + prenume + "!");
    }

    public void vizualzareDatePersonale() {
        System.out.println(user.toString());
    }

    public void getMeniu(Restaurant r) {
        List<Produs> produse = this.meniuri.get(r);
        for(Produs p : produse) {
            System.out.println(p.toString());
            System.out.println();
        }
    }

    public void vizualizareMeniu() {
        for(Restaurant r : this.restaurants) {
            System.out.println();
            System.out.println("====================================");
            System.out.println("Meniul restaurantului " + r.getNume());
            System.out.println("====================================");
            System.out.println();
            getMeniu(r);
        }
    }

    public void vizualizareCos() {
        if (this.cos.nrProduse() == 0) {
            System.out.println();
            System.out.println("====================================");
            System.out.println("Cosul de cumparaturi este gol.");
            System.out.println("====================================");
        } else {
            System.out.println();
            System.out.println("====================================");
            System.out.println("Asa arata cosul dumneavoastra:");
            System.out.println("====================================");
            System.out.println();
            System.out.println(this.cos.toString());
        }
    }

    public void adaugareProdusInCos() {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        Restaurant restaurantAles = this.cos.getRestaurant();
        Produs produsAles;

        if (restaurantAles == null) {
            restaurantAles = alegeRestaurant(scanner);
        } else {
            System.out.println("Aveti deja produse in cos de la: " + restaurantAles.getNume() + ".");
            System.out.println("Vreti sa: \n1. Adaugati produse de la restaurantul curent.\n2. Comandati de la alt restaurant.");
            System.out.println("!!INTR-O COMANDA SE POT AFLA DOAR PRODUSE DE LA ACELASI RESTAURANT!!");
            int optiune = scanner.nextInt();
            while (optiune != 1 && optiune != 2) {
                System.out.println("Optiune invalida!");
                optiune = scanner.nextInt();
            }
            if (optiune == 2) {
                this.cos = new Cos(1, null, new ArrayList<>(), 0);
                restaurantAles = alegeRestaurant(scanner);
            }
        }

        produsAles = alegeProdus(scanner, restaurantAles);

        List<Produs> produse = this.cos.getProduse();
        produse.add(produsAles);

        for (Produs p : produse) {
            total += p.getPret();
        }

        this.cos = new Cos(1, restaurantAles, produse, total);

        System.out.println("====================================");
        System.out.println(" Produsul a fost adăugat în coș!");
        System.out.println("====================================");
        vizualizareCos();
    }

    private Restaurant alegeRestaurant(Scanner scanner) {
        System.out.println("====================================");
        System.out.println(" Mai intai hai sa alegem restaurantul: ");
        System.out.println("====================================");

        List<Restaurant> listaRestaurante = new ArrayList<>(this.restaurants);

        int i = 1;
        for (Restaurant r : listaRestaurante) {
            System.out.println(i + ". " + r.getNume());
            i++;
        }

        int optiune = scanner.nextInt();
        while (optiune < 1 || optiune > listaRestaurante.size()) {
            System.out.println("Alegere invalida! Te rog sa alegi un numar valid.");
            optiune = scanner.nextInt();
        }

        return listaRestaurante.get(optiune - 1);
    }

    private Produs alegeProdus(Scanner scanner, Restaurant restaurant) {
        List<Produs> meniu = this.meniuri.get(restaurant);
        System.out.println("====================================");
        System.out.println("   Restaurantul ales: " + restaurant.getNume());
        System.out.println("====================================");
        System.out.println("Alege produsul:");

        int i = 1;
        for (Produs p : meniu) {
            System.out.println(i + ". " + p.toString());
            i++;
        }

        int optiune = scanner.nextInt();
        while (optiune < 1 || optiune > meniu.size()) {
            System.out.println("Alegere invalida! Te rog sa alegi un numar valid.");
            optiune = scanner.nextInt();
        }

        return meniu.get(optiune - 1);
    }

    public void plasareComanda() {
        Scanner scanner = new Scanner(System.in);

        if (this.cos.nrProduse() == 0) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║                                    ║");
            System.out.println("║         COSUL ESTE GOL             ║");
            System.out.println("║                                    ║");
            System.out.println("║ Adaugă produse în cos înainte      ║");
            System.out.println("║ de a plasa o comandă.              ║");
            System.out.println("║                                    ║");
            System.out.println("╚════════════════════════════════════╝\n");
            return;
        }

        vizualizareCos();

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║                                    ║");
        System.out.println("║  Sunteți mulțumit de coșul de      ║");
        System.out.println("║  cumpărături? (Da/Nu)              ║");
        System.out.println("║                                    ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("➤ Răspuns: ");

        String optiune = scanner.nextLine().trim();

        if (!optiune.equalsIgnoreCase("Da")) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║                                    ║");
            System.out.println("║       COMANDA ANULATĂ              ║");
            System.out.println("║                                    ║");
            System.out.println("╚════════════════════════════════════╝\n");
            return;
        }

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         METODĂ DE PLATĂ            ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  1. Cash, la curier                ║");
        System.out.println("║  2. Card de credit, online         ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("➤ Alegeți o opțiune: ");

        int optiunePlata = scanner.nextInt();
        scanner.nextLine();

        if (optiunePlata == 2 && carduri.isEmpty()) {
            System.out.println("\n⚠ ATENȚIE: Nu aveți carduri de credit salvate.");
            System.out.println("   Adăugați un card în meniul interactiv și încercați din nou.\n");
            return;
        }

        if (optiunePlata == 2) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║       SELECTARE CARD               ║");
            System.out.println("╠════════════════════════════════════╣");
            int temp = 1;
            for (cardCredit card : carduri) {
                System.out.printf("║ %d. %-30s %n", temp++, card.toString());
            }
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("➤ Alegeți cardul: ");

            int cardIndex = scanner.nextInt();
            while (cardIndex < 1 || cardIndex > carduri.size()) {
                System.out.print("✘ Opțiune invalidă. Introduceți un număr valid: ");
                cardIndex = scanner.nextInt();
            }
            scanner.nextLine();
        } else if (optiunePlata == 1) {
            System.out.println("\nℹ PLATĂ LA LIVRARE: Se va face cash la curier.");
            System.out.println("  Vă recomandăm să aveți suma exactă.\n");
        } else {
            System.out.println("\n✘ Opțiune invalidă. Comanda nu a fost plasată.\n");
            return;
        }

        Curier curierAleatoriu = curieri.get(random.nextInt(curieri.size()));

        Comanda comandaPlasata = new Comanda(
                1, this.cos.getProduse(), this.cos.getRestaurant(),
                this.cos.getTotalDePlata(), LocalDate.now(), curierAleatoriu
        );
        comenzi.add(comandaPlasata);

        this.cos = new Cos(1, null, new ArrayList<>(), 0);

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║                                    ║");
        System.out.println("║    COMANDA PLASATĂ CU SUCCES!      ║");
        System.out.println("║                                    ║");
        System.out.println("╚════════════════════════════════════╝");

        System.out.println("\n📦 DETALII LIVRARE:");
        System.out.println(curierAleatoriu.toString());
        System.out.println("\n⭐ Nu uitați să lăsați un review în meniul interactiv!");
    }


    public void vizualizareFosteComenzi() {
        if (comenzi.isEmpty()) {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("⚠ La acest moment, nu aveți plasată nicio comandă.");
            System.out.println("==============================================");
        } else {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("Acestea sunt comenzile dumneavoastră până la acest moment:");
            System.out.println("==============================================");

            for (Comanda comanda : comenzi) {
                System.out.println(comanda.toString());
                System.out.println("----------------------------------------------");
            }
        }
    }

    public void filtrareRestaurante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        FILTRARE RESTAURANTE        ║");
        System.out.println("╚════════════════════════════════════╝");

        Set<String> categoriiUnice = new HashSet<>();
        for(Restaurant r : this.restaurants) {
            categoriiUnice.add(r.getCategorie());
        }

        System.out.println("Categoriile disponibile:");
        for(String categorie : categoriiUnice) {
            System.out.println(" - " + categorie);
        }

        boolean gasit = false;
        while(!gasit) {
            System.out.print("\n➤ Introduceți categoria dorită: ");
            String optiune = scanner.nextLine().trim();

            for (Restaurant r : this.restaurants) {
                if (optiune.equalsIgnoreCase(r.getCategorie())) {
                    System.out.println("\n══════════════════════════════════════");
                    System.out.println(r.toString());
                    System.out.println("══════════════════════════════════════");
                    gasit = true;
                }
            }

            if(!gasit) {
                System.out.println("\n⚠ Categorie invalidă! Încercați din nou.");
                System.out.println("Categoriile valabile sunt:");
                for(String categorie : categoriiUnice) {
                    System.out.println(" - " + categorie);
                }
            }
        }
    }

    public void adaugareCardInMemorie() {
        Scanner scanner = new Scanner(System.in);
        String numarCard = null;
        System.out.println("Introduceti codul de 16 cifre pentru card: ");
        numarCard = scanner.nextLine();
        while (!numarCard.matches("\\d{4} ?\\d{4} ?\\d{4} ?\\d{4}")) {
            System.out.println("Cod invalid, folsitit doar un cod de 16 cifre.");
            numarCard = scanner.nextLine();
        }
        System.out.println("Acum introduceti tipul cardului: ");
        String tipCard = null;
        tipCard = scanner.nextLine();
        while(!tipCard.matches("[a-zA-Z]{1,15}")) {
            System.out.println("Va rog introduceti doar litere pana in 15 caractere.");
            tipCard = scanner.nextLine();
        }
        System.out.println("Si CVV-ul cardului: ");
        String CVV = null;
        CVV = scanner.nextLine();
        while(!CVV.matches("\\d{3}")) {
            System.out.println("CVV Invalid.");
            CVV = scanner.nextLine();
        }
        carduri.add(new cardCredit(1, numarCard, tipCard, CVV));
    }

    public void addReviewToRestaurant() {
        Scanner scanner = new Scanner(System.in);

        if (comenzi.isEmpty()) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║                                    ║");
            System.out.println("║  Nu aveți comenzi plasate.         ║");
            System.out.println("║  Pentru a lăsa un review,         ║");
            System.out.println("║  plasați mai întâi o comandă.     ║");
            System.out.println("║                                    ║");
            System.out.println("╚════════════════════════════════════╝");
            return;
        }

        // Afișare antet
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       ADAUGARE REVIEW              ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  Selectați comanda pentru care     ║");
        System.out.println("║  doriți să lăsați review:          ║");
        System.out.println("╚════════════════════════════════════╝");

        int index = 1;
        for (Comanda comanda : comenzi) {
            System.out.printf("\n%d. Restaurant: %s", index, comanda.getRestaurant().getNume());
            System.out.printf("\n   Data: %s", comanda.getData());
            System.out.printf("\n   Total: %.2f RON", comanda.getPretTotal());
            System.out.println("\n   ────────────────────────────────");
            index++;
        }

        int optiune;
        while (true) {
            System.out.print("\n➤ Introduceți numărul comenzii: ");
            try {
                optiune = scanner.nextInt();
                scanner.nextLine();

                if (optiune < 1 || optiune > comenzi.size()) {
                    System.out.println("⚠ Vă rugăm introduceți un număr între 1 și " + comenzi.size());
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("⚠ Introduceți doar numere!");
                scanner.nextLine();
            }
        }

        Comanda comandaAleasa = comenzi.get(optiune - 1);
        Restaurant restaurant = comandaAleasa.getRestaurant();

        double scor;
        while (true) {
            System.out.print("\n➤ Nota dvs. (1-5 stele): ");
            try {
                scor = scanner.nextDouble();
                scanner.nextLine();

                if (scor < 1 || scor > 5) {
                    System.out.println("⚠ Nota trebuie să fie între 1 și 5!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("⚠ Introduceți doar numere!");
                scanner.nextLine();
            }
        }

        System.out.println("\n✎ Spuneți-ne părerea dvs. (max 200 caractere):");
        System.out.print("➤ ");
        String comentariu = scanner.nextLine();

        Review reviewNou = new Review(1, scor, comentariu);

        List<Review> reviews = restaurant.getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(reviewNou);
        restaurant.setReviews(reviews);

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║                                    ║");
        System.out.println("║  ✓ REVIEW ADAUGAT CU SUCCES!       ║");
        System.out.println("║                                    ║");
        System.out.println("╚════════════════════════════════════╝");

        System.out.println("\nMulțumim pentru feedback-ul dvs. despre:");
        System.out.println("🍽️ " + restaurant.getNume());
        System.out.printf("⭐ Scor: %.1f/5\n", scor);
        System.out.println("📝 Comentariu: " + comentariu);
    }

    public void addReviewToCurier() {
        if(comenzi.isEmpty()) {
            System.out.println("Nu puteti lasa review-uri daca nu aveti comenzi plasate.");
        } else {
            if(comenzi.size() == 1) {
                //Restaurant r = comenzi.get(0);
            } else {

            }
        }
    }

    public void deleteOrder() {

    }

}
