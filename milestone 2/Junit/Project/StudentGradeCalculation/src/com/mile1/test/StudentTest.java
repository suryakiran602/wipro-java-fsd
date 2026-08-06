package com.mile1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mile1.bean.Student;
import com.mile1.service.StudentService;
import com.mile1.exception.*;

public class StudentTest {

    StudentService service=new StudentService();

    @Test
    public void testGradeA() throws Exception {

        Student s=new Student("Ram",
                new int[]{90,85,80});

        assertEquals("A",
                service.calculateGrade(s));
    }

    @Test
    public void testGradeD() throws Exception {

        Student s=new Student("Sam",
                new int[]{35,36,37});

        assertEquals("D",
                service.calculateGrade(s));
    }

    @Test
    public void testGradeF() throws Exception {

        Student s=new Student("Raj",
                new int[]{10,20,25});

        assertEquals("F",
                service.calculateGrade(s));
    }

    @Test(expected=NullStudentException.class)
    public void testNullStudent() throws Exception {

        service.calculateGrade(null);
    }

    @Test(expected=NullNameException.class)
    public void testNullName() throws Exception {

        Student s=new Student(null,
                new int[]{80,80,80});

        service.calculateGrade(s);
    }

    @Test(expected=NullMarksArrayException.class)
    public void testNullMarks() throws Exception {

        Student s=new Student("Ram",null);

        service.calculateGrade(s);
    }

    @Test
    public void testNullNameCount()
    {
        Student arr[]={
                new Student(null,new int[]{10}),
                new Student("Ram",new int[]{20}),
                new Student(null,new int[]{30})
        };

        assertEquals(2,
                service.findNumberOfNullName(arr));
    }

    @Test
    public void testNullObjectCount()
    {
        Student arr[]={
                null,
                new Student("Ram",new int[]{10}),
                null
        };

        assertEquals(2,
                service.findNumberOfNullObjects(arr));
    }

    @Test
    public void testNullMarksCount()
    {
        Student arr[]={
                new Student("Ram",null),
                new Student("Sam",new int[]{20}),
                new Student("Raj",null)
        };

        assertEquals(2,
                service.findNumberOfNullMarks(arr));
    }
}