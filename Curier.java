import java.util.List;

public class Curier extends Persoana {
    private String nationalitate;
    private List<Review> reviews;

    public Curier(int id, String nume, String prenume, String nationalitate, List<Review> reviews) {
        super(id, nume, prenume);
        this.nationalitate = nationalitate;
        this.reviews = reviews;
    }
    public String getNationalitate() {
        return nationalitate;
    }
    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String toString() {
        return "-- Detalii Curier --\n" + super.toString() + "\nEtnie: \t\t" + nationalitate + "\nReviews: " + reviews;
    }
}
