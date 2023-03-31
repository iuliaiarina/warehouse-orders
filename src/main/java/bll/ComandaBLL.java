package bll;

import dao.ComandaDAO;
import model.Comanda;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa care incapsuleaza Business Logic -ul comenzii. Campul comandaDAO este folosit pentru aplearea metodelor din clasa ComandaDAO
 */
public class ComandaBLL {
    private ComandaDAO  comandaDAO;

    public ComandaBLL() {
        comandaDAO = new ComandaDAO();
    }


    public Comanda findComandaById(int id) {
        Comanda cl = comandaDAO.findById(id);
        if (cl == null) {
            throw new NoSuchElementException("The Comanda with id =" + id + " was not found!");
        }
        return cl;
    }
    public List<Comanda> findALL() {
        List<Comanda> cl = comandaDAO.findAll();
        if (cl == null) {
            throw new NoSuchElementException("The Comanda was not found!");
        }
        return cl;
    }
    public void insert(Comanda comanda) {
        comandaDAO.insert(comanda);
    }
    public void deleteById(int id) {
        comandaDAO.delete(id);
    }
    public void update(String fild,int id, Object value) {
        comandaDAO.update(fild,id,value);
    }
}
