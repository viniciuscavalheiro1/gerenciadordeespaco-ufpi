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
public class CriarTabelaReservas {
            public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:BancodeDados/reservas.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS reservas (\n"
                + "numero text,\n"
                + "data text NOT NULL,\n"
                + "horaini text NOT NULL,\n"
                + "horafim text NOT NULL,\n"
                + "responsavel text NOT NULL,\n"
                + "observacoes text\n"
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
