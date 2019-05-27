/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BDProfessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class CriarTabelaProfessor {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author pedro
 */

 
     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:professor.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS professor (\n"
                + "nome text,\n"
                + "cpf text NOT NULL,\n"
                + "matricula text,\n"
                + "tipo text,\n"
                 + "senha  text NOT NULL\n"
                + ")";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }
    
    
}


    

