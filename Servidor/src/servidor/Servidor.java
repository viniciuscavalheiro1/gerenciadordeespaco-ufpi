/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;




import servidor.BDGerente.BDGerente;
import java.io.IOException;
//import java.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;
import servidor.BDEspacos.BDSalas.BDAuditorio;
import servidor.BDEspacos.BDSalas.BDLaboratorio;
import servidor.BDEspacos.BDSalas.BDSalas;

import servidor.BDProfessor.BDProfessor;

public class Servidor implements Runnable {
    
    ServerSocket ss;
    public Servidor(int porta) throws Exception {
        // informando em qual porta o servidor estará ouvindo
        ss = new ServerSocket(porta);
        // criando uma nova thread e já estou inicializando ela
        new Thread(this).start();
        // mensagem iniicial
        System.out.println("Servidor ouvindo na porta:" + porta);
    }
    public void run() {
        try {
            while (true) {
                // aceitando a conexão com o cliente e inicializando a outra thread
                new TrataCliente(ss.accept()).start();
                System.out.println("Mais um cliente atendido!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        try {

            new Servidor(55555);
        } catch (Exception e) {
            
            e.printStackTrace();
            System.exit(1);
        }
    }
}
class TrataCliente extends Thread {
    private Socket client;
    public TrataCliente(Socket s) {
        client = s;
    }

    @Override
    public void run() {
        
        do{
                try {
            
      
            // aqui vai a sua comunicacao com o cliente
           // ObjectInputStream oi = new ObjectInputStream(client.getInputStream());
          //  Socket cliente = servidor.accept();     
	 System.out.println("Nova conexão com o cliente "
            + client.getInetAddress().getHostAddress());
   
	 System.out.println("Nova conexão com o cliente "
            + client.getInetAddress().getHostAddress());
	 Scanner s = new Scanner(client.getInputStream());
   
		 ObjectOutputStream saida = new ObjectOutputStream(client.getOutputStream());
		saida.flush();
	String recebe = s.nextLine();
        	String[] compara = recebe.split(",");
                               /*
                Tabela de numero no primeiro parametro do servidor
                1 - Cadastra Coodenados
                2 - Cadastra Pessoa
                3 - verificar arquivo no banco
                4 - cadastraespaco
                    posicao 2 do vetor cadastra sala
                10 - Cadastra Sala
                
                */
		if(compara[0].equals("1")){
                        
                    if(compara[1].equals("Coordenador")){
                        saida.writeObject(BDGerente.addGerente(compara[1],compara[2],compara[3],compara[4],compara[5]));
                     }else if(compara[1].equals("Professor")){
                          saida.writeObject(BDProfessor.addProfessor(compara[1],compara[2],compara[3],compara[4],compara[5]));
                     }
		}else if(compara[0].equals("2")){
                    if(compara[1].equals("Coordenador")){
                        saida.writeObject(BDGerente.loginGerente(compara[2], compara[3]));
                    }else if(compara[1].equals("Professor")){
                          saida.writeObject(BDProfessor.loginProfessor(compara[2], compara[3]));
                    }  
                    
                }else if (compara[0].equals("3")){
                    //verificar o banco de dados
                    if(compara[1].equals("Sala")){
                        saida.writeObject(BDSalas.verificasala(compara[2]));
                    } else if(compara[1].equals("Laboratorio")){
                        saida.writeObject(BDLaboratorio.verifilaboratorio(compara[2]));
                    } else if(compara[1].equals("Auditorio")){
                        saida.writeObject(BDAuditorio.verifiauditorio(compara[2]));
                    }
                    
                }
                else if(compara[0].equals("4")){
                     if(compara[1].equals("Sala")){
                    
                     saida.writeObject(BDSalas.addSalas(compara[2], compara[3], compara[4]));
                     }else if(compara[1].equals("Laboratorio")){
                        saida.writeObject(BDLaboratorio.addlaboratorio(compara[2],compara[3],compara[4],compara[5]));
                    } else if(compara[1].equals("Auditorio")){
                        saida.writeObject(BDAuditorio.addauditorio(compara[2],compara[3],compara[4],compara[5]));
                    }
                }

               
		
                } catch (Exception e) {
                     e.printStackTrace();
                     System.exit(1);
                }
           
 		}while(true);

    }
        

    }

              /*
        do{
        }
        try {
            
      
            // aqui vai a sua comunicacao com o cliente
           // ObjectInputStream oi = new ObjectInputStream(client.getInputStream());
          //  Socket cliente = servidor.accept();     
	 System.out.println("Nova conexão com o cliente "
            + client.getInetAddress().getHostAddress());
   
	 System.out.println("Nova conexão com o cliente "
            + client.getInetAddress().getHostAddress());
	 Scanner s = new Scanner(client.getInputStream());
   
		 ObjectOutputStream saida = new ObjectOutputStream(client.getOutputStream());
		saida.flush();
	String recebe = s.nextLine();
        	String[] compara = recebe.split(",");
		if(compara[0].equals("1")){
                     //Abrir BD
                     //
  			
        	//Fim -->saida.writeObject(addcliente(compara[1]+","+contaarquivos()+1+","+compara[3]+","+compara[4]+","+compara[5]+","+compara[6]));
                
		}
		
                } catch (Exception e) {
                     e.printStackTrace();
                     System.exit(1);
                }
           
 		}while(true);

    }
              }
*/
        









      



