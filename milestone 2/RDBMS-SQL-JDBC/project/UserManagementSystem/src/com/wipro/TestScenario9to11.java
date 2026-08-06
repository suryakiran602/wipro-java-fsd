package com.wipro;

import java.util.ArrayList;

public class TestScenario9to11 {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        // ================= Scenario 9 =================
        System.out.println("----- Scenario 9 -----");

        ArrayList<UserBean> users = dao.getUsers("Employee");

        for (UserBean bean : users) {

            System.out.println(bean.getUserID() + " "
                    + bean.getName() + " "
                    + bean.getUserType());

        }

        // ================= Scenario 10 =================
        System.out.println("\n----- Scenario 10 -----");

        ArrayList<UserBean> allUsers = dao.storeAllRecords();

        for (UserBean bean : allUsers) {

            System.out.println(bean.getUserID() + " "
                    + bean.getPassword() + " "
                    + bean.getName() + " "
                    + bean.getIncorrectAttempts() + " "
                    + bean.getLockStatus() + " "
                    + bean.getUserType());

        }

        // ================= Scenario 11 =================
        System.out.println("\n----- Scenario 11 -----");

        String[] names = dao.getNames();

        for (String name : names) {

            if (name != null) {

                System.out.println(name);

            }

        }

    }

}