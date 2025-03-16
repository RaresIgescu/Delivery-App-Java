import java.util.List;
import java.util.Map;
import java.util.Set;

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
}
