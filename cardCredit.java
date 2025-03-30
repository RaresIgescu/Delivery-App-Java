public class cardCredit {
    private int id;
    private String numarCard;
    private String tipCard;
    private String CVV;

    public cardCredit(int id, String numarCard, String tipCard, String CVV) {
        this.id = id;
        this.numarCard = numarCard;
        this.tipCard = tipCard;
        this.CVV = CVV;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNumarCard() {
        return numarCard;
    }
    public void setNumarCard(String numarCard) {
        this.numarCard = numarCard;
    }

    public String getTipCard() {
        return tipCard;
    }
    public void setTipCard(String tipCard) {
        this.tipCard = tipCard;
    }

    public String getCVV() {
        return CVV;
    }
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String toString() {
        return "NumarCard: " + numarCard  + "\nTipCard: " + tipCard + "\nCVV: " + CVV;

    }
}
