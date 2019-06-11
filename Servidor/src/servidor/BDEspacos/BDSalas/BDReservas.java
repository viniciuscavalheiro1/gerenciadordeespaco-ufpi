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
public class BDReservas {
          public static String addreserva(String nome,String data, String horaini, String horafim ,String responsavel, String Observacoes){
       int id=0;

       ConexaoReserva conec = new ConexaoReserva();
         CriarTabelaReservas criatb = new CriarTabelaReservas();
         criatb.criarTab();
         
         
            ResultSet resulset = null;
                     Statement statement = null;
                     conec.conectar();
                          
                     String query = "SELECT * FROM reservas";
                     statement = conec.criarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                       while (resulset.next()){
                           id++;
                       }
                    } catch (Exception e) {
                    }
                     
                  System.out.println("1");
                    
                     String sqlInsert = "INSERT INTO reservas ("
                          + "nome,"
                          + "data,"
                             + "horaini,"
                             + "horafim,"
                             + "responsavel,"
                             + "observacoes"
                          + ") VALUES(?,?,?,?,?,?)"
                          + ";";
                       System.out.println("1");
                    
                      PreparedStatement preparedstatment = conec.criarPreparedStatement(sqlInsert);
                      try {
                          
          preparedstatment.setString(1, nome);
          preparedstatment.setString (2,data);
          preparedstatment.setString (3, horaini);
          preparedstatment.setString (4, horafim);
           preparedstatment.setString (5, responsavel);
          preparedstatment.setString (6, Observacoes);
          

         
            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
                System.out.println("Reverva do auditorio "+nome+" Feita para a data "+data+" das "+horaini+"ás"+horafim);
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
    
public static void reserva (String nome,String data, String horaini, String horafim ,String responsavel, String Observacoes){
    
    
    
    
    
    
    
}



}
