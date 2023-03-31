package model;

/**
 * Produsul contine patru campuri: nume,pret,cantitate si id;
 */
public class Produs {
    private String nume;
    private double pret;
    private int cantitate;
    private int id;

    public Produs() {
    }

    public Produs(String nume, double pret, int cantitate) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public Produs(String nume, double pret, int cantitate, int id) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", id=" + id +
                '}';
    }
}
