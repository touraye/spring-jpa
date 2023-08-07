package com.example.demo.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository repository){
        return args -> {
            Teacher touray = new Teacher(
                    "Ebrima Touray",
                    "et@gmail.com",
                    LocalDate.of(1992, Month.MARCH, 20),
                    Qualification.QUALIFY
            );

            Teacher falis = new Teacher(
                    "Ebrima Faal",
                    "ef@gmail.com",
                    LocalDate.of(1994, Month.MARCH, 20),
                    Qualification.QUALIFY
            );

            Teacher omar = new Teacher(
                    "Omar Bajinga",
                    "ob@gmail.com",
                    LocalDate.of(1994, Month.JULY, 10),
                    Qualification.UNQUALIFIED
            );

            // save teacher
            repository.saveAll(
                    List.of(touray, falis, omar)
            );
        };
    }
}
