package thuchanh1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "demo_jdbc";
    private String username = "root";
    private String password = "password";

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection ConnectJDBC() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("ket noi thanh cong.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
