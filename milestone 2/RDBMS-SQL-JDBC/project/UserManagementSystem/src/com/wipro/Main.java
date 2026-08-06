package com.wipro;

public class Main {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        System.out.println("User Type : " + dao.getUserType("AB1001"));
        System.out.println("Attempts  : " + dao.getIncorrectAttempts("AB1001"));
        System.out.println("Update    : " + dao.changeUserType("TA1002"));
        System.out.println("Unlocked  : " + dao.getLockStatus());

    }
}