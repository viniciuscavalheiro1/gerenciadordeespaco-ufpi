/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BDGerente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class BDGerente {
    
        public static String addGerente(String tipo,String nome, String CPF, String matricula, String senha ){
       int id=0;

       ConexaoGerente conec = new ConexaoGerente();
         CriarTabelaGerente criatb = new CriarTabelaGerente();
         criatb.criarTab();
         
         
            ResultSet resulset = null;
                     Statement statement = null;
                     conec.conectar();
                          
                     String query = "SELECT * FROM gerente";
                     statement = conec.criarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                       while (resulset.next()){
                           id++;
                       }
                    } catch (Exception e) {
                    }
                     
                  System.out.println("1");
                    
                     String sqlInsert = "INSERT INTO gerente ("
                          + "nome,"
                          + "cpf,"
                             + "matricula,"
                             + "senha,"
                             + "tipo"
                          + ") VALUES(?,?,?,?,?)"
                          + ";";
                       System.out.println("1");
                    
                      PreparedStatement preparedstatment = conec.criarPreparedStatement(sqlInsert);
                      try {
                          
          preparedstatment.setString(1, nome);
          preparedstatment.setString (2,CPF);
          preparedstatment.setString (3, matricula);
          preparedstatment.setString (4,senha);
          preparedstatment.setString (5,tipo);
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
                System.out.println("Gerente Cadastrado");
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
 
public static String loginGerente(String CPF, String senha) throws SQLException{
          int a=1;
      
      
        ConexaoGerente conec = new ConexaoGerente();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM gerente;";
                 
                  statement = conec.CriarStatement();
                  
                
       
                  try {
                      int i=1;
            resultset = statement.executeQuery(sql);

            
                      while (resultset.next()) {
                      ResultSet s = resultset;
                          
                         
                          if (resultset.getString("cpf").equals(CPF)){
                              System.out.println("Encontrado");
                              System.out.println(resultset.getString("senha"));
                          
                                if(senha.equals(resultset.getString("senha"))){                                   
                                    return resultset.getString("nome")+","+resultset.getString("cpf")+","+resultset.getString("matricula")+","+resultset.getString("senha")+","+resultset.getString("tipo");
                                   }   
                                    
                                }
                          }
                      
        } catch (Exception e) {
                      System.out.println("Alguem erro "+e);
        }
    
        return "null";
          }    
            
            
            
        

}

