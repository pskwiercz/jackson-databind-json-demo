package com.pskwierc.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        Student theStudent = new Student();

        try {
            theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(theStudent.getFirstName());
        System.out.println(theStudent.getLastName());
        System.out.println(theStudent.getId());
        System.out.println(theStudent.isActive());

        System.out.println(theStudent.getAddress().getStreet());
        System.out.println(theStudent.getAddress().getCity());
        System.out.println(theStudent.getAddress().getState());
        System.out.println(theStudent.getAddress().getZip());
        System.out.println(theStudent.getAddress().getCountry());

        for(String language: theStudent.getLanguages()) {
            System.out.println(language);
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("data/student-full.json"), theStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
