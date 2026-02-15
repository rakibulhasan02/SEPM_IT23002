package com.example.studentjdbc.controller;

//package com.example.studentjdbc.controller;

import com.example.studentjdbc.model.Student;
import com.example.studentjdbc.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepo repo;

    public StudentController(StudentRepo repo) {
        this.repo = repo;
    }

    // POST /students  body: {"name":"Rakibul"}
    @PostMapping
    public String add(@RequestBody Student s) {
        if (s == null || s.getName() == null || s.getName().trim().isEmpty()) {
            return "Invalid name";
        }
        repo.insert(s.getName().trim());
        return "Inserted";
    }

    // GET /students
    @GetMapping
    public List<Student> all() {
        return repo.findAll();
    }
}
