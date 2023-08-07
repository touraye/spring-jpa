package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           Student alieu = new Student(
                    "Alieu Saidy",
                    "asaidy@gmail.com",
                    LocalDate.of(2012, Month.NOVEMBER, 23)
            );

            Student mariama = new Student(
                    "Mariama Saidy",
                    "msaidy@gmail.com",
                    LocalDate.of(2017, Month.DECEMBER, 13)
            );

            Student fatoumata = new Student(
                    "Fatoumata Touray",
                    "ftouray@gmail.com",
                    LocalDate.of(2012, Month.DECEMBER, 12)
            );

            // save student collection to the database
            repository.saveAll(
                    List.of(
                            alieu,
                            mariama,
                            fatoumata
                    )
            );
        };
    }
}
