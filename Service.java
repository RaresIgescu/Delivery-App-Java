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
    void setareDatePersonale() {

    }
}
