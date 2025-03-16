import java.util.List;

public class Cos {
    private int id;
    private List<Produs> produse;
    private int totalDePlata;

    public Cos(int id, List<Produs> produse, int totalDePlata) {
        this.id = id;
        this.produse = produse;
        this.totalDePlata = totalDePlata;
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

    public int getTotalDePlata() {
        return totalDePlata;
    }
    public void setTotalDePlata(int totalDePlata) {
        this.totalDePlata = totalDePlata;
    }

    public String toString() {
        return "Produse: " + produse + "\nTotal de plata: " + totalDePlata;
    }
}
