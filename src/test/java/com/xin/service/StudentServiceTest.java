package com.xin.service;

import com.xin.domain.PhoneNumber;
import com.xin.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CHENXINXIN on 2016/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudentService.class)
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void findAllStudents() throws Exception {
        List<Student> students = studentService.findAllStudents();
        System.out.println("------------------------------------");
        for (Student student : students){
            System.out.println(student);
        }
        System.out.println("------------------------------------");
    }

    @Test
    public void findStudentById() throws Exception {
        Student student = studentService.findStudentById(1);
        System.out.println("------------------------------------");
        System.out.println(student);
        System.out.println("------------------------------------");
    }

    @Test
    public void insertStudent() throws Exception {
        Student student = new Student();
        student.setName("lisi");
        student.setEmail("lisi@gmail.com");
        student.setDob(new Date());
        student.setPhone(new PhoneNumber("86-0393-6220820"));

        int count = studentService.insertStudent(student);

        findAllStudents();
    }

    @Test
    public void findById() throws Exception {
        HashMap<String, Object> map = studentService.findById(5);
        System.out.println("------------------------------------");
        for (String key : map.keySet()){
            System.out.println(key+" : "+map.get(key));
        }
        System.out.println("------------------------------------");
    }

    @Test
    public void findStudentWithAddress() throws Exception {
        Student student = studentService.findStudentWithAddress(1);
        System.out.println("------------------------------------");
        System.out.println(student);
        System.out.println("------------------------------------");

    }
}