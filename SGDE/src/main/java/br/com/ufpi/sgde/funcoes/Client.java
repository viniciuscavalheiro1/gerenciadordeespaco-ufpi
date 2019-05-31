package br.com.ufpi.sgde.funcoes;

import static br.com.ufpi.sgde.interfaces.Login.recebe;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    public static String enviarServidor(String dados) throws IOException, ClassNotFoundException {
        
        Socket cliente = new Socket("localhost", 55555);
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        saida.println(dados);
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        String envia = (String)entrada.readObject();
        System.out.println(recebe);
        return envia;
        
    }
    
    //public static 

}
