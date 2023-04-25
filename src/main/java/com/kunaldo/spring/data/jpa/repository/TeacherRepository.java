package com.kunaldo.spring.data.jpa.repository;

import com.kunaldo.spring.data.jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
