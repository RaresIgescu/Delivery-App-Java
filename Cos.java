import java.util.List;

public class Cos {
    private int id;
    private Restaurant restaurant;
    private List<Produs> produse;
    private double totalDePlata;

    public Cos(int id, Restaurant restaurant, List<Produs> produse, double totalDePlata) {
        this.id = id;
        this.restaurant = restaurant;
        this.produse = produse;
        this.totalDePlata = totalDePlata;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int nrProduse() {
        return produse.size();
    }

    public List<Produs> getProduse() {
        return produse;
    }
    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public double getTotalDePlata() {
        return totalDePlata;
    }
    public void setTotalDePlata(double totalDePlata) {
        this.totalDePlata = totalDePlata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (Produs p : produse) {
            sb.append(String.format("║ %2d. %-30s ║\n", index++, p.getNume()));
            sb.append(String.format("║    %-6s: %-19.2f RON ║\n", "Preț", p.getPret()));
            sb.append("╠════════════════════════════════════╣\n");
        }
        return sb.toString();
    }

}
