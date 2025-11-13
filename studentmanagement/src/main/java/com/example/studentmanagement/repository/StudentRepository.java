package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import jakarta.validation.constraints.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Search by name (case-insensitive)
    List<Student> findByNameContainingIgnoreCase(String name);

    // Search by course (case-insensitive)
    List<Student> findByCourseContainingIgnoreCase(String course);

    // Pagination + Sorting + Search by name OR course
    Page<Student> findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(
            String name, String course, Pageable pageable);
}
