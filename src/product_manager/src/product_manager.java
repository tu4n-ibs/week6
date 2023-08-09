package product_manager.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class product_manager {
    private String hostName = "localhost:3306";
    private String dbName = "product_manager_database";
    private String username = "root";
    private String password = "password";

    private String connectionURL = "jdbc:mysql://"+hostName+"/"+dbName;

    public Connection connect(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
