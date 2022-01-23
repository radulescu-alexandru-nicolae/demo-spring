package com.example.demo.config;
import com.example.demo.Controller.PersonRepoImpl;
import com.example.demo.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Configuration
public class ConfigApp {

   @Bean
    public File file(){
       return new File("D:\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\Persoane");
   }

   @Bean
    public PersonRepoImpl personRepo(){
       return new PersonRepoImpl();
   }


   @Bean
    public List<Person> personList() throws FileNotFoundException {
       List<Person> persoane=new ArrayList<>();


       try {

           Scanner scanner = new Scanner(this.file());

           while (scanner.hasNextLine()) {
               String[] persoana = scanner.nextLine().split(",");
               Person person = new Person(Long.parseLong(persoana[0]),persoana[1], persoana[2], Integer.parseInt(persoana[3]), persoana[4]);
               persoane.add(person);

           }
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }
       return persoane;
   }







}
