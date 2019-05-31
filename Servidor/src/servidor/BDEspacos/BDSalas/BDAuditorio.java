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

/**
 *
 * @author pedro
 */
public class BDAuditorio {
      public static String addauditorio(String numero,String capacidade, String localizacao, String Observacoes){
       int id=0;

       ConexaoAuditorio conec = new ConexaoAuditorio();
         CriarTabelaAuditorio criatb = new CriarTabelaAuditorio();
         criatb.criarTab();
         
         
            ResultSet resulset = null;
                     Statement statement = null;
                     conec.conectar();
                          
                     String query = "SELECT * FROM auditorios";
                     statement = conec.criarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                       while (resulset.next()){
                           id++;
                       }
                    } catch (Exception e) {
                    }
                     
                  System.out.println("1");
                    
                     String sqlInsert = "INSERT INTO auditorios ("
                          + "nome,"
                          + "capacidade,"
                             + "localizacao,"
                             + "observacoes"
                          + ") VALUES(?,?,?,?)"
                          + ";";
                       System.out.println("1");
                    
                      PreparedStatement preparedstatment = conec.criarPreparedStatement(sqlInsert);
                      try {
                          
          preparedstatment.setString(1, numero);
          preparedstatment.setString (2,capacidade);
          preparedstatment.setString (3, localizacao);
          preparedstatment.setString (4, Observacoes);


         
            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
                System.out.println("Auditorio Cadastrado");
                preparedstatment.close();
                conec.desconectar();
                    return "cadastrado";
                }else{
                    System.err.println("Aconteceu algum erro no cadastro de auditorio");
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
    
    
 public static String verifiauditorio(String nome) throws SQLException{

        ConexaoAuditorio conec = new ConexaoAuditorio();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM auditorios;";
                 
                  statement = conec.CriarStatement();
                  
                int i=0;
                String valor = null;
       
                  try {
                     
            resultset = statement.executeQuery(sql);

 
                      while (resultset.next()) {
                      ResultSet s = resultset;
                       
                           if (s.getString("nome").equals(nome)){
                                valor =   s.getString("nome")+","+s.getString("capacidade")+","+s.getString("localizacao")+","+s.getString("observacoes");               
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
    
}
