package com.example.demo.teacher;

import com.example.demo.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping(path="api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

//    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }
}
