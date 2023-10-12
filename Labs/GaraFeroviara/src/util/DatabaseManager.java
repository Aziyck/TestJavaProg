package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static String url = "jdbc:postgresql://localhost:5432/GaraFeroviara";
    private static String user = "postgres";
    private static String password = "admin";

    private DatabaseManager(){}

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,password);

        return connection;
    }
//    private static Connection connection;
//    static {
//        try {
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Temp","postgres","admin");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static Connection getConnection() {
//        return connection;
}

