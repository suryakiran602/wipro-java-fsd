package com.wipro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    // =================== Scenario 1 ===================

    public String getUserType(String userID) {

        String userType = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT UserType FROM USERS WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                userType = rs.getString("UserType");

            } else {

                userType = "User Not Found";

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return userType;

    }

    // =================== Scenario 2 ===================

    public String getIncorrectAttempts(String userID) {

        String result = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT IncorrectAttempts FROM USERS WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int attempts = rs.getInt("IncorrectAttempts");

                if (attempts == 0)

                    result = "No Incorrect Attempt";

                else if (attempts == 1)

                    result = "One Time";

                else

                    result = "Incorrect Attempt Exceeded";

            } else {

                result = "User Not Found";

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }

    // =================== Scenario 3 ===================

    public String changeUserType(String userID) {

        String message = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "UPDATE USERS SET UserType='Admin' WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userID);

            int rows = ps.executeUpdate();

            if (rows > 0)

                message = "Update Success";

            else

                message = "Update Failed";

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return message;

    }

    // =================== Scenario 4 ===================

    public int getLockStatus() {

        int count = 0;

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT COUNT(*) FROM USERS WHERE LockStatus=0";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                count = rs.getInt(1);

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return count;

    }

    // ===== Part-2 starts from here (Don't add } now)
        // =================== Scenario 5 ===================

    public String changeName(String userID, String name) {

        String message = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "UPDATE USERS SET Name=? WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, userID);

            int rows = ps.executeUpdate();

            if (rows > 0)
                message = "Name Updated Successfully";
            else
                message = "Update Failed";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // =================== Scenario 6 ===================

    public String changePassword(String password) {

        String message = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "UPDATE USERS SET Password=? WHERE UserType='Admin'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, password);

            int rows = ps.executeUpdate();

            if (rows > 0)
                message = "Password Changed Successfully";
            else
                message = "Password Change Failed";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // =================== Scenario 7 ===================

    public String addUser1(UserBean bean) {

        String message = "";

        try {

            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getUserID());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());

            int rows = ps.executeUpdate();

            if (rows > 0)
                message = "User Added Successfully";
            else
                message = "User Not Added";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // =================== Scenario 8 ===================

    public String addUser2(UserBean bean) {

        String message = "";

        try {

            if (bean.getLockStatus() != 0) {
                return "User LockStatus must be 0";
            }

            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getUserID());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());

            int rows = ps.executeUpdate();

            if (rows > 0)
                message = "User Added Successfully";
            else
                message = "User Not Added";

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // ===== Part-3 starts from here (Don't add } now)
        // =================== Scenario 9 ===================

    public ArrayList<UserBean> getUsers(String userType) {

        ArrayList<UserBean> list = new ArrayList<UserBean>();

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM USERS WHERE UserType=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userType);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UserBean bean = new UserBean();

                bean.setUserID(rs.getString("UserID"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                bean.setLockStatus(rs.getInt("LockStatus"));
                bean.setUserType(rs.getString("UserType"));

                list.add(bean);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =================== Scenario 10 ===================

    public ArrayList<UserBean> storeAllRecords() {

        ArrayList<UserBean> list = new ArrayList<UserBean>();

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM USERS";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UserBean bean = new UserBean();

                bean.setUserID(rs.getString("UserID"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                bean.setLockStatus(rs.getInt("LockStatus"));
                bean.setUserType(rs.getString("UserType"));

                list.add(bean);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =================== Scenario 11 ===================

    public String[] getNames() {

        String[] names = new String[100];

        int i = 0;

        try {

            Connection con = DBUtil.getConnection();

            String sql = "SELECT Name FROM USERS";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                names[i] = rs.getString("Name");
                i++;

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }

}