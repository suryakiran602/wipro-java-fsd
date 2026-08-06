import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the Oracle JDBC driver
            //Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            // Format: jdbc:oracle:thin:@<host>:<port>:<SID>  (or use service name)
           String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
           String username = "system";
           String password = "2005";
            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Established successfully");

        } catch (Exception e) {
            System.out.println("Connection could not be established");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
