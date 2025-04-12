package src.com.unibuc.pao.proiect.model;

import java.util.List;

public class Cos {
    private int id;
    private Restaurant restaurant;
    private List<Produs> produse;
    private double totalDePlata;

    public Cos(int id, Restaurant restaurant, List<Produs> produse, double totalDePlata) {
        this.id = id;
        this.restaurant = restaurant;
        this.produse = produse;
        this.totalDePlata = totalDePlata;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int nrProduse() {
        return produse.size();
    }

    public List<Produs> getProduse() {
        return produse;
    }
    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public double getTotalDePlata() {
        return totalDePlata;
    }
    public void setTotalDePlata(double totalDePlata) {
        this.totalDePlata = totalDePlata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (Produs p : produse) {
            // %2d -  va afisa un int, aliniat (implicit) la dreapta pe exact 2 caractere
            // adica daca v-a intalni un numar de o cifra, de ex 5, il va afisa " 5"

            // %-30s - va afisa un string, aliniat la stanga (pentru ca avem -), pe o lungime
            // de 30 de caractere

            //%-19.2f - va afisa un float (sau double) aliniat la stanga (de la -)
            //pe o lungime exacta de 19 caractere si cu exact 2 zecimale
            sb.append(String.format("%d. %-30s\n", index++, p.getNume()));
            sb.append(String.format("   Pret: %.2f RON\n", p.getPret()));
            sb.append("\n");
        }

        return sb.toString();
    }

}
