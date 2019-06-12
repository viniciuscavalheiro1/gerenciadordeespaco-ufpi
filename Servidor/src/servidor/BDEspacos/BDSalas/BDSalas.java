/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BDEspacos.BDSalas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import servidor.BDProfessor.ConexaoProfessor;


/**
 *
 * @author pedro
 */
public class BDSalas {
     public static String addSalas(String numero,String capacidade, String bloco){
       int id=0;

       ConexaoSalas conec = new ConexaoSalas();
         CriarTabelaSalas criatb = new CriarTabelaSalas();
         criatb.criarTab();
         
         
            ResultSet resulset = null;
                     Statement statement = null;
                     conec.conectar();
                          
                     String query = "SELECT * FROM salas";
                     statement = conec.criarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                       while (resulset.next()){
                           id++;
                       }
                    } catch (Exception e) {
                    }
                     
                  System.out.println("1");
                    
                     String sqlInsert = "INSERT INTO salas ("
                          + "numero,"
                          + "capacidade,"
                             + "bloco"
                          + ") VALUES(?,?,?)"
                          + ";";
                       System.out.println("1");
                    
                      PreparedStatement preparedstatment = conec.criarPreparedStatement(sqlInsert);
                      try {
                          
          preparedstatment.setString(1, numero);
          preparedstatment.setString (2,capacidade);
          preparedstatment.setString (3, bloco);


         
            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
                System.out.println("Sala Cadastrada");
                preparedstatment.close();
                conec.desconectar();
                    return "cadastrado";
                }else{
                    System.out.println("Aconteceu algum erro");
                    return "erro";
                        }
        } catch (SQLException e) {
                    System.out.println(e);
        }finally{
                    
                    if (preparedstatment != null){
                        try {
                            
                            preparedstatment.close();
                            
                        } catch (SQLException ex) {

                        }
                    }
   
                    
       
                }    
            return "erro";
        }
    
    
 public static String verificasala(String numero) throws SQLException{

        ConexaoSalas conec = new ConexaoSalas();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM salas;";
                 
                  statement = conec.CriarStatement();
                  
                int i=0;
                String valor = null;
       
                  try {
                     
            resultset = statement.executeQuery(sql);

                      System.out.println(numero);
                      while (resultset.next()) {
                      ResultSet s = resultset;
                          System.out.println(s.getString("numero")+","+s.getString("capacidade")+","+s.getString("bloco"));
                           if (s.getString("numero").equals(numero)){
                                valor =   s.getString("numero")+","+s.getString("capacidade")+","+s.getString("bloco");               
                               i++;
                            
                           }
                          
                          }
                      
        } catch (Exception e) {
                      System.out.println("Alguem erro "+e);
        }
                  if(i>0){
                      conec.desconectar();
             return valor;
                  }else{
                
             return "null";
                  }
          }       
  
 public static String retornatodos(String curso){
     String lista = "";
        ConexaoSalas conec = new ConexaoSalas();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM salas;";
                 
                  statement = conec.CriarStatement();
                  
                int i=0;
                String valor = null;
                            String certo = "";
        
       
                  try {
                     
            resultset = statement.executeQuery(sql);

                      while (resultset.next()) {
                      ResultSet s = resultset;
                        
                           if (s.getString("bloco").equals(curso)){
                               System.out.println(s.getString("bloco"));
                         certo = lista.concat(s.getString("numero")+","); 
                              i++;
                           }
                          
                          }
                      
        } catch (Exception e) {
                      System.out.println("Alguem erro "+e);
        }
                  if(i>0){
                      conec.desconectar();
             return certo;
                  }else{
                
             return "null";
                  }
          }  
     
     
     
     
 }

