package src.com.unibuc.pao.proiect.service;

import src.com.unibuc.pao.proiect.audit.AuditService;
import src.com.unibuc.pao.proiect.model.*;

import java.time.LocalDate;
import java.util.*;


public class Service {
    private final Set<Restaurant> restaurants;
    private final Map<Restaurant, List<Produs>> meniuri;
    private final List<Curier> curieri;
    private Cos cos;
    private final List<Comanda> comenzi;
    private Set<cardCredit> carduri;
    private List<Cod> coduri;
    private final Random random;

    ProdusService produsService = ProdusService.getInstance();
    CardService cardService = CardService.getInstance();
    UserService userService = UserService.getInstance();
    ReviewService reviewService = ReviewService.getInstance();
    CodService codService = CodService.getInstance();
    public Service() {
        this.random = new Random();
        this.restaurants = new LinkedHashSet<>();

        List<Review> reviewsAveForchetta = Arrays.asList(
                new Review(1, 5, "Foarte bun."),
                new Review(2, 2, "Am gasit par in mancare.")
        );

        Restaurant aveForchetta = new Restaurant(1, "AveForchetta", "Aviatorilor", "Bucuresti", "Italian", reviewsAveForchetta);

        List<Review> reviewsLinea = Arrays.asList(
                new Review(3, 4, "Mancare delicioasa dar foarte zgomotos."),
                new Review(4, 3, "Chelnerul a fost nepoliticos")
        );

        Restaurant linea = new Restaurant(2, "Linea", "Calea Stefan cel Mare", "Iasi", "Romanesc", reviewsLinea);

        List<Review> reviewsBig5 = List.of();

        Restaurant big5 = new Restaurant(3, "Big 5", "Cerbului", "Sibiu", "American", reviewsBig5);

        this.restaurants.add(aveForchetta);
        this.restaurants.add(linea);
        this.restaurants.add(big5);

        this.meniuri = new LinkedHashMap<>();

        List<Produs> produseAveForchetta = Arrays.asList(
                new Produs(1, "Pizza Margherita", 35.0, "Disponibil!"),
                new Produs(2, "Paste Carbonara", 40.0, "Disponibil!"),
                new Produs(3, "Canoli cu Fistic", 22.50, "Disponibil!")
        );

//        for(Produs produs : produseAveForchetta) {
//            produsService.adaugaProdus(produs);
//        }

        List<Produs> produseLinea = Arrays.asList(
                new Produs(4, "Ciorba de burta", 30.20, "Indisponibil"),
                new Produs(5, "Sarmale cu mamaliga", 45.70, "Disponibil!"),
                new Produs(6, "Mici la gratar cu mustar", 28.90, "Disponibil!")
        );

//        for(Produs produs : produseLinea) {
//            produsService.adaugaProdus(produs);
//        }

        List<Produs> produseBig5 = Arrays.asList(
                new Produs(7, "Burger American", 50.0, "Disponibil!"),
                new Produs(8, "Coaste BBQ", 70.0, "Disponibil!"),
                new Produs(9, "Clatite pufoase", 35.50, "Disponibil!")
        );

//        for(Produs produs : produseBig5) {
//            produsService.adaugaProdus(produs);
//        }

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

        this.cos = new Cos(1, null, new ArrayList<>(), 0);
        this.comenzi = new LinkedList<>();
        this.carduri = new LinkedHashSet<>();
    }

    public void setareDatePersonale() {
        Scanner scanner = new Scanner(System.in);

        int id = 1;

        User user = userService.readDatePersonale();
        AuditService.getInstance().logAction("citire_date_personale");

        if (user == null) {
            System.out.println("Inaninte de toate, te rugam sa introduci datele tale personale: ");
            System.out.println("\n******************************");
            System.out.println("  Introducerea datelor tale");
            System.out.println("******************************\n");

            System.out.print("Nume (4-20 litere, fara cifre): ");
            String nume = scanner.nextLine();
            while (!nume.matches("^[a-zA-Z]{4,20}$")) {
                System.out.println("Numele nu este valid...");
                System.out.println("Asigura-te ca este intre 4 si 20 de litere, fara cifre.");
                System.out.print("Incearca din nou: ");
                nume = scanner.nextLine();
            }

            System.out.print("Prenume (4-20 litere, fara cifre): ");
            String prenume = scanner.nextLine();
            while (!prenume.matches("^[a-zA-Z-]{4,20}$")) {
                System.out.println("Prenumele nu este valid...");
                System.out.println("Asigura-te ca este intre 4 si 20 de litere, cu posibilitatea de a folosi cratime.");
                System.out.print("Incearca din nou: ");
                prenume = scanner.nextLine();
            }

            System.out.print("Cati ani ai? (16-100): ");
            int varsta;
            while (true) {
                try {
                    varsta = scanner.nextInt();
                    scanner.nextLine();
                    if (varsta >= 16 && varsta <= 100) break;
                    System.out.println("Varsta trebuie sa fie intre 16 si 100.");
                    System.out.print("Te rog sa incerci din nou: ");
                } catch (Exception e) {
                    scanner.nextLine();
                    System.out.println("A aparut o eroare. Te rog sa introduci un numar valid.");
                    System.out.print("Incearca din nou: ");
                }
            }

            System.out.print("Oras (max 25 caractere): ");
            String oras = scanner.nextLine();
            while (!oras.matches("^[a-zA-Z\\s]{1,25}$")) {
                System.out.println("Orasul nu este valid...");
                System.out.println("Asigura-te ca este intre 1 si 25 de caractere, folosind doar litere si spatii.");
                System.out.print("Incearca din nou: ");
                oras = scanner.nextLine();
            }

            System.out.print("Strada (max 30 caractere): ");
            String strada = scanner.nextLine();
            while (!strada.matches("^[a-zA-Z0-9\\s]{1,30}$")) {
                System.out.println("Strada nu este valida...");
                System.out.println("Asigura-te ca este intre 1 si 30 de caractere, folosind litere, cifre si spatii.");
                System.out.print("Incearca din nou: ");
                strada = scanner.nextLine();
            }

            user = new User(id, nume, prenume, varsta, oras, strada);
            userService.createDatePersonale(user);
            AuditService.getInstance().logAction("creare_date_personale");

            System.out.println("\n******************************");
            System.out.println("   DATE SALVATE CU SUCCES!");
            System.out.println("******************************");
            System.out.println("\nBine ai venit, " + nume + " " + prenume + "!");
        }
        else {
            System.out.println("Bine ai venit, " + user.getNume() + " " + user.getPrenume() + "!");
        }
    }

