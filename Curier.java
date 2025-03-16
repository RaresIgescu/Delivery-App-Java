public class Curier extends Persoana {
    private String nationalitate;
    private float rating;

    public Curier(int id, String nume, String prenume, String nationalitate, float rating) {
        super(id, nume, prenume);
        this.nationalitate = nationalitate;
        this.rating = rating;
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
        return super.toString() + "\nNationalitate: " + nationalitate + "\nRating: " + rating;
    }
}
