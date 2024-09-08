package respository.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {


    public static Connection connect(){
        String hostName = "localhost:3306";
        String dbName = "permisson";
        String username = "root";
        String password = "";

       String connectionURL = "jdbc:mysql://"+hostName+"/"+dbName;
        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
