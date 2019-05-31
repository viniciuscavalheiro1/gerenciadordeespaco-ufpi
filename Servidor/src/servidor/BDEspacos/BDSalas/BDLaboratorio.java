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
public class BDLaboratorio {
      public static String addlaboratorio(String numero,String capacidade, String bloco, String observacoes){
       int id=0;

       ConexaoLaboratorio conec = new ConexaoLaboratorio();
         CriarTabelaLaboratorios criatb = new CriarTabelaLaboratorios();
         criatb.criarTab();
         
         
            ResultSet resulset = null;
                     Statement statement = null;
                     conec.conectar();
                          
                     String query = "SELECT * FROM laboratorio";
                     statement = conec.criarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                       while (resulset.next()){
                           id++;
                       }
                    } catch (Exception e) {
                    }
                     
                  System.out.println("1");
                    
                     String sqlInsert = "INSERT INTO laboratorio ("
                          + "numero,"
                          + "capacidade,"
                          + "observacoes,"
                          + "bloco"
                          + ") VALUES(?,?,?,?)"
                          + ";";

                    
                      PreparedStatement preparedstatment = conec.criarPreparedStatement(sqlInsert);
                      try {
                          
          preparedstatment.setString(1, numero);
          preparedstatment.setString (2,capacidade);
          preparedstatment.setString (3, observacoes);
          preparedstatment.setString (4, bloco);


         
            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
                System.out.println("Laboratório Cadastrado");
                preparedstatment.close();
                conec.desconectar();
                    return "cadastrado";
                }else{
                    System.out.println("Aconteceu algum erro no cadastro de laboratorio");
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
    
    
 public static String verifilaboratorio(String nome) throws SQLException{

        ConexaoSalas conec = new ConexaoSalas();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM laboratorio;";
                 
                  statement = conec.CriarStatement();
                  
                int i=0;
                String valor = null;
       
                  try {
                     
            resultset = statement.executeQuery(sql);

                      
                      while (resultset.next()) {
                      ResultSet s = resultset;
                      
                           if (s.getString("nome").equals(nome)){
                                valor =   s.getString("nome")+","+s.getString("capacidade")+","+s.getString("bloco")+","+s.getString("observacoes");               
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
