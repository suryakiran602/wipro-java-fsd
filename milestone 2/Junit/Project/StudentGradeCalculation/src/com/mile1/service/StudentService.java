package com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.*;

public class StudentService {

    public String calculateGrade(Student student)
            throws NullStudentException,
            NullNameException,
            NullMarksArrayException {

        if (student == null)
            throw new NullStudentException();

        if (student.getName() == null)
            throw new NullNameException();

        if (student.getMarks() == null)
            throw new NullMarksArrayException();

        int sum = 0;

        for (int mark : student.getMarks())
            sum += mark;

        double avg = sum / student.getMarks().length;

        if (avg >= 80)
            return "A";

        else if (avg >= 60)
            return "B";

        else if (avg >= 40)
            return "C";

        else if (avg >= 35)
            return "D";

        else
            return "F";
    }

    public int findNumberOfNullName(Student students[]) {
        int count = 0;

        for (Student s : students) {
            if (s != null && s.getName() == null)
                count++;
        }

        return count;
    }

    public int findNumberOfNullObjects(Student students[]) {
        int count = 0;

        for (Student s : students) {
            if (s == null)
                count++;
        }

        return count;
    }

    public int findNumberOfNullMarks(Student students[]) {
        int count = 0;

        for (Student s : students) {
            if (s != null && s.getMarks() == null)
                count++;
        }

        return count;
    }
}