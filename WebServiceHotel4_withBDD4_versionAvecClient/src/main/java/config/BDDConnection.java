package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConnection {
    //private static final String URL = "jdbc:mysql://localhost:3306/archi_log";
    private static final String URL = "jdbc:mysql://localhost:8889/archi_log";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}