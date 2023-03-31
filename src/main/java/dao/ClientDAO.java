package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

public class ClientDAO extends AbstractDAO<Client>{
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private final static String updateNumeStatementString = "UPDATE Client SET nume = ?	WHERE id=?";

	private final static String updatePrenumeStatementString = "UPDATE Client SET prenume = ?	WHERE id=?";

	private final static String updateVarstaStatementString = "UPDATE Client SET varsta = ?	WHERE id=?";


	/**
	 *  urmatoarele trei functii efectueaza update-uri pe fiecare
	 *  camp al Clasei Client: nume,prenume,varsta
	 */
	public static void updateNume(String nume,int ClientId) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(updateNumeStatementString);
			findStatement.setString(1, nume);
			findStatement.setLong(2, ClientId);
			findStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public static void updatePrenume(String prenume,int ClientId) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(updatePrenumeStatementString);
			findStatement.setString(1, prenume);
			findStatement.setLong(2, ClientId);
			findStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	public static void updateVarsta(int varsta,int ClientId) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(updateVarstaStatementString);
			findStatement.setInt(1, varsta);
			findStatement.setLong(2, ClientId);
			findStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
}
