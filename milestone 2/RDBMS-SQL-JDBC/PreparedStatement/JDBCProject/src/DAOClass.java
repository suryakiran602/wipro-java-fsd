import java.sql.*;

public class DAOClass {

    Connection con;

    // Constructor
    public DAOClass() {
        con = DBConnection.getConnection();
    }

    // Insert Student Record
    public void insert(int rollno, String name, String standard, String dob, double fees) {

        try {

            String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, TO_DATE(?,'DD-MON-YYYY'), ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, rollno);
            ps.setString(2, name);
            ps.setString(3, standard);
            ps.setString(4, dob);
            ps.setDouble(5, fees);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record Inserted Successfully");
            else
                System.out.println("Insertion Failed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Student Record
    public void delete(int rollno) {

        try {

            String sql = "DELETE FROM STUDENT WHERE ROLLNO = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, rollno);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record Deleted Successfully");
            else
                System.out.println("Record Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Modify Student Fees
    public void modify(int rollno, double fees) {

        try {

            String sql = "UPDATE STUDENT SET FEES = ? WHERE ROLLNO = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, fees);
            ps.setInt(2, rollno);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record Updated Successfully");
            else
                System.out.println("Record Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Display All Students
    public void display() {

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM STUDENT");

            System.out.println("---------------------------------------------------------------");
            System.out.println("ROLLNO\tNAME\tSTANDARD\tDATE OF BIRTH\tFEES");
            System.out.println("---------------------------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("ROLLNO") + "\t" +
                        rs.getString("STUDENTNAME") + "\t" +
                        rs.getString("STANDARD") + "\t\t" +
                        rs.getDate("DATE_OF_BIRTH") + "\t" +
                        rs.getDouble("FEES"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}