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
                new Produs(3, "Canoli cu Fistic", 22.50, "Valabil de la 22.04.2025!")
        );

        List<Produs> produseLinea = Arrays.asList(
                new Produs(4, "Ciorba de burta", 30.20, "Indisponibil"),
                new Produs(5, "Sarmale cu mamaliga", 45.70, "Disponibil!"),
                new Produs(6, "Mici la gratar cu mustar", 28.90, "Disponibil!")
        );

        List<Produs> produseBig5 = Arrays.asList(
                new Produs(7, "Burger American", 50.0, "Disponibil!"),
                new Produs(8, "Coaste BBQ", 70.0, "Disponibil!"),
                new Produs(9, "Clatite pufoase", 35.50, "Disponibil de la 30.06.2025")
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

        this.cos = new Cos(1, new ArrayList<Produs>(), 0);
        this.comenzi = new ArrayList<>();
        this.carduri = new LinkedHashSet<>();
    }

    public void setareDatePersonale() {
        Scanner scanner = new Scanner(System.in);

        int id = 1;

        System.out.println("Introduceti un nume: ");
        String nume = scanner.nextLine();
        while (!nume.matches("^[a-zA-Z]{4,20}$")) {
            System.out.println("Numele trebuie sa fie alcatuit din maxim 20 de litere.");
            nume = scanner.nextLine();
        }

        System.out.println("Introduceti un prenume: ");
        String prenume = scanner.nextLine();
        while (!prenume.matches("^[a-zA-Z-]{4,20}$")) {
            System.out.println("Prenumele trebuie sa fie alcatuit din maxim 20 de litere.");
            prenume = scanner.nextLine();
        }

        System.out.println("Introduceti o varsta: ");
        int varsta = scanner.nextInt();
        scanner.nextLine();
        while(varsta < 16 || varsta > 100) {
            System.out.println("Varsta invalida! Introduceti o varsta intre 16 si 100");
            varsta = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Introduceti un oras: ");
        String oras = scanner.nextLine();
        while(!oras.matches("^[a-zA-Z\s]{1,25}")) {
            System.out.println("Orasul poate avea maxim 25 de cifre si caractere.");
            oras = scanner.nextLine();
        }

        System.out.println("Introduceti o strada: ");
        String strada = scanner.nextLine();
        while(!strada.matches("^[a-zA-Z0-9\s]{1,30}$")) {
            System.out.println("Strada invalida! Mai incercati");
            strada = scanner.nextLine();
        }

        user = new User(id, nume, prenume, varsta, oras, strada);
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
        Produs produsAles = null;
        Restaurant restaurantAles = null;
        List<Produs> meniu = null;

        System.out.println("====================================");
        System.out.println(" Mai intai hai sa alegem restaurantul: ");
        System.out.println("====================================");

        int i = 1;
        for (Restaurant r : this.restaurants) {
            System.out.println(i + ". " + r.getNume());
            i++;
        }

        int optiune = scanner.nextInt();
        while (optiune < 1 || optiune > this.restaurants.size()) {
            System.out.println("====================================");
            System.out.println(" Alegere invalida! Te rog sa alegi un numar valid.");
            System.out.println("====================================");
            optiune = scanner.nextInt();
        }

        i = 1;
        for (Restaurant r : this.restaurants) {
            if (optiune == i) {
                restaurantAles = r;
                break;
            }
            i++;
        }

        meniu = this.meniuri.get(restaurantAles);
        System.out.println("====================================");
        System.out.println("   Restaurantul ales: " + restaurantAles.getNume());
        System.out.println("====================================");
        System.out.println("Alege produsul:");

        i = 1;
        for (Produs p : meniu) {
            System.out.println(i + ". " + p.toString());
            i++;
        }

        optiune = scanner.nextInt();
        while (optiune < 1 || optiune > meniu.size()) {
            System.out.println("====================================");
            System.out.println(" Alegere invalida! Te rog sa alegi un numar valid.");
            System.out.println("====================================");
            optiune = scanner.nextInt();
        }

        i = 1;
        for (Produs p : meniu) {
            if (optiune == i) {
                produsAles = p;
                break;
            }
            i++;
        }

        List<Produs> produse = this.cos.getProduse();
        produse.add(produsAles);

        for (Produs p : produse) {
            total += p.getPret();
        }

        this.cos = new Cos(1, produse, total);

        System.out.println("====================================");
        System.out.println(" Produsul a fost adăugat în coș!");
        System.out.println("====================================");
        vizualizareCos();
    }


    public void plasareComanda() {
        Scanner scanner = new Scanner(System.in);
        Comanda comandaPlasata = null;

        if (this.cos.nrProduse() == 0) {
            System.out.println("====================================");
            System.out.println(" \t\tCosul de cumparaturi este gol.");
            System.out.println(" Mai intai adauga produse in cos si mai apoi \n\t\t\tpoti plasa comanda.");
            System.out.println("====================================");
        } else {
            vizualizareCos();

            System.out.println("====================================");
            System.out.println(" Sunteti multumit cu starea cosului \n\t  de cumparaturi? (Da/Nu)");
            System.out.println("====================================");

            String optiune = scanner.nextLine();

            switch (optiune) {
                case "Da":
                    int indexAleatoriu = random.nextInt(curieri.size());
                    Curier curierAleatoriu = curieri.get(indexAleatoriu);

                    comandaPlasata = new Comanda(1, this.cos.getProduse(), this.cos.getTotalDePlata(), LocalDate.now(), curierAleatoriu);
                    comenzi.add(comandaPlasata);

                    this.cos = new Cos(1, new ArrayList<Produs>(), 0);

                    System.out.println("====================================");
                    System.out.println(" Comanda dumneavoastra a fost plasata cu succes.");
                    System.out.println("====================================");
                    break;

                case "Nu":
                    System.out.println("====================================");
                    System.out.println(" Comanda nu a fost plasata.");
                    System.out.println("====================================");
                    break;

                default:
                    System.out.println("====================================");
                    System.out.println(" Optiune invalida! Te rog sa alegi 'Da' sau 'Nu'.");
                    System.out.println("====================================");
                    break;
            }
        }
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
                System.out.println("----------------------------------------------"); // Separator între comenzi
            }
        }
    }


    public void filtrareRestaurante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce fel de restaurante va intereseaza?");
        for(Restaurant r : this.restaurants) {
            System.out.println("\t" + r.getCategorie());
        }
        String optiune = scanner.nextLine();
        boolean ok = true;
        while(ok) {
            for (Restaurant r : this.restaurants) {
                if (optiune.equals(r.getCategorie())) {
                    ok = false;
                    System.out.println(r.toString());
                }
                if(ok)
                {
                    System.out.println("Alegere invalida.");
                    optiune = scanner.nextLine();
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

}
