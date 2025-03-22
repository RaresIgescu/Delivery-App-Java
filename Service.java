import java.util.*;

public class Service {
    private User user;
    private Set<Restaurant> restaurants;
    private Map<Restaurant, List<Produs>> meniuri;
    private Set<Curier> curieri;
    private Cos cos;
    private List<Comanda> comenzi;
    private Set<cardCredit> carduri;

    public Service() {
        this.user = null;
        this.restaurants = new HashSet<>();
        this.meniuri = new HashMap<>();
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
}
