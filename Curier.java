public class Curier {
    private int id;
    private String nume;
    private String prenume;
    private String nationalitate;
    private float rating;

    public Curier(int id, String nume, String prenume, String nationalitate, float rating) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nationalitate = nationalitate;
        this.rating = rating;
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

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    public String toString() {
        return "Nume: " + nume + "Prenume: " + prenume + "Nationalitate: " + nationalitate + "Rating: " + rating;
    }
}
