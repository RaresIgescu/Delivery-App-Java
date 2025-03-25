import java.util.List;

public class Review {
    private int id;
    private double scor;
    private String comentariu;

    public Review(int id, double scor, String comentariu) {
        this.id = id;
        this.scor = scor;
        this.comentariu = comentariu;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return scor;
    }
    public void setScore(double scor) {
        this.scor = scor;
    }

    public String getComentariu() {
        return comentariu;
    }
    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public String toString() {
        return "\nScor: " + scor + "\nComentariu: " + comentariu + "\n";
    }

}
