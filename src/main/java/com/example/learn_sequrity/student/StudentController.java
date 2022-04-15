package com.example.learn_sequrity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS  = Arrays.asList(
            new Student(1L,"Jame"),
            new Student(2L,"Amanda"),
            new Student(3L,"Kate")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + " does not exist")) ;
    }

}
