import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryEmpSalary {
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

            rs = stmt.executeQuery(
                "SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE SAL > 1000 AND SAL < 2000"
            );

            System.out.println("ENAME\tJOB\t\tSAL\tCOMM");
            while (rs.next()) {
                String ename = rs.getString("ENAME");
                String job = rs.getString("JOB");
                double sal = rs.getDouble("SAL");
                double comm = rs.getDouble("COMM");
                boolean hasComm = !rs.wasNull(); // check if COMM was actually NULL

                System.out.println(ename + "\t" + job + "\t" + sal + "\t" +
                        (hasComm ? comm : "NULL"));
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