    public void modificareDatePersonale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n******************************");
        System.out.println("  Modificarea datelor tale");
        System.out.println("******************************\n");

        System.out.print("Nume (4-20 litere, fara cifre): ");
        String nume = scanner.nextLine();
        while (!nume.matches("^[a-zA-Z]{4,20}$")) {
            System.out.println("Numele nu este valid...");
            System.out.println("Asigura-te ca este intre 4 si 20 de litere, fara cifre.");
            System.out.print("Incearca din nou: ");
            nume = scanner.nextLine();
        }

        System.out.print("Prenume (4-20 litere, fara cifre): ");
        String prenume = scanner.nextLine();
        while (!prenume.matches("^[a-zA-Z-]{4,20}$")) {
            System.out.println("Prenumele nu este valid...");
            System.out.println("Asigura-te ca este intre 4 si 20 de litere, cu posibilitatea de a folosi cratime.");
            System.out.print("Incearca din nou: ");
            prenume = scanner.nextLine();
        }

        System.out.print("Cati ani ai? (16-100): ");
        int varsta;
        while (true) {
            try {
                varsta = scanner.nextInt();
                scanner.nextLine();
                if (varsta >= 16 && varsta <= 100) break;
                System.out.println("Varsta trebuie sa fie intre 16 si 100.");
                System.out.print("Te rog sa incerci din nou: ");
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("A aparut o eroare. Te rog sa introduci un numar valid.");
                System.out.print("Incearca din nou: ");
            }
        }

        System.out.print("Oras (max 25 caractere): ");
        String oras = scanner.nextLine();
        while (!oras.matches("^[a-zA-Z\\s]{1,25}$")) {
            System.out.println("Orasul nu este valid...");
            System.out.println("Asigura-te ca este intre 1 si 25 de caractere, folosind doar litere si spatii.");
            System.out.print("Incearca din nou: ");
            oras = scanner.nextLine();
        }

        System.out.print("Strada (max 30 caractere): ");
        String strada = scanner.nextLine();
        while (!strada.matches("^[a-zA-Z0-9\\s]{1,30}$")) {
            System.out.println("Strada nu este valida...");
            System.out.println("Asigura-te ca este intre 1 si 30 de caractere, folosind litere, cifre si spatii.");
            System.out.print("Incearca din nou: ");
            strada = scanner.nextLine();
        }

        userService.modificareDatePersonale(nume, prenume, varsta, oras, strada);
        AuditService.getInstance().logAction("modificare_date_personale");


