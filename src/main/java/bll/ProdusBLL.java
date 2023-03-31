package bll;

import dao.ClientDAO;
import dao.ProdusDAO;
import model.Client;
import model.Produs;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa care incapsuleaza Business Logic -ul produsului. Campul produsDAO este folosit pentru aplearea metodelor din ProdusDAO
 */
public class ProdusBLL {

    private  ProdusDAO produsDAO;

    public ProdusBLL() {
        produsDAO =new ProdusDAO();
    }

    public Produs findProdusById(int id) {
        Produs cl = produsDAO.findById(id);
        if (cl == null) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return cl;
    }
    public List<Produs> findALL() {
        List<Produs> cl = produsDAO.findAll();
        if (cl == null) {
            throw new NoSuchElementException("The Client was not found!");
        }
        return cl;
    }
    public void insert(Produs produs) {
        produsDAO.insert(produs);
    }
    public void deleteById(int id) {
        produsDAO.delete(id);
    }
    public void update(String fild,int id, Object value) {
        produsDAO.update(fild,id,value);
    }
}
