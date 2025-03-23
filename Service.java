import java.util.*;

public class Service {
    private User user;
    private final Set<Restaurant> restaurants;
    private final Map<Restaurant, List<Produs>> meniuri;
    private final Set<Curier> curieri;
    private final Cos cos;
    private final List<Comanda> comenzi;
    private final Set<cardCredit> carduri;

    public Service() {
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
                new Produs(3, "Ciorba de burta", 30.20, "Indisponibil"),
                new Produs(4, "Sarmale cu mamaliga", 45.70, "Disponibil!"),
                new Produs(5, "Mici la gratar cu mustar", 28.90, "Disponibil!")
        );

        List<Produs> produseBig5 = Arrays.asList(
                new Produs(5, "Burger American", 50.0, "Disponibil!"),
                new Produs(6, "Coaste BBQ", 70.0, "Disponibil!"),
                new Produs(7, "Clatite pufoase", 35.50, "Disponibil de la 30.06.2025")
        );

        for (Restaurant r : this.restaurants) {
            switch (r.getNume()) {
                case "AveForchetta" -> this.meniuri.put(r, produseAveForchetta);
                case "Linea" -> this.meniuri.put(r, produseLinea);
                case "Big 5" -> this.meniuri.put(r, produseBig5);
            }
        }

        this.curieri = new HashSet<>();
        this.cos = null;
        this.comenzi = new ArrayList<>();
        this.carduri = new HashSet<>();
    }

    public void setareDatePersonale() {
        Scanner scanner = new Scanner(System.in);

        int id = 1;

        System.out.println("Introduceti un nume: ");
        String nume = scanner.nextLine();

        System.out.println("Introduceti un prenume: ");
        String prenume = scanner.nextLine();

        System.out.println("Introduceti o varsta: ");
        int varsta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceti un oras: ");
        String oras = scanner.nextLine();

        System.out.println("Introduceti o strada: ");
        String strada = scanner.nextLine();

        user = new User(id, nume, prenume, varsta, oras, strada);
    }

    public void vizualzareDatePersonale() {
        System.out.println(user.toString());
    }

    public void vizualizareMeniu() {
        for(Restaurant r : this.restaurants) {
            System.out.println("Meniul restaurantului " + r.getNume());
            List<Produs> produse = this.meniuri.get(r);
            for(Produs p : produse) {
                System.out.println(p.toString());
                System.out.println();
            }
            System.out.println();
        }
    }
}
