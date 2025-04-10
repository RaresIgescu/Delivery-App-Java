package src.com.unibuc.pao.proiect.model;

import java.util.ArrayList;
import java.util.List;

public class Curier extends Persoana {
    private String nationalitate;
    private List<Review> reviews;

    public Curier(int id, String nume, String prenume, String nationalitate, List<Review> reviews) {
        super(id, nume, prenume);
        this.nationalitate = nationalitate;
        this.reviews = new ArrayList<>(reviews);
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

    public String toReviews(List<Review> reviews) {
        String reviewsString = "";
        for(Review r : reviews) {
            reviewsString = reviewsString + r.toString();
        }
        return reviewsString;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nEtnie: \t\t" + nationalitate + "\nReviews: " + toReviews(reviews);
    }
}
