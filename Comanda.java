import java.util.List;
import java.time.LocalDate;

public class Comanda {
    private int id;
    private List<Produs> produse;
    private Restaurant restaurant;
    private double pretTotal;
    private LocalDate data;
    private Curier curier;

    public Comanda(int id, List<Produs> produse, Restaurant restaurant, double pretTotal, LocalDate data, Curier curier) {
        this.id = id;
        this.produse = produse;
        this.restaurant = restaurant;
        this.pretTotal = pretTotal;
        this.data = data;
        this.curier = curier;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Produs> getProduse() {
        return produse;
    }
    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public Restaurant getRestaurant() {return restaurant;}
    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;}

    public double getPretTotal() {
        return pretTotal;
    }
    public void setPretTotal(double pretTotal) {
        this.pretTotal = pretTotal;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public Curier getCurier() {
        return curier;
    }
    public void setCurier(Curier curier) {
        this.curier = curier;
    }

    @Override
    public String toString() {
        for(Produs p : produse)
            System.out.println(p.toString());
        return "Pret: " + pretTotal + "\nData: " + data + "\n";
    }
}
