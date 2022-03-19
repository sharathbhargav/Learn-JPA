package com.example.jpa.demo_jpa.repository;

import com.example.jpa.demo_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstNamr); //
    // regex match on first name

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    //JPQL
    @Query("select s from Student s where s.emailId=?1") // not using table
        // names but rather the data class names "Student"
    Student findStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.emailId=?1") // not using
        // table
        // names but rather the data class names "Student"
    String findStudentFirstNameByEmailAddress(String email);


    @Query(nativeQuery = true,value = "SELECT  * from  tbl_student s where s" +
            ".email_address=?1")
    Student getStudentByEmailNative(String email);

    @Query(nativeQuery = true,value = "SELECT  * from  tbl_student s where s" +
            ".email_address=:emailid") // named parameter
    Student getStudentByEmailNativeNamedParam(@Param("emailid") String email);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update tbl_student set first_name=?1 " +
            "where email_address=?2")
    int updateStudentNameByEmailId(String firstName,String emailId);

}
