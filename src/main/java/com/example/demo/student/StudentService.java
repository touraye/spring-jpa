package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student getStudent(Long studentId){
        boolean existingStudent = studentRepository.existsById(studentId);

        // check if student exist or not
        if(!existingStudent){
            throw new IllegalStateException("Student with id of " +studentId+ " dose not exist");
        }

        return studentRepository.findById(studentId).get();
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student){
        // we have access to students from our db in the student-repository
        // calling the findStudentByEmail and pass our newly created student's student.getEmail( to it
        // suppose our newly created student's student.getEmail( is ts@gmail.com and there a student with that student.getEmail(
        // the hasEmail.isPresent() will be true otherwise false
        Optional<Student> hasEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(hasEmail.isPresent()){
            throw new IllegalStateException("Email already exist");
        }

        // save student to db
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){

        // find student
        boolean existingStudent = studentRepository.existsById(studentId);

        if(!existingStudent){
            throw new IllegalStateException("Student with id of " +studentId+ " dose not exist");
        }

        // save student
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student updateStudent(Long studentId, Student student){
        LocalDate limitDate = LocalDate.of(2012, 6, 30);
        // check whether student exist or not
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() ->  new IllegalStateException(
                        "Student with id of " +studentId+ " does not exist"
                ));

        // more validations
        if(student.getName() != null && !student.getName().isEmpty() && !Objects.equals(existingStudent.getName(), student.getName())){
            existingStudent.setName(student.getName());
        }

        if(student.getEmail() != null && !student.getEmail().isEmpty() && !Objects.equals(existingStudent.getEmail(), student.getEmail())){
            existingStudent.setEmail(student.getEmail());
        }

        if(student.getDob() != null && !student.getDob().isBefore(limitDate) && !Objects.equals(existingStudent.getDob(), student.getDob())){
            existingStudent.setDob(student.getDob());
        }

        return studentRepository.save(existingStudent);
    }
}
