package com.kunaldo.spring.data.jpa.repository;

import com.kunaldo.spring.data.jpa.entity.Guardian;
import com.kunaldo.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("kunal@gmail.com")
                .firstName("kunaldo")
                .lastName("kunaldo")
//                .guardianName("kuanldo")
//                .guardianEmail("kunaldo@gmail.com")
//                .guardianMobile("123")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("b3@g.com")
                .name("b")
                .mobile("1234")
                .build();

        Student student = Student.builder()
                .firstName("k")
                .emailId("k3@g.com")
                .lastName("b")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = "+studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("k");
        System.out.println("Students = "+students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("kun");
        System.out.println("Students = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("b");
        System.out.println("Students = "+students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("k2@g.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("kunaldo");
        System.out.println("Student = "+student);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("k2@g.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("k2@g.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("kunaldo updated","kunal@gmail.com");
    }


}