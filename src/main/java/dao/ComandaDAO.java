package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Comanda;
import model.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComandaDAO extends AbstractDAO<Comanda>{
    protected static final Logger LOGGER = Logger.getLogger(ProdusDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO Comanda (clientid,produsid,cantitate)"
            + " VALUES (?,?,?)";

    private final static String findAllString = "select * from Comanda ";


}
