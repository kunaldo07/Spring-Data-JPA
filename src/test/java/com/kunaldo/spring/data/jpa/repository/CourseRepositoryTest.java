package com.kunaldo.spring.data.jpa.repository;

import com.kunaldo.spring.data.jpa.entity.Course;
import com.kunaldo.spring.data.jpa.entity.Student;
import com.kunaldo.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.print("courses = "+courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("p")
                .lastName("s")
                .build();


        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0,3);
        Pageable secondPagewithThreeRecords = PageRequest.of(1,3);

        List<Course> courses = courseRepository.findAll(firstPagewithThreeRecords).getContent();
        Long totalElements = courseRepository.findAll(firstPagewithThreeRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPagewithThreeRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D", (PageRequest) firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("L")
                .lastName("M")
                .build();

        Student student = Student.builder()
                .firstName("A")
                .lastName("S")
                .emailId("as@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(6)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}