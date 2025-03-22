import java.util.List;

public class Restaurant {
    private int id;
    private String nume;
    private String strada;
    private String oras;
    private String categorie;
    private List<Review> reviews;

    public Restaurant(int id, String nume, String strada, String oras, String categorie, List<Review> reviews) {
        this.id = id;
        this.nume = nume;
        this.strada = strada;
        this.oras = oras;
        this.categorie = categorie;
        this.reviews = reviews;
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

    public String getStrada() {
        return strada;
    }
    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getOras() {
        return oras;
    }
    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String toString() {
        return "Nume: " + nume + "\nStrada: " + strada + "\nOras: " + oras + "\nCategorie: " + categorie;
    }
}
