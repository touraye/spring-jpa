package com.example.demo.teacher;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Teacher {
        @Id
        @SequenceGenerator(
                name = "teacher_sequence",
                sequenceName = "teacher_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "teacher_sequence"
        )

    private Long id;
    private String full_name;
    private String email;
    private LocalDate dob;
    private Qualification qualification;


    // constructor with args
    public Teacher(){

    }
    public Teacher(Long id,
                   String full_name,
                   String email,
                   LocalDate dob,
                   Qualification qualification) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.dob = dob;
        this.qualification = qualification;
    }

    public Teacher(String full_name,
                   String email,
                   LocalDate dob,
                   Qualification qualification) {
        this.full_name = full_name;
        this.email = email;
        this.dob = dob;
        this.qualification = qualification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", qualification=" + qualification +
                '}';
    }
}
