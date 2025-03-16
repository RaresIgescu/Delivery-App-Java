public class Produs {
    private int id;
    private String nume;
    private float pret;
    private String disponibilitate;

    public Produs(int id, String nume, float pret, String disponibilitate) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.disponibilitate = disponibilitate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }
    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }
    public void setDisponibilitate(String disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public String toString() {
        return "Nume: " + nume + "\nPret: " + pret + "\nDisponibilitate: " + disponibilitate;
    }
}
