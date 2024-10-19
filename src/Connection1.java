import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.Connection;
public class Connection1 {

        private static final String URL = "jdbc:mysql://127.0.0.1:3306/register";
        private static final String USER = "root";
        private static final String PASSWORD = "2022988";

        public static Connection getConnection() throws SQLException {
            return  DriverManager.getConnection(URL, USER, PASSWORD);
        }

}
