package br.com.ufpi.sgde.funcoes;

import static br.com.ufpi.sgde.interfaces.Login.recebe;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {
    static String Dados;
    static String envia;
    public static String enviarServidor(String dados) throws IOException, ClassNotFoundException {
        Dados = dados;
        
                Socket cliente = null;
        try {
            cliente = new Socket("localhost", 55555);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = null;
        try {
            saida = new PrintStream(cliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        saida.println(Dados);
        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             envia = (String)entrada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(recebe);
       
        return envia;
    }
    }

