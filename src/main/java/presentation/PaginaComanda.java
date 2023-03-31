package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProdusBLL;
import dao.ClientDAO;
import dao.ComandaDAO;
import dao.ProdusDAO;
import model.Client;
import model.Comanda;
import model.Produs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * PaginaComanda contine trei tabele : clienti, produse si comenzi
 * Utilizatorul poate crea o comanda prin selectarea unui client, a unui produs
 * si introducerea unei cantitati valide.
 * Dupa apasarea butonului Comanda, comanda creata v-a aparea in tabela respectiva.
 */
public class PaginaComanda extends JFrame {

    private JPanel contentPane;
    private JTextField cantitate;
    JTable table1;
    JTable table2;
    JTable table3;
    JButton back;
    JButton addComanda;

    public PaginaComanda() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 622, 524);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] columnNames1 = {"Nume",
                "Prenume",
                "varsta",
                "id"};
        ClientBLL cb =new ClientBLL();
        List<Client> client= cb.findALL();
        Object[][] data1 =new Object[client.size()][4];
        int i=0;
        while(i<client.size()){
            data1[i][0]=client.get(i).getNume();
            data1[i][1]=client.get(i).getPrenume();
            data1[i][2]=client.get(i).getVarsta();
            data1[i][3]=client.get(i).getId();
            i++;
        }

        table1 = new JTable(data1, columnNames1);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        scrollPane1.setBounds(10, 11, 194, 335);
        contentPane.add(scrollPane1);


        String[] columnNames2 = {"Nume",
                "pret",
                "cantitate",
                "id"};

        ProdusBLL bb =new ProdusBLL();
        List<Produs> produs= bb.findALL();
        Object[][] data2 =new Object[produs.size()][4];
        i=0;
        while(i<produs.size()){
            data2[i][0]=produs.get(i).getNume();
            data2[i][1]=produs.get(i).getPret();
            data2[i][2]=produs.get(i).getCantitate();
            data2[i][3]=produs.get(i).getId();
            i++;
        }

        table2 = new JTable(data2, columnNames2);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(212, 11, 194, 335);
        contentPane.add(scrollPane2);

        String[] columnNames3 = {"ID",
                "ClientID",
                "ProdusID",
                "Cantitate"};

        ComandaBLL cm =new ComandaBLL();
        List<Comanda> comanda=cm.findALL();
        Object[][] data3 =new Object[comanda.size()][4];
        i=0;
        while(i<comanda.size()){
            data3[i][0]=comanda.get(i).getId();
            data3[i][1]=comanda.get(i).getClientid();
            data3[i][2]=comanda.get(i).getProdusid();
            data3[i][3]=comanda.get(i).getCantitate();
            i++;
        }

        table3 = new JTable(data3, columnNames3);
        JScrollPane scrollPane3 = new JScrollPane(table3);
        scrollPane3.setBounds(414, 11, 194, 335);
        contentPane.add(scrollPane3);

        back = new JButton("BACK");
        back.setBounds(10, 437, 89, 23);
        contentPane.add(back);

        JLabel lblNewLabel = new JLabel("Cantitate:   ");
        lblNewLabel.setBounds(181, 441, 123, 14);
        contentPane.add(lblNewLabel);

        cantitate = new JTextField();
        cantitate.setBounds(263, 438, 96, 20);
        contentPane.add(cantitate);
        cantitate.setColumns(10);

        addComanda = new JButton("COMANDA");
        addComanda.setBounds(399, 437, 100, 23);
        contentPane.add(addComanda);
    }

    public JTable getTable1() {
        return table1;
    }
    public JTable getTable2() {
        return table2;
    }

    public String getCantitate() {
        return cantitate.getText();
    }

    public void addBackComandaListener(ActionListener x) {
        back.addActionListener(x);
    }
    public void addNewComandaListener(ActionListener x) {
        addComanda.addActionListener(x);
    }

}
