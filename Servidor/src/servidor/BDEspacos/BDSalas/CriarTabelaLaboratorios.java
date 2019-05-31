/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BDEspacos.BDSalas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class CriarTabelaLaboratorios {
     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:BancodeDados/laboratorio.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS laboratorio (\n"
                + "numero text,\n"
                + "capacidade text NOT NULL,\n"
                + "bloco text\n,"
                + "observacoes\n"
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
