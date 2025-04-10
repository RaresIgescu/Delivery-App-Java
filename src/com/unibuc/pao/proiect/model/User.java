package src.com.unibuc.pao.proiect.model;

public class User extends Persoana {
    private int varsta;
    private String oras;
    private String strada;

    public User(int id, String nume, String prenume, int varsta, String oras, String strada) {
        super(id, nume, prenume);
        this.varsta = varsta;
        this.oras = oras;
        this.strada = strada;
    }

    public int getVarsta() {
        return varsta;
    }
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getOras() {
        return oras;
    }
    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }
    public void setStrada(String strada) {
        this.strada = strada;
    }

    @Override
    public String toString() {
        return "\n======================================\n" +
                "Acestea sunt datele dumneavoastră personale:\n" +
                "======================================\n" +
                super.toString() + "\n" +
                "Varsta:  \t" + varsta + "\n" +
                "Oras:    \t" + oras + "\n" +
                "Strada:  \t" + strada + "\n" +
                "======================================";
    }

}
