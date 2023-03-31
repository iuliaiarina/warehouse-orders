package presentation;

import bll.ComandaBLL;
import bll.ProdusBLL;
import dao.ClientDAO;
import dao.ProdusDAO;
import model.Client;
import model.Comanda;
import model.Produs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 * Interfata contine:
 * trei butoane pentru : ADAUGARE, STRGERE si EDITARE de produse
 * trei campuri pentru adaugarea de produse : nume,pret,cantiatate
 * Afisare tabela in JTabel
 * Campurile se pun pe prima linie
 * apoi afisam variabilele fiecarei tuple din tabela in ordinea respectiva:
 */
public class PaginaProdus extends JFrame {

    private JPanel contentPane;
    private JButton addNewProdus;
    private JButton editProdus;
    private JButton deleteProdus;
    private JButton back;
    private JTable table;
    private JTextField nume;
    private JTextField pret;
    private JTextField cantitate;


    public PaginaProdus() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 691, 359);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addNewProdus = new JButton("NEW PRODUCT");
        addNewProdus.setBounds(506, 24, 161, 23);
        contentPane.add(addNewProdus);

        editProdus = new JButton("EDIT PRODUCT");
        editProdus.setBounds(506, 63, 161, 23);
        contentPane.add(editProdus);

        deleteProdus = new JButton("DELETE PRODUCT");
        deleteProdus.setBounds(506, 96, 161, 23);
        contentPane.add(deleteProdus);

        JLabel lblNewLabel = new JLabel("NUME:");
        lblNewLabel.setBounds(500, 149, 65, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PRET:");
        lblNewLabel_1.setBounds(500, 174, 65, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("CANTITATE:");
        lblNewLabel_2.setBounds(497, 199, 80, 14);
        contentPane.add(lblNewLabel_2);


        nume = new JTextField();
        nume.setBounds(571, 146, 96, 20);
        contentPane.add(nume);
        nume.setColumns(10);

        pret = new JTextField();
        pret.setBounds(571, 171, 96, 20);
        contentPane.add(pret);
        pret.setColumns(10);

        cantitate = new JTextField();
        cantitate.setBounds(571, 196, 96, 20);
        contentPane.add(cantitate);
        cantitate.setColumns(10);

        String[] columnNames = {"Nume",
                "pret",
                "cantitate",
                "id"};


        ProdusBLL bb =new ProdusBLL();
        List<Produs> produs= bb.findALL();
        Object[][] data =new Object[produs.size()][4];
        int i=0;
        while(i<produs.size()){
            data[i][0]=produs.get(i).getNume();
            data[i][1]=produs.get(i).getPret();
            data[i][2]=produs.get(i).getCantitate();
            data[i][3]=produs.get(i).getId();
            i++;
        }

        table = new JTable(data, columnNames);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(23, 24, 442, 268);
        contentPane.add(scroll);

        JLabel lblNewLabel_3 = new JLabel("Lista de produse:   ");
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
    public String getPret() {
        return pret.getText();
    }
    public String getCantitate() {
        return cantitate.getText();
    }

    public void addBackListener(ActionListener x) {
        back.addActionListener(x);
    }
    public void addNewProdusListener(ActionListener x) {
        addNewProdus.addActionListener(x);
    }
    public void addEditProdusListener(ActionListener x) {
        editProdus.addActionListener(x);
    }
    public void addDeleteProdusListener(ActionListener x) {
        deleteProdus.addActionListener(x);
    }


}
