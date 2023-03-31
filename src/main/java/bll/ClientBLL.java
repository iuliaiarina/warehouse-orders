package bll;

import java.util.List;
import java.util.NoSuchElementException;

import dao.ClientDAO;
import model.Client;

/**
 * Clasa care incapsuleaza Business Logic -ul clientului. Campul clientDAO este folosit pentru aplearea metodelor din Client DAO
 */
public class ClientBLL {
	private ClientDAO clientDAO;

	public ClientBLL() {
		clientDAO = new ClientDAO();
	}


	public Client findClientById(int id) {
		Client cl = clientDAO.findById(id);
		if (cl == null) {
			throw new NoSuchElementException("The Client with id =" + id + " was not found!");
		}
		return cl;
	}
	public List<Client> findALL() {
		List<Client> cl = clientDAO.findAll();
		if (cl == null) {
			throw new NoSuchElementException("The Client was not found!");
		}
		return cl;
	}
	public void insert(Client client) {
		clientDAO.insert(client);
	}
	public void deleteById(int id) {
		 clientDAO.delete(id);
	}
	public void update(String fild,int id, Object value) {
		clientDAO.update(fild,id,value);
	}

}
