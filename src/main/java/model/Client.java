package model;

/**
 * Clientul contine 4 campuri : id, nume,prenume, varsta
 */
public class Client {
	private int id;
	private String nume;
	private String prenume;
	private int varsta;

	public Client() {
	}

	public Client(String nume, String prenume, int varsta) {
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
	}

	public Client(int id, String nume, String prenume, int varsta) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", Nume=" + nume + ", Prenume=" + prenume + ", varsta=" + varsta + "]";
	}
}
