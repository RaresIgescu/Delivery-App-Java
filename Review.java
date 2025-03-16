public class Review {
    private int id;
    private int scorRestaurant;
    private String comentariuRestaurant;
    private int scorCurier;
    private String comentariuCurier;

    public Review(int id, int scorRestaurant, String comentariuRestaurant, int scorCurier, String comentariuCurier) {
        this.id = id;
        this.scorRestaurant = scorRestaurant;
        this.comentariuRestaurant = comentariuRestaurant;
        this.scorCurier = scorCurier;
        this.comentariuCurier = comentariuCurier;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getScorRestaurant() {
        return scorRestaurant;
    }
    public void setScorRestaurant(int scorRestaurant) {
        this.scorRestaurant = scorRestaurant;
    }

    public String getComentariuRestaurant() {
        return comentariuRestaurant;
    }
    public void setComentariuRestaurant(String comentariuRestaurant) {
        this.comentariuRestaurant = comentariuRestaurant;
    }

    public int getScorCurier() {
        return scorCurier;
    }
    public void setScorCurier(int scorCurier) {
        this.scorCurier = scorCurier;
    }

    public String getComentariuCurier() {
        return comentariuCurier;
    }
    public void setComentariuCurier(String comentariuCurier) {
        this.comentariuCurier = comentariuCurier;
    }

    public String toString() {
        return "scorRestaurant: " + scorRestaurant + "\ncomentariuRestaurant: " + comentariuRestaurant + "\nscorCurier: " + scorCurier + "\nComentariuCurier: " + comentariuCurier;
    }
}
