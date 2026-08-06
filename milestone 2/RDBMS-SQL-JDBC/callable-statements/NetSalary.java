import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NetSalary {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "system",
                    "2005");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT EMPNO, ENAME FROM EMP");

            System.out.println("EMPNO\tENAME\tNET SALARY");

            while (rs.next()) {

                int empno = rs.getInt("EMPNO");
                String ename = rs.getString("ENAME");

                CallableStatement cs =
                        con.prepareCall("{call CalculateNetSalary(?,?)}");

                cs.setInt(1, empno);
                cs.registerOutParameter(2, java.sql.Types.NUMERIC);

                cs.execute();

                double netSalary = cs.getDouble(2);

                System.out.println(empno + "\t" + ename + "\t" + netSalary);

                cs.close();
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}