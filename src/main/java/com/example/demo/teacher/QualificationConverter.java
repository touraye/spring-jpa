package com.example.demo.teacher;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class QualificationConverter implements AttributeConverter<Qualification, String> {

    @Override
    public String convertToDatabaseColumn(Qualification qualification) {
        if(qualification == null){
            return null;
        }

        return qualification.getCode();
    }

    @Override
    public Qualification convertToEntityAttribute(String code) {
        if(code == null){
            return null;
        }

        return Stream.of(Qualification.values())
                .filter(q -> q.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
