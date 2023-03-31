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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ActionListener pentru fiecare buton din pagina Client
 *      * newClient alege valorile inserate de utilixzator si adauga clientu
 *      * creat in tabela
 *      *
 *      * DeleteClient sterge clientul selectat de utilizator
 *      * (acetsa trebuie sa selecteze linia respectiva// nu conteaza coloana)
 *      *
 *      * EditClient editeaza campul selectat de utilizator
 *      * Acetsa trebuie sa selecteze campul respectiv si sa insereze un numar
 *      * in textFildul respectiv
 *
 *      ActionListener pentru fiecare buton din pagina Produs
 *      * newCProdus alege valorile inserate de utilizator si adauga Produsul
 *      * creat in tabela
 *      *
 *      * DeleteProdus sterge Produsul selectat de utilizator
 *      * (acetsa trebuie sa selecteze linia respectiva// nu conteaza coloana)
 *      *
 *      * EditProdus editeaza campul selectat de utilizator
 *      * Acesta trebuie sa selecteze campul respectiv si sa insereze un numar
 *      * in textFildul respectiv
 */
public class Controller {
    private PaginaClient paginaClient;
    private PaginaComanda paginaComanda;
    private PaginaProdus paginaProdus;
    private PaginaStart paginaStart;
    private File file;

    public Controller(PaginaStart paginaStart) {
        this.paginaStart = paginaStart;
        this.paginaStart.setVisible(true);
        paginaStart.addGoClientListener(new GoClientListener());
        paginaStart.addGoComandaListener(new GoComandaListener());
        paginaStart.addGoProdusListener(new GoProdusListener());
    }

    class GoComandaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            paginaStart.dispose();
            newPaginaComanda();
        }
    }
    class GoClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            paginaStart.dispose();
            newPaginaClient();
        }
    }
    class GoProdusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            paginaStart.dispose();
            newPaginaProdus();
        }
    }


    /**
     * newClient alege valorile inserate de utilixzator si adauga clientu
     * creat in tabela
     */
    class NewClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = paginaClient.getNume();
            String prenume =paginaClient.getPrenume();
            String aux =paginaClient.getVarsta();
            int varsta = 0;
            try{
                if(nume.length()==0 || prenume.length()==0 || aux.length()==0)
                    throw new IOException();
                varsta = Integer.parseInt(aux);
                if(varsta<=0) throw new ArithmeticException();
                Client client=new Client(0,nume,prenume,varsta);
                ClientBLL cb= new ClientBLL();
                cb.insert(client);
                paginaClient.dispose();
                newPaginaClient();
            }
            catch (IOException e1){
                String message = "\"DATE INCORECTE\"\n"
                        + "Toate campurile trebuie completate\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (ArithmeticException e1){
                String message = "\"DATE INCORECTE\"\n"
                        + "Varsta nu poate fi negativa\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e1){
                String message = "\"DATE INCORECTE\"\n"
                        + "Varsta trebuie sa fie un numar\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class BackListenerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            paginaClient.dispose();
            paginaStart=new PaginaStart();
            paginaStart.setVisible(true);
            paginaStart.addGoClientListener(new GoClientListener());
            paginaStart.addGoComandaListener(new GoComandaListener());
            paginaStart.addGoProdusListener(new GoProdusListener());
        }
    }

    /**
     * EditClient editeaza campul selectat de utilizator
     * Acesta trebuie sa selecteze campul respectiv si sa insereze un numar
     *  in textFildul respectiv
     */
    class EditClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row;
            int column = 0;
            int id = 0;
            try {
                JTable table = paginaClient.getTable();
                row = table.getSelectedRow();
                column = table.getSelectedColumn();
                id = (int) table.getValueAt(row, 3);
                try {
                    if (column == 0) {  //nume
                        String nume = paginaClient.getNume();
                        if(nume.length()==0)
                            throw new Exception();
                        ClientDAO.updateNume(nume,id);
                    }
                    if (column == 1) {  //prenume
                        String prenume = paginaClient.getPrenume();
                        if(prenume.length()==0)
                            throw new Exception();
                        ClientDAO.updatePrenume(prenume,id);
                    }
                    if (column == 2) {  //varsta
                        String aux = paginaClient.getVarsta();
                        if(aux.length()==0)
                            throw new Exception();
                        int varsta =Integer.parseInt(aux);
                        if(varsta<=0)
                            throw new Exception();
                        ClientDAO.updateVarsta(varsta,id);
                    }
                    paginaClient.dispose();
                    newPaginaClient();
                }
                catch(Exception e2){
                    String message = "\"DATE INCORECTE\"\n";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e2){
                String message = "\"SELECTATI CAMPUL DORIT DIN TABELA\"\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     *  DeleteClient sterge clientul selectat de utilizator
     *  (acetsa trebuie sa selecteze linia respectiva// nu conteaza coloana)
     */
    class DeleteClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                JTable table = paginaClient.getTable();
                int row;
                row = table.getSelectedRow();
                int value=(int)table.getValueAt(row, 3);
                ClientBLL cb= new ClientBLL();
                cb.deleteById( value);
                paginaClient.dispose();
                newPaginaClient();
            } catch (Exception e2) {
                String message = "\"SELECTATI CAMPUL DORIT DIN TABELA\"\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * newProdus alege valorile inserate de utilizator si adauga Produsul
     * creat in tabela
     */
    class NewProdusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = paginaProdus.getNume();
            String aux =paginaProdus.getPret();
            String aux2 =paginaProdus.getCantitate();
            double pret = 0;
            int cantitate = 0;
            try{
                if(nume.length()==0 || aux2.length()==0 || aux.length()==0)
                    throw new IOException();
                pret = Double.parseDouble(aux);
                cantitate = Integer.parseInt(aux2);
                if(pret<=0 || cantitate <= 0) throw new Exception();
                Produs produs=new Produs(nume,pret,cantitate,0);
                ProdusBLL pb =new ProdusBLL();
                pb.insert(produs);
                paginaProdus.dispose();
                newPaginaProdus();
            }
            catch (Exception e1){
                String message = "\"DATE INCORECTE\"\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            paginaProdus.dispose();
            paginaStart=new PaginaStart();
            paginaStart.setVisible(true);
            paginaStart.addGoClientListener(new GoClientListener());
            paginaStart.addGoComandaListener(new GoComandaListener());
            paginaStart.addGoProdusListener(new GoProdusListener());
        }
    }

    /**
     * EditProdus editeaza campul selectat de utilizator
     * Acesta trebuie sa selecteze campul respectiv si sa insereze un numar
     * in textFildul respectiv
     */
    class EditProdusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row;
            int column = 0;
            int id = 0;
            try {
                JTable table = paginaProdus.getTable();
                row = table.getSelectedRow();
                column = table.getSelectedColumn();
                id = (int) table.getValueAt(row, 3);
                try {
                    if (column == 0) {  //nume
                        String nume = paginaProdus.getNume();
                        if(nume.length()==0)
                            throw new Exception();
                        ProdusDAO.updateNume(nume,id);
                    }
                    if (column == 1) {  //pret
                        String aux = paginaProdus.getPret();
                        if(aux.length()==0)
                            throw new Exception();
                        Double pret =Double.parseDouble(aux);
                        if(pret<=0)
                            throw new Exception();
                        ProdusDAO.updatePret(pret,id);
                    }
                    if (column == 2) {  //cantiate
                        String aux = paginaProdus.getCantitate();
                        if(aux.length()==0)
                            throw new Exception();
                        int cantitate =Integer.parseInt(aux);
                        if(cantitate<=0)
                            throw new Exception();
                        ProdusDAO.updateCantitate(cantitate,id);
                    }
                    paginaProdus.dispose();
                    newPaginaProdus();
                }
                catch(Exception e2){
                    String message = "\"DATE INCORECTE\"\n";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e2){
                String message = "\"SELECTATI CAMPUL DORIT DIN TABELA\"\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * DeleteProdus sterge Produsul selectat de utilizator
     * (acetsa trebuie sa selecteze linia respectiva// nu conteaza coloana)
     */
    class DeleteProdusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                JTable table = paginaProdus.getTable();
                int row;
                row = table.getSelectedRow();
                ProdusBLL pb =new ProdusBLL();
                pb.deleteById((int) table.getValueAt(row, 3));
                paginaProdus.dispose();
                newPaginaProdus();
            } catch (Exception e2) {
                String message = "\"SELECTATI CAMPUL DORIT DIN TABELA\"\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * ActionListener pentru iesirea din pagina
     **/
    class BackComandaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            paginaComanda.dispose();
            paginaStart=new PaginaStart();
            paginaStart.setVisible(true);
            paginaStart.addGoClientListener(new GoClientListener());
            paginaStart.addGoComandaListener(new GoComandaListener());
            paginaStart.addGoProdusListener(new GoProdusListener());
        }
    }

    /**
     * ACtionListener pentru creare de comanda:
     */
    class NewComandaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row1;
            int row2;
            try{
                JTable table1 = paginaComanda.getTable1();
                JTable table2 = paginaComanda.getTable2();
                String aux=paginaComanda.getCantitate();
                row1 = table1.getSelectedRow();
                row2 = table2.getSelectedRow();

                int Cid = (int) table1.getValueAt(row1, 3);
                int Pid = (int) table2.getValueAt(row2, 3);
                int cantitate= (int)table2.getValueAt(row2,2);

                try {
                    int getCant = Integer.parseInt(aux);
                    if(getCant<=0)throw new Exception();
                    if (getCant>cantitate) throw new Exception();
                    int newCant = cantitate-getCant;
                    ProdusDAO.updateCantitate(newCant,Pid);
                    Comanda comanda =new Comanda(Cid,Pid,getCant);
                    ComandaBLL cb =new ComandaBLL();
                    cb.insert(comanda);
                    String titlu ="comanda_"+Cid+"_"+Pid+"_"+getCant+".txt";
                    file = new File(titlu);
                    String nume = (String) table1.getValueAt(row1, 0);
                    String prenume = (String) table1.getValueAt(row1, 1);
                    String prod= (String) table2.getValueAt(row2, 0);
                    double value = getCant*(double) table2.getValueAt(row2,1);
                    String text="Clientul "+ nume +" "+prenume+" a comandat "+getCant+" "+prod+" la pretul de "+value+".";
                    System.out.println(text);
                    writeFile(text);
                    paginaComanda.dispose();
                    newPaginaComanda();
                }catch (Exception e2){
                    String message = "\"CANTIATE GRESITA\"\n";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }

            }catch (Exception e2){
                String message = "\"SELECTATI CAMPUL DORIT DIN TABELE\"\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public void newPaginaClient(){
        this.paginaClient =new PaginaClient();
        this.paginaClient.setVisible(true);
        this.paginaClient.addBackListener(new BackListenerListener());
        this.paginaClient.addNewClientListener(new NewClientListener());
        this.paginaClient.addEditClientListener(new EditClientListener());
        this.paginaClient.addDeleteClientListener(new DeleteClientListener());
    }

    public void newPaginaProdus(){
        paginaProdus =new PaginaProdus();
        paginaProdus.setVisible(true);
        paginaProdus.addBackListener(new BackListener());
        paginaProdus.addNewProdusListener(new NewProdusListener());
        paginaProdus.addEditProdusListener(new EditProdusListener());
        paginaProdus.addDeleteProdusListener(new DeleteProdusListener());
    }

    public void newPaginaComanda(){
        paginaComanda=new PaginaComanda();
        paginaComanda.setVisible(true);
        paginaComanda.addBackComandaListener(new BackComandaListener());
        paginaComanda.addNewComandaListener(new NewComandaListener());
    }


    public void writeFile(String text){
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