        System.out.println("\n******************************");
        System.out.println("   DATE SALVATE CU SUCCES!");
        System.out.println("******************************");
        System.out.println("\nBine ai venit, " + nume + " " + prenume + "!");
    }

    public void stergereDatePersonale() {
        userService.stergereDatePersonale();
        AuditService.getInstance().logAction("stergere_date_personale");
        System.out.println("Datele dvs. personale au fost sterse cu succes.");
        System.out.println("Acum aplicatia se va inchide iar la repornire va trebui sa va setati din nou datele.");
    }

    public void vizualzareDatePersonale() {
        User user = userService.readDatePersonale();
        AuditService.getInstance().logAction("citire_date_personale");
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
        if (restaurants.isEmpty()) {
            System.out.println("\nMomentan nu exista restaurante disponibile.");
            System.out.println("Te rugam sa incerci din nou mai tarziu.");
            return;
        }

        for (Restaurant r : this.restaurants) {
            System.out.println("\n--- Meniu Restaurant: " + r.getNume().toUpperCase() + " ---");
            System.out.println("Categorie: " + r.getCategorie());
            System.out.println("Oras: " + r.getOras());

            System.out.println("\nProduse disponibile:");

            getMeniu(r);

            System.out.println("\nPentru a comanda, te rugam sa selectezi restaurantul din meniul principal.");
        }
    }

    public void vizualizareCos() {
        List<Produs> produseInCos = produsService.readProduseCos();
        AuditService.getInstance().logAction("citire_produse_cos");
        if (produseInCos.isEmpty()) {
            System.out.println("\nCosul tau de cumparaturi este gol.");
            System.out.println("Adauga produse pentru a vizualiza continutul cosului.");
        } else {
            System.out.println("\n--- Cosul tau de cumparaturi ---");

            System.out.println("\nProduse adaugate in cos:");

            double totalDePlata = 0;

            for(Produs produs : produseInCos) {
                System.out.println(produs.toString());
                totalDePlata += produs.getPret();
            }


            System.out.printf("\nTOTAL: %.2f RON\n", totalDePlata);

            System.out.println("\nPentru a plasa comanda, selecteaza optiunea 8 din meniul principal.");
        }
    }

    public void adaugareProdusInCos() {
        List<Produs> produse = produsService.readProduseCos();
        AuditService.getInstance().logAction("citire_produse_cos");
        int id = 0;
        if(!produse.isEmpty()) {
            Produs primulProdus = produse.getFirst();
            id = produsService.getRestaurantId(primulProdus);
            AuditService.getInstance().logAction("citire_restaurant_cos");
        }
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurantAles = null;
        for(Restaurant restaurant : this.restaurants) {
            if (restaurant.getId() == id) {
                restaurantAles = restaurant;
            }
        }

        System.out.println("\n--- Adaugare produs in cos ---");

        if (restaurantAles == null) {
            restaurantAles = alegeRestaurant(scanner);
        } else {
            System.out.println("\nAi deja produse in cos de la restaurantul: " + restaurantAles.getNume());
            System.out.println("\nCe doresti sa faci?");
            System.out.println("1. Adauga produse de la acelasi restaurant");
            System.out.println("2. Comanda de la un alt restaurant");
            System.out.println("O comanda poate contine produse doar de la un singur restaurant.");

            int optiune;
            do {
                System.out.print("Alege optiunea: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Te rog sa alegi doar intre 1 si 2!");
                    scanner.next();
                }
                optiune = scanner.nextInt();
                scanner.nextLine();

                if (optiune == 2) {
                    this.cos = new Cos(1, null, new ArrayList<>(), 0);
                    produsService.deleteProduse();
                    AuditService.getInstance().logAction("stergere_produse_cos");
                    restaurantAles = alegeRestaurant(scanner);
                } else if (optiune != 1) {
                    System.out.println("Optiune invalida! Te rog alege intre 1 si 2.");
                }
            } while (optiune != 1 && optiune != 2);
        }

        produse = produsService.readProduseCos();

        Produs produsAles = alegeProdus(scanner, restaurantAles);
        Produs produsAlesDB = new Produs(produse.size() + 1, produsAles.getNume(), produsAles.getPret(), produsAles.getDisponibilitate());
        produsService.adaugaInCos(produsAlesDB, restaurantAles);
        AuditService.getInstance().logAction("adaugare_produs_cos");

        double total = 0;
        for (Produs produs : produse) {
            total += produs.getPret();
        }
        this.cos = new Cos(1, restaurantAles, produse, total);

        System.out.println("\n--- Produs adaugat cu succes in cos! ---");

        vizualizareCos();

        System.out.println("\nDaca vrei sa adaugi alt produs, alege din nou optiunea.");
        System.out.println("Pentru a plasa comanda, te poti intoarce la meniul principal.");
    }


    private Restaurant alegeRestaurant(Scanner scanner) {
        System.out.println("\n--- Selecteaza restaurantul preferat ---");
        List<Restaurant> listaRestaurante = new ArrayList<>(this.restaurants);

        int i = 1;
        for (Restaurant r : listaRestaurante) {
            System.out.println(i + ". " + r.getNume());
            i++;
        }

        int optiune;
        while (true) {
            try {
                System.out.print("\nAlege numarul restaurantului dorit: ");
                optiune = scanner.nextInt();
                scanner.nextLine();

                if (optiune < 1 || optiune > listaRestaurante.size()) {
                    System.out.println("Te rog sa alegi un numar intre 1 si " + listaRestaurante.size() + ".");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduceti doar un numar valid!");
                scanner.nextLine();
            }
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

        List<Produs> produseCos = produsService.readProduseCos();
        AuditService.getInstance().logAction("citire_produse_cos");

        if (produseCos.isEmpty()) {
            System.out.println("\nCosul este gol. Adauga produse in cos inainte de a plasa o comanda.");
            return;
        }

        Restaurant restaurantAles = null;
        int restaurantId = produsService.getRestaurantId(produseCos.getFirst());
        AuditService.getInstance().logAction("citire_restaurant_cos");
        for(Restaurant restaurant : this.restaurants) {
            if(restaurant.getId() == restaurantId) {
                restaurantAles = restaurant;
            }
        }

        vizualizareCos();

        System.out.println("\nSunteti multumit de cosul de cumparaturi? (Da/Nu)");
        System.out.print("Raspuns: ");
        String optiune = scanner.nextLine().trim();

        if (!optiune.equalsIgnoreCase("Da")) {
            System.out.println("\nComanda a fost anulata.");
            return;
        }

        System.out.println("\nVreti sa aplicati un cod promotional?:");
        System.out.println("1. Da");
        System.out.println("2. Nu");
        System.out.println("Alegeti o optiune: ");
        int optiuneCod = scanner.nextInt();
        scanner.nextLine();

        Cod codAles = null;
        int reducere = 0;
        if(optiuneCod == 1) {
            coduri = this.codService.getAllCodes();
            if(coduri.isEmpty())
                System.out.println("Ne pare rau, nu aveti coduri promotionale adaugate, verificati meniul interactiv.");
            else {
                System.out.println("Alegeti codul promotional dorit: ");
                List<Cod> coduriDB = codService.getAllCodes();
                int temp = 1;

                coduriDB.sort(Comparator.comparingInt(Cod::getId));
                for (Cod cod : coduriDB) {
                    System.out.printf("%d. %s%n", temp++, cod.toString());
                }
                System.out.print("Alegeti produsul: ");
                int codIndex = scanner.nextInt();
                while (codIndex < 1 || codIndex > coduriDB.size()) {
                    System.out.print("Optiune invalida. Introduceti un numar valid: ");
                    codIndex = scanner.nextInt();
                }
                scanner.nextLine();

                for(Cod cod : coduriDB) {
                    if(cod.getId() == codIndex) {
                        codAles = cod;
                    }
                }

                if(codAles.getValabilitate().equalsIgnoreCase("invalid")) {
                    System.out.println("Codul promotional ales nu este valid.");
                    return;
                }

                reducere = Integer.parseInt(codAles.getCod().substring(codAles.getCod().length() - 2));
                System.out.println("Cod ales cu succes.");
                System.out.println("Aveti " + reducere + "% reducere.");
                System.out.println("Daca plasati comanda, codul va deveni invalid.");
            }
        }

        System.out.println("\nAlege metoda de plata:");
        System.out.println("1. Cash, la curier");
        System.out.println("2. Card de credit, online");
        System.out.print("Alegeti o optiune: ");
        int optiunePlata = scanner.nextInt();
        scanner.nextLine();

        Set<cardCredit> carduriBD;
        carduriBD = cardService.getAllCards();
        AuditService.getInstance().logAction("citire_carduri");

        if (optiunePlata == 2 && carduriBD.isEmpty()) {
            System.out.println("\nNu aveti carduri de credit salvate. Adaugati un card si incercati din nou.");
            return;
        }

        if (optiunePlata == 2) {
            System.out.println("\nSelectati cardul de credit:");
            int temp = 1;
            for (cardCredit card : carduriBD) {
                System.out.printf("%d. %s%n", temp++, card.toString());
            }
            System.out.print("Alegeti cardul: ");
            int cardIndex = scanner.nextInt();
            while (cardIndex < 1 || cardIndex > carduriBD.size()) {
                System.out.print("Optiune invalida. Introduceti un numar valid: ");
                cardIndex = scanner.nextInt();
            }
            scanner.nextLine();
        }
        else if (optiunePlata == 1) {
            System.out.println("\nPlata se va face cash la curier. Va recomandam sa aveti suma exacta.");
        }
        else {
            System.out.println("\nOptiune invalida. Comanda nu a fost plasata.");
            return;
        }

        Curier curierAleatoriu = curieri.get(random.nextInt(curieri.size()));

        double totalDePlata = 0;

        AuditService.getInstance().logAction("citire_produse_cos");
        for (Produs p : produsService.readProduseCos()) {
            totalDePlata += p.getPret();
        }

        if(codAles!=null) {
            System.out.println("Total de plata: " + totalDePlata);
            totalDePlata = totalDePlata - (totalDePlata * reducere) / 100;
            System.out.println("Total de plata dupa reducere: " + totalDePlata);
            codService.updatevalabilitateCod(codAles.getId());
        }

        Comanda comandaPlasata = new Comanda(
                comenzi.size() + 1, produsService.readProduseCos(), restaurantAles,
                totalDePlata, LocalDate.now(), curierAleatoriu
        );
        comenzi.add(comandaPlasata);

        this.cos = new Cos(1, null, new ArrayList<>(), 0);
        produsService.deleteProduse();
        AuditService.getInstance().logAction("stergere_produse_cos");

        System.out.println("\nComanda a fost plasata cu succes!");

        System.out.println("\nDetalii livrare:");
        System.out.println(curierAleatoriu.toString());

        System.out.println("\nNu uitati sa lasati un review in meniul interactiv!");
    }

    public void vizualizareFosteComenzi() {
        System.out.println("\nIstoric Comenzi:");

        if (comenzi.isEmpty()) {
            System.out.println("\nNu exista comenzi in istoric.");
            System.out.println("Plasati o comanda pentru a o vedea aici.");
        } else {
            int numarComanda = 1;
            for (Comanda comanda : comenzi) {
                System.out.println("\nComanda #" + numarComanda++);
                System.out.println("Data: " + comanda.getData());
                System.out.println("Restaurant: " + comanda.getRestaurant().getNume());
                System.out.println("Curier: " + comanda.getCurier().getNume());
                System.out.printf("Total: %.2f RON\n", comanda.getPretTotal());

                System.out.println("\nProduse comandate:");
                int produsIndex = 1;
                for (Produs produs : comanda.getProduse()) {
                    System.out.printf("%d. %s - %.2f RON\n", produsIndex++, produs.getNume(), produs.getPret());
                }
                System.out.println("------------------------------------------");
            }
        }
    }

    public void filtrareRestaurante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFiltrare Restaurante");

        Set<String> categoriiUnice = new HashSet<>();
        for(Restaurant r : this.restaurants) {
            categoriiUnice.add(r.getCategorie());
        }

        System.out.println("\nCategoriile disponibile:");
        for(String categorie : categoriiUnice) {
            System.out.println(" - " + categorie);
        }

        boolean gasit = false;
        while(!gasit) {
            System.out.print("\nIntroduceti categoria dorita: ");
            String optiune = scanner.nextLine().trim();

            for (Restaurant r : this.restaurants) {
                if (optiune.equalsIgnoreCase(r.getCategorie())) {
                    System.out.println("\nRestaurant gasit!");
                    System.out.println(r);
                    gasit = true;
                    break;
                }
            }

            if(!gasit) {
                System.out.println("\nCategorie invalida! Incercati din nou.");
                System.out.println("Categoriile valabile sunt:");
                for(String categorie : categoriiUnice) {
                    System.out.println(" - " + categorie);
                }
            }
        }
    }

    public void adaugareCardInMemorie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdaugare Card de Credit");

        String numarCard;
        while (true) {
            System.out.println("\nIntroduceti numarul cardului (16 cifre):");
            System.out.println(" • Exemplu: 1234 5678 9012 3456");
            System.out.println(" • Sau: 1234567890123456");
            System.out.print("Numar Card: ");
            numarCard = scanner.nextLine().replaceAll(" ", "");

            if (numarCard.matches("\\d{16}")) {
                numarCard = numarCard.replaceAll("(\\d{4})(?=\\d)", "$1 ");
                break;
            } else {
                System.out.println("\nEroare: Numarul cardului trebuie sa contina exact 16 cifre!");
            }
        }

        String tipCard;
        while (true) {
            System.out.println("\nIntroduceti tipul cardului (exemplu: Visa, MasterCard):");
            System.out.print("Tip Card: ");
            tipCard = scanner.nextLine();

            if (tipCard.matches("[a-zA-Z\\s]{1,15}")) {
                tipCard = tipCard.substring(0, 1).toUpperCase() + tipCard.substring(1).toLowerCase();
                break;
            } else {
                System.out.println("\nEroare: Tipul cardului poate contine doar litere (maxim 15 caractere)!");
            }
        }

        String CVV;
        while (true) {
            System.out.println("\nIntroduceti codul CVV (3 cifre pe spatele cardului):");
            System.out.print("CVV: ");
            CVV = scanner.nextLine();

            if (CVV.matches("\\d{3}")) {
                break;
            } else {
                System.out.println("\nEroare: CVV-ul trebuie sa contina exact 3 cifre!");
            }
        }

        System.out.println("\nConfirmare Card:");
        System.out.printf("Tip Card: %-19s\n", tipCard);
        System.out.printf("Numar Card: %-19s\n", numarCard);
        System.out.printf("CVV: %-19s\n", "***");

        System.out.print("\nConfirmati adaugarea cardului? (Da/Nu): ");
        String confirmare = scanner.nextLine();

        carduri = cardService.getAllCards();
        AuditService.getInstance().logAction("citire_carduri");

        if (confirmare.equalsIgnoreCase("Da")) {
            carduri.add(new cardCredit(carduri.size() + 1, numarCard, tipCard, CVV));
            cardService.adaugaCard(new cardCredit(carduri.size(), numarCard, tipCard, CVV));
            AuditService.getInstance().logAction("adauga_card");
            System.out.println("\nCard adaugat cu succes!");
        } else {
            System.out.println("\nOperatiune anulata. Cardul nu a fost salvat.");
        }
    }

    public void addReviewToRestaurant() {
        Scanner scanner = new Scanner(System.in);

        if (comenzi.isEmpty()) {
            System.out.println("\nNu aveti comenzi plasate.");
            System.out.println("Pentru a lasa un review, va rugam sa plasati o comanda mai intai.");
            return;
        }

        System.out.println("\nAdaugare Review pentru Restaurant");
        System.out.println("Selectati comanda pentru care doriti sa lasati un review:");

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
            System.out.print("\nIntroduceti numarul comenzii: ");
            try {
                optiune = scanner.nextInt();
                scanner.nextLine();

                if (optiune < 1 || optiune > comenzi.size()) {
                    System.out.println("Va rugam sa introduceti un numar intre 1 si " + comenzi.size());
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        Comanda comandaAleasa = comenzi.get(optiune - 1);
        Restaurant restaurant = comandaAleasa.getRestaurant();

        double scor;
        while (true) {
            System.out.print("\nNota dvs. (1-5 stele): ");
            try {
                scor = scanner.nextDouble();
                scanner.nextLine();

                if (scor < 1 || scor > 5) {
                    System.out.println("Nota trebuie sa fie intre 1 si 5!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        System.out.println("\nSpuneti-ne parerea dvs. (max 200 caractere):");
        System.out.print(" ");
        String comentariu = scanner.nextLine();

        List<Review> reviewsLasate = reviewService.readReviews();
        AuditService.getInstance().logAction("citire_reviewuri");

        List<Review> reviews = restaurant.getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        Review reviewNou = new Review(reviewsLasate.size() + 1, scor, comentariu);
        reviews.add(reviewNou);
        reviewsLasate.add(reviewNou);
        restaurant.setReviews(reviews);
        reviewService.adaugaReview(reviewNou);
        AuditService.getInstance().logAction("adauga_review");
        System.out.println("\nReview adaugat cu succes!");
        System.out.println("\nMultumim pentru feedback-ul dumneavoastra despre:");
        System.out.println(restaurant.getNume());
        System.out.printf("Scor: %.1f/5\n", scor);
        System.out.println("Comentariu: " + comentariu);
    }

    public void addReviewToCurier() {
        if (comenzi.isEmpty()) {
            System.out.println("Nu puteti lasa review-uri daca nu aveti comenzi plasate.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdaugare Review pentru Curier");
        System.out.println("Selectati comanda pentru care doriti sa lasati un review:");

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
            System.out.print("\nIntroduceti numarul comenzii: ");
            try {
                optiune = scanner.nextInt();
                scanner.nextLine();

                if (optiune < 1 || optiune > comenzi.size()) {
                    System.out.println("Va rugam sa introduceti un numar intre 1 si " + comenzi.size());
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        Comanda comandaAleasa = comenzi.get(optiune - 1);
        Curier curierAles = comandaAleasa.getCurier();

        double scor;
        while (true) {
            System.out.print("\nNota dvs. (1-5 stele): ");
            try {
                scor = scanner.nextDouble();
                scanner.nextLine();

                if (scor < 1 || scor > 5) {
                    System.out.println("Nota trebuie sa fie intre 1 si 5!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        System.out.println("\nSpuneti-ne parerea dvs. (max 200 caractere):");
        System.out.print(" ");
        String comentariu = scanner.nextLine();


        List<Review> reviewsLasate = reviewService.readReviews();
        AuditService.getInstance().logAction("citire_review");


        List<Review> reviews = curierAles.getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        Review reviewNou = new Review(reviewsLasate.size() + 1, scor, comentariu);
        reviews.add(reviewNou);
        reviewsLasate.add(reviewNou);
        curierAles.setReviews(reviews);
        reviewService.adaugaReview(reviewNou);
        AuditService.getInstance().logAction("adauga_review");
        System.out.println("\nReview adaugat cu succes!");
        System.out.println("\nMultumim pentru feedback-ul dumneavoastra despre:");
        System.out.println(curierAles.getNume());
        System.out.printf("Scor: %.1f/5\n", scor);
        System.out.println("Comentariu: " + comentariu);
    }


    public void deleteOrder() {
        Scanner scanner = new Scanner(System.in);

        if (comenzi.isEmpty()) {
            System.out.println("\nNu aveti comenzi plasate. Nu se poate sterge nimic.");
            return;
        }

        System.out.println("\nAlegeti comanda pe care doriti sa o stergeti:");

        int index = 1;
        for (Comanda comanda : comenzi) {
            System.out.printf("Comanda #%d:\n", index);
            System.out.println("Restaurant: " + comanda.getRestaurant().getNume());
            System.out.println("Data: " + comanda.getData());
            System.out.printf("Total: %.2f\n", comanda.getPretTotal());
            System.out.println("====================================");
            index++;
        }

        int optiune;
        while (true) {
            System.out.print("\nIntroduceti numarul comenzii de sters (0 pentru anulare): ");
            try {
                optiune = scanner.nextInt();
                scanner.nextLine();

                if (optiune == 0) {
                    System.out.println("Stergerea a fost anulata.");
                    return;
                }

                if (optiune < 1 || optiune > comenzi.size()) {
                    System.out.println("Eroare: Introduceti un numar intre 1 si " + comenzi.size());
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Eroare: Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        System.out.println("\nSigur doriti sa stergeti aceasta comanda?");
        System.out.println("1. Da");
        System.out.println("2. Nu");

        int confirmare;
        while (true) {
            System.out.print("Selectati optiunea: ");
            try {
                confirmare = scanner.nextInt();
                scanner.nextLine();

                if (confirmare == 2) {
                    System.out.println("Stergerea a fost anulata.");
                    return;
                }

                if (confirmare != 1) {
                    System.out.println("Introduceti 1 sau 2!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Eroare: Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        Comanda comandaStearsa = comenzi.remove(optiune - 1);

        System.out.println("\nComanda a fost stearsa cu succes!");
        System.out.println("Detalii comanda stearsa:");
        System.out.println("Restaurant: " + comandaStearsa.getRestaurant().getNume());
        System.out.println("Data: " + comandaStearsa.getData());
        System.out.printf("Total: %.2f\n", comandaStearsa.getPretTotal());
    }

    public void modificareCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nModificare Card de Credit");

        List<cardCredit> carduriBD;
        carduriBD = new ArrayList<>(cardService.getAllCards());
        AuditService.getInstance().logAction("citire_carduri");

        if (carduriBD.isEmpty()) {
            System.out.println("Nu aveti carduri salvate.");
        } else {

            System.out.println("\nSelectati cardul de credit:");
            int temp = 1;
            carduriBD.sort(Comparator.comparingInt(cardCredit::getId));
            for (cardCredit card : carduriBD) {
                System.out.printf("%d. %s%n", temp++, card.toString());
            }
            System.out.print("Alegeti cardul: ");
            int cardIndex = scanner.nextInt();
            while (cardIndex < 1 || cardIndex > carduriBD.size()) {
                System.out.print("Optiune invalida. Introduceti un numar valid: ");
                cardIndex = scanner.nextInt();
            }
            scanner.nextLine();

            String numarCard;
            while (true) {
                System.out.println("\nIntroduceti numarul cardului (16 cifre):");
                System.out.println(" • Exemplu: 1234 5678 9012 3456");
                System.out.println(" • Sau: 1234567890123456");
                System.out.print("Numar Card: ");
                numarCard = scanner.nextLine().replaceAll(" ", "");

                if (numarCard.matches("\\d{16}")) {
                    numarCard = numarCard.replaceAll("(\\d{4})(?=\\d)", "$1 ");
                    break;
                } else {
                    System.out.println("\nEroare: Numarul cardului trebuie sa contina exact 16 cifre!");
                }
            }

            String tipCard;
            while (true) {
                System.out.println("\nIntroduceti tipul cardului (exemplu: Visa, MasterCard):");
                System.out.print("Tip Card: ");
                tipCard = scanner.nextLine();

                if (tipCard.matches("[a-zA-Z\\s]{1,15}")) {
                    tipCard = tipCard.substring(0, 1).toUpperCase() + tipCard.substring(1).toLowerCase();
                    break;
                } else {
                    System.out.println("\nEroare: Tipul cardului poate contine doar litere (maxim 15 caractere)!");
                }
            }

            String CVV;
            while (true) {
                System.out.println("\nIntroduceti codul CVV (3 cifre pe spatele cardului):");
                System.out.print("CVV: ");
                CVV = scanner.nextLine();

                if (CVV.matches("\\d{3}")) {
                    break;
                } else {
                    System.out.println("\nEroare: CVV-ul trebuie sa contina exact 3 cifre!");
                }
            }

            System.out.println("\nConfirmare Card:");
            System.out.printf("Tip Card: %-19s\n", tipCard);
            System.out.printf("Numar Card: %-19s\n", numarCard);
            System.out.printf("CVV: %-19s\n", "***");

            System.out.print("\nConfirmati adaugarea cardului? (Da/Nu): ");
            String confirmare = scanner.nextLine();

            if (confirmare.equalsIgnoreCase("Da")) {
                cardService.updateCard(cardIndex, numarCard, tipCard, CVV);
                AuditService.getInstance().logAction("modificare_card");
                carduri = cardService.getAllCards();
                System.out.println("\nCard adaugat cu succes!");
            } else {
                System.out.println("\nOperatiune anulata. Cardul nu a fost salvat.");
            }
        }
    }

    public void stergereCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nStergere Card de Credit");

        Set<cardCredit> carduriBD;
        carduriBD = cardService.getAllCards();
        AuditService.getInstance().logAction("citire_carduri");
        System.out.println("\nSelectati cardul de credit:");
        int temp = 1;
        for (cardCredit card : carduriBD) {
            System.out.printf("%d. %s%n", temp++, card.toString());
        }
        System.out.print("Alegeti cardul: ");
        int cardIndex = scanner.nextInt();
        while (cardIndex < 1 || cardIndex > carduriBD.size()) {
            System.out.print("Optiune invalida. Introduceti un numar valid: ");
            cardIndex = scanner.nextInt();
        }
        scanner.nextLine();

        cardService.deleteCard(cardIndex);
        AuditService.getInstance().logAction("stergere_card");
        System.out.println("Cardul a fost sters cu succes");
        if(!cardService.getAllCards().isEmpty()) {
            for (cardCredit card : cardService.getAllCards()) {
                if (card.getId() > cardIndex) {
                    cardService.deleteCard(card.getId());
                    int idScazut = card.getId() - 1;
                    cardCredit cardReconstruit = new cardCredit(idScazut, card.getNumarCard(), card.getTipCard(), card.getCVV());
                    cardService.adaugaCard(cardReconstruit);
                }
            }
        }
    }

    public void modificareReview() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelectati review-ul pe care vreti sa-l modificati: ");

        List<Review> reviewsLasate = reviewService.readReviews();
        AuditService.getInstance().logAction("citire_reviews");

        int temp = 1;
        for (Review review : reviewsLasate) {
            System.out.printf("%d. %s%n", temp++, review.toString());
        }
        System.out.print("Alegeti review-ul: ");
        int reviewIndex = scanner.nextInt();
        while (reviewIndex < 1 || reviewIndex > reviewsLasate.size()) {
            System.out.print("Optiune invalida. Introduceti un numar valid: ");
            reviewIndex = scanner.nextInt();
        }
        scanner.nextLine();

        double scor;
        while (true) {
            System.out.print("\nNota dvs. (1-5 stele): ");
            try {
                scor = scanner.nextDouble();
                scanner.nextLine();

                if (scor < 1 || scor > 5) {
                    System.out.println("Nota trebuie sa fie intre 1 si 5!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduceti doar numere!");
                scanner.nextLine();
            }
        }

        System.out.println("\nSpuneti-ne parerea dvs. (max 200 caractere):");
        System.out.print(" ");
        String comentariu = scanner.nextLine();

        reviewService.updateReview(reviewIndex, scor, comentariu);
        AuditService.getInstance().logAction("modificare_review");

        System.out.println("Review actualizat cu succes.");
    }

    public void stergereReview() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelectati review-ul pe care vreti sa-l stergeti: ");

        List<Review> reviewsLasate = reviewService.readReviews();
        AuditService.getInstance().logAction("citire_reviewuri");
        int temp = 1;
        for (Review review : reviewsLasate) {
            System.out.printf("%d. %s%n", temp++, review.toString());
        }
        System.out.print("Alegeti review-ul: ");
        int reviewIndex = scanner.nextInt();
        while (reviewIndex < 1 || reviewIndex > reviewsLasate.size()) {
            System.out.print("Optiune invalida. Introduceti un numar valid: ");
            reviewIndex = scanner.nextInt();
        }
        scanner.nextLine();

        reviewService.deleteReview(reviewIndex);
        AuditService.getInstance().logAction("stergere_review");
        System.out.println("Review sters cu succes.");
        if(!reviewService.readReviews().isEmpty()) {
            for (Review review : reviewService.readReviews()) {
                if (review.getId() > reviewIndex) {
                    reviewService.deleteReview(review.getId());
                    int idScazut = review.getId() - 1;
                    Review reviewReconstruit = new Review(idScazut, review.getScore(), review.getComentariu());
                    reviewService.adaugaReview(reviewReconstruit);
                }
            }
        }
    }

    public void modificareProdus() {
        Scanner scanner = new Scanner(System.in);

        List<Produs> produseDB;
        produseDB = produsService.readProduseCos();
        AuditService.getInstance().logAction("citire_produse_cos");

        if(produseDB.isEmpty()) {
            System.out.println("Nu aveti produse in cos.");
        }
        else {

            System.out.println("\nSelectati produsul:");
            int temp = 1;
            produseDB.sort(Comparator.comparingInt(Produs::getId));
            for (Produs produs : produseDB) {
                System.out.printf("%d. %s%n", temp++, produs.toString());
            }
            System.out.print("Alegeti produsul: ");
            int produsIndex = scanner.nextInt();
            while (produsIndex < 1 || produsIndex > produseDB.size()) {
                System.out.print("Optiune invalida. Introduceti un numar valid: ");
                produsIndex = scanner.nextInt();
            }
            scanner.nextLine();

            List<Produs> produse = produsService.readProduseCos();
            Produs produsAles = produse.getFirst();

            int id = produsService.getRestaurantId(produsAles);
            AuditService.getInstance().logAction("citire_restaurant_cos");
            Restaurant restaurantAles = null;
            for (Restaurant restaurant : this.restaurants) {
                if (restaurant.getId() == id) {
                    restaurantAles = restaurant;
                }
            }

            System.out.println("Alegeti alt produs cu care vreti sa-l schimbati: ");

            produsAles = alegeProdus(scanner, restaurantAles);
            produsService.updateProdusCos(produsAles, produsIndex);
            AuditService.getInstance().logAction("modificare_produs_cos");

            System.out.println("Produsul a fost schimbat cu succes.");

        }
    }

    public void stergereProdusCos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nStergere produs din cos: ");

        List<Produs> produseDB;
        produseDB = produsService.readProduseCos();
        AuditService.getInstance().logAction("citire_produse_cos");

        if (produseDB.isEmpty()) {
            System.out.println("Nu aveti produs in cos.");
        } else {
            System.out.println("\nSelectati produsul:");
            int temp = 1;
            produseDB.sort(Comparator.comparingInt(Produs::getId));
            for (Produs produs : produseDB) {
                System.out.printf("%d. %s%n", temp++, produs.toString());
            }
            System.out.print("Alegeti produsul: ");
            int produsIndex = scanner.nextInt();
            while (produsIndex < 1 || produsIndex > produseDB.size()) {
                System.out.print("Optiune invalida. Introduceti un numar valid: ");
                produsIndex = scanner.nextInt();
            }
            scanner.nextLine();

            produsService.deleteProdusCos(produsIndex);
            AuditService.getInstance().logAction("stergere_produs_cos");
            System.out.println("Produsul a fost sters cu succes.");
            if(!produsService.readProduseCos().isEmpty()) {
                Restaurant restaurantAles = null;
                produseDB = produsService.readProduseCos();
                int restaurantId = produsService.getRestaurantId(produseDB.getFirst());
                for(Restaurant restaurant : this.restaurants) {
                    if (restaurant.getId() == restaurantId) {
                        restaurantAles = restaurant;
                    }
                }
                for (Produs produs : produseDB) {
                    if (produs.getId() > produsIndex) {
                        produsService.deleteProdusCos(produs.getId());
                        int idScazut = produs.getId() - 1;
                        Produs produsReconstruit = new Produs(idScazut, produs.getNume(), produs.getPret(), produs.getDisponibilitate());
                        produsService.adaugaInCos(produsReconstruit, restaurantAles);
                    }
                }
            }
        }
    }

    public void adaugareCodPromotional() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdaugare cod promotional: ");

        String cod;
        while (true) {
            System.out.println("\nIntroduceti codul promotional: ");
            System.out.println(" • Exemplu: GLOVO10");
            System.out.print("Introducere cod promotional: ");
            cod = scanner.nextLine();

            if (cod.matches("[A-Za-z]{5}\\d{2}")) {
                System.out.println("Structura valida.");
                break;
            } else {
                System.out.println("\nEroare: codul introdus nu este conform structurii.");
            }
        }

        String valabilitate;
        double rand = Math.random();

        if (rand < 0.5) {
            valabilitate = "invalid";
        } else {
            valabilitate = "valid";
        }

        List<Cod> coduri_promotionale = codService.getAllCodes();

        Cod cod_promotional = new Cod(coduri_promotionale.size() + 1, cod, valabilitate);
        this.codService.adaugaCod(cod_promotional);

        System.out.println("\nCod promotional adaugat cu succes.");
        System.out.println("Pentru a vedea valabilitatea sa, incearca sa il aplici la plasarea comenzii.");
    }

    public void vizualizareCoduriPromotionale() {
        System.out.println();
        System.out.println("Acestea sunt codurile dvs. promotionale: ");
        this.coduri = this.codService.getAllCodes();
        for(Cod cod : coduri) {
            System.out.println(cod.toString());
        }
    }

    public void modificareCodPromotional() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nModificare cod promotional");

        List<Cod> coduriDB;
        coduriDB = new ArrayList<>(codService.getAllCodes());

        if (coduriDB.isEmpty()) {
            System.out.println("Nu aveti coduri salvate.");
        } else {

            System.out.println("\nSelectati codul promotional:");
            int temp = 1;
            coduriDB.sort(Comparator.comparingInt(Cod::getId));
            for (Cod cod : coduriDB) {
                System.out.printf("%d. %s%n", temp++, cod.toString());
            }
            System.out.print("Alegeti codul: ");
            int codIndex = scanner.nextInt();
            while (codIndex < 1 || codIndex > coduriDB.size()) {
                System.out.print("Optiune invalida. Introduceti un numar valid: ");
                codIndex = scanner.nextInt();
            }
            scanner.nextLine();

            String cod;
            while (true) {
                System.out.println("\nIntroduceti codul promotional: ");
                System.out.println(" • Exemplu: GLOVO10");
                System.out.print("Introducere cod promotional: ");
                cod = scanner.nextLine();

                if (cod.matches("[A-Za-z]{5}\\d{2}")) {
                    System.out.println("Structura valida.");
                    break;
                } else {
                    System.out.println("\nEroare: codul introdus nu este conform structurii.");
                }
            }

            String valabilitate;
            double rand = Math.random();

            if (rand < 0.5) {
                valabilitate = "invalid";
            } else {
                valabilitate = "valid";
            }

            codService.updateCod(codIndex, cod, valabilitate);
            coduri = codService.getAllCodes();
            System.out.println("\nCod modificat cu succes.");
        }
    }

    public void stergereCodPromotional() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nStergere cod promotional: ");

        List<Cod> coduriDB;
        coduriDB = codService.getAllCodes();

        if (coduriDB.isEmpty()) {
            System.out.println("Nu aveti coduri promotionale.");
        } else {
            System.out.println("\nSelectati codul promotional dorit: ");
            int temp = 1;
            coduriDB.sort(Comparator.comparingInt(Cod::getId));
            for (Cod cod : coduriDB) {
                System.out.printf("%d. %s%n", temp++, cod.toString());
            }
            System.out.print("Alegeti produsul: ");
            int codIndex = scanner.nextInt();
            while (codIndex < 1 || codIndex > coduriDB.size()) {
                System.out.print("Optiune invalida. Introduceti un numar valid: ");
                codIndex = scanner.nextInt();
            }
            scanner.nextLine();

            codService.deleteCod(codIndex);
            System.out.println("Codul a fost sters cu succes.");
            if(!codService.getAllCodes().isEmpty()) {
                coduriDB = codService.getAllCodes();
                for (Cod cod : coduriDB) {
                    if (cod.getId() > codIndex) {
                        codService.deleteCod(cod.getId());
                        int idScazut = cod.getId() - 1;
                        Cod codReconstruit = new Cod(idScazut, cod.getCod(), cod.getValabilitate());
                        codService.adaugaCod(codReconstruit);
                    }
                }
            }
        }
    }
}
