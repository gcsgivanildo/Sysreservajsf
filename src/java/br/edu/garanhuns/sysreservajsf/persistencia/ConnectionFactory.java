package br.edu.garanhuns.sysreservajsf.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/sysreservajsf", "root", "");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException g) {
            throw new RuntimeException(g);
        }
    }
}
