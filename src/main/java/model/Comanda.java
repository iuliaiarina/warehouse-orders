package model;

/**
 * Comanda contine 4 campuri: id, clientid,produsid si cantitate
 */
public class Comanda {
    private int id;
    private int clientid;
    private int produsid;
    private int cantitate;

    public Comanda() {
    }

    public Comanda(int clientid, int produsid, int cantitate) {
        this.clientid = clientid;
        this.produsid = produsid;
        this.cantitate = cantitate;
    }

    public Comanda(int id, int clientid, int produsid, int cantitate) {
        this.id = id;
        this.clientid = clientid;
        this.produsid = produsid;
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getProdusid() {
        return produsid;
    }

    public void setProdusid(int produsid) {
        this.produsid = produsid;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", clientid=" + clientid +
                ", produsid=" + produsid +
                ", cantitate=" + cantitate +
                '}';
    }
}
