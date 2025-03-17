import java.util.*;

public class Service {
    private List<User> users;
    private Set<Restaurant> restaurants;
    private Map<Restaurant, List<Produs>> meniuri;
    private Map<Restaurant, List<Review>> reviewRestaurant;
    private Map<Curier, List<Review>> reviewCurier;
    private Set<Curier> curieri;
    private Map<User, List<Produs>> cos;
    private Map<User, List<Comanda>> comenzi;
    private Map<User, List<cardCredit>> carduriSalvate;
    private Map<User, List<Review>> reviews;

    public Service() {
        users = new ArrayList<User>();
        restaurants = new HashSet<Restaurant>();
        meniuri = new HashMap<>();
        reviewRestaurant = new HashMap<>();
        reviewCurier = new HashMap<>();
        curieri = new HashSet<>();
        cos = new HashMap<>();
        comenzi = new HashMap<>();
        carduriSalvate = new HashMap<>();
        reviews = new HashMap<>();
    }


}
