package src.com.unibuc.pao.proiect.model;

public class Persoana {
    private int id;
    private String nume;
    private String prenume;

    public Persoana(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
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

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Nume: \t\t" + nume + "\nPrenume: \t" + prenume;
    }
}
