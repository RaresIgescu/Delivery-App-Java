import java.util.List;

public class Cos {
    private int id;
    private List<Produs> produse;
    private double totalDePlata;

    public Cos(int id, List<Produs> produse, double totalDePlata) {
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produs p : produse) {
            sb.append(p.toString());
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("====================================\n");
        sb.append("\tTotal de plata: " + totalDePlata);
        sb.append("\n====================================");
        return sb.toString();
    }

}
