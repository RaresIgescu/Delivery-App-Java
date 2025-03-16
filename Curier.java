public class Curier {
    private int id;
    private String nume;
    private String prenume;
    private String nationalitate;

    public Curier(int id, String nume, String prenume, String nationalitate) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nationalitate = nationalitate;
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

    public String getNationalitate() {
        return nationalitate;
    }
    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }
}
