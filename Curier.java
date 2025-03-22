import java.util.List;

public class Curier extends Persoana {
    private String nationalitate;
    private List<Review> reviews;

    public Curier(int id, String nume, String prenume, String nationalitate, List<Review> review) {
        super(id, nume, prenume);
        this.nationalitate = nationalitate;
        this.reviews = review;
    }
    public String getNationalitate() {
        return nationalitate;
    }
    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public List<Review> getReview() {
        return reviews;
    }
    public void setReview(List<Review> review) {
        this.reviews = review;
    }

    public String toString() {
        return super.toString() + "\nNationalitate: " + nationalitate + "\nReviews: " + review;
    }
}
