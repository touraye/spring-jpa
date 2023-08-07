package com.example.demo.teacher;

public enum Qualification {
    QUALIFY("q"), UNQUALIFIED("u");

    private final String code;

    Qualification(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
