package start;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import bll.ComandaBLL;
import model.Client;
import model.Comanda;


public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		ClientBLL clientBll = new ClientBLL();

		Client client1 = new Client("mama","tata",90);

		try {
			clientBll.update("prenume",2,"jojo");
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
		// obtain field-value pairs for object through reflection
		//ReflectionExample.retrieveProperties(fg);

	}

}
