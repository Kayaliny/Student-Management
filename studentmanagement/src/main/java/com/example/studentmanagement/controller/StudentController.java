package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.CREATED);
    }

    // ✅ Modified GET all students with pagination, sorting & search
    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 5, sort = "id") Pageable pageable) {

        Page<Student> studentsPage = service.getStudents(search, pageable);
        return ResponseEntity.ok(studentsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
