package com.example.learn_sequrity.student;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS  = Arrays.asList(
            new Student(1L,"Jame"),
            new Student(2L,"Amanda"),
            new Student(3L,"Kate")
    );

    @GetMapping
    public List<Student> getAllStudent() {
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("Was create a new student:\n" + student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        System.out.println(id);
    }

    @PutMapping(path = "/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestBody Student student) {
        System.out.printf("%s %s%n",id,student);
    }
}
