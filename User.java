public class User {
    private int id;
    private String nume;
    private String prenume;
    private int varsta;
    private String oras;
    private String strada;

    public User(int id, String nume, String prenume, int varsta, String oras, String strada) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.oras = oras;
        this.strada = strada;
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

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getOras() {
        return oras;
    }
    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }
    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String toString() {
        return "Nume: " + nume + "Prenume: " + prenume + "Varsta: " + varsta + "Oras: " + oras + "Strada: " + strada;
    }
}
