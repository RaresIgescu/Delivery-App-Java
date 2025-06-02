package src.com.unibuc.pao.proiect.model;

import java.sql.SQLOutput;

public class Cod {
    private int id;
    private String cod;
    private String valabilitate;

    public Cod(int id, String cod, String valabilitate) {
        this.id = id;
        this.cod = cod;
        this.valabilitate = valabilitate;
    }

    public int getId() {
        return id;
    }
    public String getCod() {
        return cod;
    }

    public String getValabilitate() {
        return valabilitate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setValabilitate(String valabilitate) {
        this.valabilitate = valabilitate;
    }

    @Override
    public String toString() {
        return "/===== COD =====/\nCod promotional: " + cod + "\nValabilitate: " + valabilitate + "\n";
    }
}
