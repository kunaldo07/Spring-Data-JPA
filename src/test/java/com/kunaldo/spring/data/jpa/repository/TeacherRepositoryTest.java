package com.kunaldo.spring.data.jpa.repository;

import com.kunaldo.spring.data.jpa.entity.Course;
import com.kunaldo.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .title("DBA2")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("t")
                .lastName("tt")
//                .courses(List.of(course,course2))
                .build();

        teacherRepository.save(teacher);
    }

}