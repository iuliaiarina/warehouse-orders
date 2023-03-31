package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdusDAO extends AbstractDAO<Produs>{

    protected static final Logger LOGGER = Logger.getLogger(ProdusDAO.class.getName());

    private final static String updateNumeStatementString = "UPDATE Produs SET nume = ?	WHERE id=?";

    private final static String updatePrenumeStatementString = "UPDATE Produs SET pret = ?	WHERE id=?";

    private final static String updateVarstaStatementString = "UPDATE Produs SET cantitate = ?	WHERE id=?";

    /**
     *  urmatoarele trei functii efectueaza update-uri pe fiecare
     *  camp al Clasei Produs: nume,pret,cantitate
     * @param nume
     * @param produsId
     */

    public static void updateNume(String nume,int produsId) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(updateNumeStatementString);
            findStatement.setString(1, nume);
            findStatement.setLong(2, produsId);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProdusDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
    public static void updatePret(Double pret,int produsId) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(updatePrenumeStatementString);
            findStatement.setDouble(1, pret);
            findStatement.setLong(2, produsId);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
    public static void updateCantitate(int cantitate,int produsId) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(updateVarstaStatementString);
            findStatement.setInt(1, cantitate);
            findStatement.setLong(2, produsId);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
}
