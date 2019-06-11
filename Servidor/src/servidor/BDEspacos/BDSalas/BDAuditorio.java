
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
 
 public static String reservarauditorio(String nome,String data, String horaini, String horafim ,String responsavel, String Observacoes){
     boolean reserva = true; 
     ConexaoReserva conec = new ConexaoReserva();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM reservas;";
                 
                  statement = conec.CriarStatement();
                  
                int i=0;
                String valor = null;
       
                  try {
                     
            resultset = statement.executeQuery(sql);

 
                      while (resultset.next()) {
                      
                      
                            if(resultset.getString("nome").equals(nome)){
                                String[] separa =  resultset.getString("data").split("/");
                                int dia =Integer.valueOf(separa[0]), mes = Integer.valueOf(separa[1]), ano = Integer.valueOf(separa[2]);
                                String[] dataaser = data.split("/");
                                int d = Integer.valueOf(dataaser[0]), m = Integer.valueOf(dataaser[1]), a = Integer.valueOf(dataaser[2]);
                                    if (ano ==a ){
                                        if(mes == m){
                                            if(dia == d){
                                               String[] horamarcadainicio = resultset.getString("noraini").split(":");
                                               String[] horamarcadafim = resultset.getString("horafim").split(":");
                                               String[] horaquerendoinicio = horaini.split(":");
                                               String[] horaquerendofim = horafim.split(":");
                                               //gambiarra 
                                                String recebehoramarcadainicio = null;
                                                recebehoramarcadainicio.concat(horamarcadainicio[0]);
                                                recebehoramarcadainicio.concat(horamarcadainicio[1]);
                                                String recebehoraquerendo = null;
                                                recebehoraquerendo.concat(horaquerendoinicio[0]);
                                                recebehoraquerendo.concat(horaquerendoinicio[1]);
                                                String recebehorafimmarcada = null;
                                                recebehorafimmarcada.concat(horamarcadafim[0]);
                                                recebehorafimmarcada.concat(horamarcadafim[1]);
                                                String recebeforaquerendofim = null;
                                                recebeforaquerendofim.concat(horaquerendofim[0]);
                                                recebeforaquerendofim.concat(horaquerendofim[1]);
                                                int horamilmarcadainicio = Integer.valueOf(recebehoramarcadainicio);
                                                int horamilquerendoinicio = Integer.valueOf(recebehoraquerendo);
                                                int horamilmarcadafim = Integer.valueOf(recebehorafimmarcada);
                                                int horamilquerendofim = Integer.valueOf(recebeforaquerendofim);
                                                
                                                    if(horamilmarcadainicio <= horamilquerendoinicio && horamilquerendoinicio <= horamilmarcadafim){
                                                        if(horamilquerendofim <= horamilmarcadainicio && horamilquerendofim <= horamilmarcadafim){
                                                            reserva = false;
                                                        }
                                                    }
                                            }
                   
                                        }
                                    }
                            }
  
 }
                  } catch (Exception e) {
                      System.out.println("Alguem erro "+e);
        }
                  
                  
                  if(reserva == true){
                      
                    String recebe =   BDReservas.addreserva(nome, data, horaini, horafim, responsavel, Observacoes);
                      if(recebe.contains("cadastrado")){
                          return "ok";
                      }else{
                          return "erro";
                      }
                  }else{
                      return "erro";
                      
                      
                      
                      
                  }
                  
 }

 public static String retornatodos(String curso){
     String lista = "";
        ConexaoAuditorio conec = new ConexaoAuditorio();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM auditorio;";
                 
                  statement = conec.CriarStatement();
                  
                int i=0;
                String valor = null;
                            String certo = "";
        
       
                  try {
                     
            resultset = statement.executeQuery(sql);

                      while (resultset.next()) {
                      ResultSet s = resultset;
                         certo = lista.concat(s.getString("nome")+","); 
                              i++;                           
                          
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