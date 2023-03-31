package presentation;

import bll.ClientBLL;
import dao.ClientDAO;
import model.Client;
import start.Reflection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfata contine:
 * trei butoane pentru : ADAUGARE,STRGERE si EDITARE de clienti
 * trei campuri pentru adaugarea de client : nume, prenume, varsta
 * Afisare tabela in JTabel
 * Campurile se pun pe prima linie
 * apoi afisam variabilele fiecarei tuple din tabela in ordinea respectiva:
 **/
public class PaginaClient extends JFrame {

    private JPanel contentPane;
    private JButton addNewClient;
    private JButton editClient;
    private JButton deleteClient;
    private JButton back;
    private JTable table;
    private JTextField nume;
    private JTextField prenume;
    private JTextField varsta;

	public PaginaClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 691, 359);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addNewClient = new JButton("NEW CLIENT");
        addNewClient.setBounds(506, 24, 161, 23);
        contentPane.add(addNewClient);

        editClient = new JButton("EDIT CLIENT");
        editClient.setBounds(506, 63, 161, 23);
        contentPane.add(editClient);

        deleteClient = new JButton("DELETE CLIENT");
        deleteClient.setBounds(506, 96, 161, 23);
        contentPane.add(deleteClient);

        JLabel lblNewLabel = new JLabel("NUME:");
        lblNewLabel.setBounds(500, 149, 65, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PRENUME:");
        lblNewLabel_1.setBounds(500, 174, 65, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("VARSTA:");
        lblNewLabel_2.setBounds(500, 199, 65, 14);
        contentPane.add(lblNewLabel_2);

        nume = new JTextField();
        nume.setBounds(571, 146, 96, 20);
        contentPane.add(nume);
        nume.setColumns(10);

        prenume = new JTextField();
        prenume.setBounds(571, 171, 96, 20);
        contentPane.add(prenume);
        prenume.setColumns(10);

        varsta = new JTextField();
        varsta.setBounds(571, 196, 96, 20);
        contentPane.add(varsta);
        varsta.setColumns(10);


        String[] columnNames = {"Nume",
                "Prenume",
                "varsta",
                "id"};

        ClientBLL cb =new ClientBLL();
        List<Client> client= cb.findALL();
        Object[][] data =new Object[client.size()][4];
        int i=0;
        while(i<client.size()){
            data[i][0]=client.get(i).getNume();
            data[i][1]=client.get(i).getPrenume();
            data[i][2]=client.get(i).getVarsta();
            data[i][3]=client.get(i).getId();
            i++;
        }


        table = new JTable(data, columnNames);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(23, 24, 442, 268);
        contentPane.add(scroll);

        JLabel lblNewLabel_3 = new JLabel("Lista de clienti:   ");
        lblNewLabel_3.setBounds(23, 11, 239, 14);
        contentPane.add(lblNewLabel_3);

        back = new JButton("BACK");
        back.setBounds(533, 264, 89, 23);
        contentPane.add(back);
    }

    public JTable getTable() {
        return table;
    }

    public String getNume() {
        return nume.getText();
    }
    public String getPrenume() {
        return prenume.getText();
    }
    public String getVarsta() {
        return varsta.getText();
    }

    public void addBackListener(ActionListener x) {
        back.addActionListener(x);
    }
    public void addNewClientListener(ActionListener x) {
        addNewClient.addActionListener(x);
    }
    public void addEditClientListener(ActionListener x) {
        editClient.addActionListener(x);
    }
    public void addDeleteClientListener(ActionListener x) {
        deleteClient.addActionListener(x);
    }

}
