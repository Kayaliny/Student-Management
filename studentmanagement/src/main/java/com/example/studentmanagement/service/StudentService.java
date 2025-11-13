package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    // Create
    Student saveStudent(Student student);

    // Read all (with pagination, sorting, search)
    Page<Student> getStudents(String search, Pageable pageable);

    // Read by ID
    Student getStudentById(Long id);

    // Update
    Student updateStudent(Long id, Student student);

    // Delete
    void deleteStudent(Long id);

    // Optional: Get all without pagination
    List<Student> getAllStudents();
}
