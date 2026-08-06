import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryEmp {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String username = "system";
            String password = "2005";

            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT EMPNO, ENAME FROM EMP");

            System.out.println("EMPNO\tENAME");
            while (rs.next()) {
                int empno = rs.getInt(1);             // by column index
                String ename = rs.getString("ENAME"); // by column name
                System.out.println(empno + "\t" + ename);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}