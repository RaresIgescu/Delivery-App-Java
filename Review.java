public class Review {
    private int id;
    private float scor;
    private String comentariu;

    public Review(int id, float scor, String comentariu) {
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

    public float getScore() {
        return scor;
    }
    public void setScore(float scor) {
        this.scor = scor;
    }

    public String getComentariu() {
        return comentariu;
    }
    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }


    public String toString() {
        return "Scor: " + scor + "\nComentariu: " + comentariu;
    }
}
