package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path="{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student){
        return studentService.updateStudent(
                studentId,
                student
        );
    }
}
