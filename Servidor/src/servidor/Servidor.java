package servidor;

import servidor.BDGerente.BDGerente;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.Scanner;
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
    @Override
    public void run() {
        try {
            while (true) {
                // aceitando a conexão com o cliente e inicializando a outra thread
                new TrataCliente(ss.accept()).start();
                System.out.println("Mais um cliente atendido!");
                
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao inicializar o cliente");
        }
    }
    
    public static void main(String[] args) {
        try {

            Servidor servidor = new Servidor(55555);
        } catch (Exception e) {
            
            System.exit(1);
        }
    }
}
class TrataCliente extends Thread {
    private final Socket client;
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
	 Scanner s = new Scanner(client.getInputStream());
            
		 ObjectOutputStream saida = new ObjectOutputStream(client.getOutputStream());
		saida.flush();
               String recebe = null;
                try{
	recebe = s.nextLine();
                    }catch(Exception erro){
                            System.err.println("Cliente: "+client.getInetAddress()+ " Encerreada!");
                            client.close();
                       
                            
                       }
              
        	String[] compara = recebe.split(",");
                               /*
                Tabela de numero no primeiro parametro do servidor
                1 - Cadastra Coodenados
                2 - Cadastra Pessoa
                3 - verificar arquivo no banco
                4 - cadastraespaco
                    posicao 2 do vetor cadastra sala
                5- Retorna todos as salas de um determinado curso
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
                }else if(compara[0].equals("5")){
                    if (compara[2].equals("Sala")){
                  saida.writeObject(BDSalas.retornatodos(compara[1])); 
                    }else if (compara[2].equals("Laboratorio")){
                        saida.writeObject(BDLaboratorio.retornatodos(compara[1]));
                        
                    }else if (compara[2].equals("Auditorio")){
                        
                        saida.writeObject(BDAuditorio.retornatodos(compara[1]));
                    }
                //Verifica se é reserva de espaço
           }else if(compara[0].equals("6")){
               //Verifica
             
                   
                 saida.writeObject(BDAuditorio.reservarauditorio(compara[2], compara[3], compara[4],compara[5],compara[6],compara[7]));
               
               
           }
                
                } catch (IOException | SQLException e) {
                    System.out.println("Cliente foi desconectado");
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
        









      



