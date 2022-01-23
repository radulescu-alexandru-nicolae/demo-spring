package com.example.demo.repository;

import com.example.demo.exceptii.ExistentPerson;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public interface PersonRepository {

     List<Person> readPersoane() throws FileNotFoundException;

    void createPerson(Person person) throws IOException, ExistentPerson;

    void deletePerson(Long id) throws IOException;


    void updatePerson(Long id,Person person) throws IOException, ExistentPerson;



}
