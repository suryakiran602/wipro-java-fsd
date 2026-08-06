package com.wipro;

public class TestScenario5to8 {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        // Scenario 5
        System.out.println("Scenario 5 : " +
                dao.changeName("AB1001", "Nagamani"));

        // Scenario 6
        System.out.println("Scenario 6 : " +
                dao.changePassword("admin123"));

        // Scenario 7
        UserBean user1 = new UserBean();
        user1.setUserID("AB2001");
        user1.setPassword("pass123");
        user1.setName("Ravi");
        user1.setIncorrectAttempts(0);
        user1.setLockStatus(0);
        user1.setUserType("Employee");

        System.out.println("Scenario 7 : " +
                dao.addUser1(user1));

        // Scenario 8
        UserBean user2 = new UserBean();
        user2.setUserID("AB2002");
        user2.setPassword("pass456");
        user2.setName("Suresh");
        user2.setIncorrectAttempts(0);
        user2.setLockStatus(0);
        user2.setUserType("Employee");

        System.out.println("Scenario 8 : " +
                dao.addUser2(user2));
    }
}