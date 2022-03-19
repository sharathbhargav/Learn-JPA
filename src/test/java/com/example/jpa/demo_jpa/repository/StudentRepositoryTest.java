package com.example.jpa.demo_jpa.repository;

import com.example.jpa.demo_jpa.entity.Guardian;
import com.example.jpa.demo_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student=Student.builder().emailId("ssss@safsd")
                .firstName("asdfsdfs")
//                .guardianEmail("afasfsa")
                .lastName("asfsf")
//                .guardianMobile("1234567890")
//                .guardianName("asasf")
                .lastName("afsaf")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudent1(){
        Guardian gd = Guardian.builder().email("guardian email")
                .mobile("999999999")
                .name("guardian").build();
        Student st=Student.builder().guardian(gd)
                .emailId("email_id")
                .lastName("last name1")
                .firstName("first namme1").build();
        studentRepository.save(st);
    }

    @Test
    void printStudent(){
        List<Student> list = studentRepository.findAll();
        System.out.println(list);
    }

    @Test
    void findStudentByName(){
        List<Student> students = studentRepository.findByGuardianName("guardian");
        System.out.println(students);
    }

    @Test
    void findByEmail(){
        Student list = studentRepository.getStudentByEmailNative(
                "ssss@safsd");
        System.out.println(list);
    }
}