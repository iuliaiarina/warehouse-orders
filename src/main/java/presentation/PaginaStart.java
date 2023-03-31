package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * PaginaStart este prima pagina a aplicatiei
 * In ea exista trei butoane: CLIENTI, PRODUSE, COMENZI
 * Fiecare dintre acestea duc la paginile respective:
 * PaginaClient, PaginaProdus, PaginaComenzi
 */
public class PaginaStart extends JFrame {

    private JPanel contentPane;
    private JButton goComanda;
    private JButton goClient;
    private JButton goProdus;

    public PaginaStart() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 240, 142);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        goComanda = new JButton("Comenzi");
        contentPane.add(goComanda);

        goClient = new JButton("Clienti");
        contentPane.add(goClient);

        goProdus = new JButton("produse");
        contentPane.add(goProdus);
    }


    public void addGoComandaListener(ActionListener x) {
        goComanda.addActionListener(x);
    }
    public void addGoClientListener(ActionListener x) {
        goClient.addActionListener(x);
    }
    public void addGoProdusListener(ActionListener x) {
        goProdus.addActionListener(x);
    }

}