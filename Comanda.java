import java.util.List;

public class Comanda {
    private int id;
    private List<Produs> produse;
    private float pretTotal;
    private String data;
    private String status;

    public Comanda(int id, List<Produs> produse, float pretTotal, String data, String status) {
        this.id = id;
        this.produse = produse;
        this.pretTotal = pretTotal;
        this.data = data;
        this.status = status;
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

    public float getPretTotal() {
        return pretTotal;
    }
    public void setPretTotal(float pretTotal) {
        this.pretTotal = pretTotal;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
