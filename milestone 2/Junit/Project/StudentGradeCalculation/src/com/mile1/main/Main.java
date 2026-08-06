package com.mile1.main;

import com.mile1.bean.Student;
import com.mile1.service.StudentService;

public class Main {

    public static void main(String[] args) {

        Student s=new Student("Nagamani",
                new int[]{90,85,80});

        StudentService service=new StudentService();

        try {

            System.out.println("Grade : "
                    +service.calculateGrade(s));

        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}