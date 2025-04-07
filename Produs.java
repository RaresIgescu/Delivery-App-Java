public class Produs {
    private int id;
    private String nume;
    private double pret;
    private String disponibilitate;

    public Produs(int id, String nume, double pret, String disponibilitate) {
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

    public double getPret() {
        return pret;
    }
    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }
    public void setDisponibilitate(String disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    @Override
    public String toString() {
        return "\n┌────────────────────────────────────┐\n" +
                "│              PRODUS                │\n" +
                "├────────────────────────────────────┤\n" +
                String.format("│ %-12s: %-20s │\n", "Nume", nume) +
                String.format("│ %-12s: %-16.2f RON │\n", "Preț", pret) +
                String.format("│ %-12s: %-17s │\n", "Disponibilitate", disponibilitate ) +
                "└────────────────────────────────────┘";
    }
}
