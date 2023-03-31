
import jdk.swing.interop.SwingInterOpUtils;
import model.Client;
import bll.ClientBLL;
import presentation.Controller;
import presentation.PaginaStart;
import start.Start;

import java.sql.SQLOutput;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) {
       PaginaStart ps= new PaginaStart();
       Controller c=new Controller(ps);
    }

}
