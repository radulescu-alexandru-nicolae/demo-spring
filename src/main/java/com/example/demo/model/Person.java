package com.example.demo.model;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private Long id;

    public Person(Long id,String firstName, String lastName, int age, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.id=id;
    }

    public Person(String firstName, String lastName, int age, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {

       Person aux=(Person) o;

       return aux.getAge()==this.getAge()&&aux.getFirstName().equals(this.getFirstName())&&aux.getLastName().equals(this.getLastName())&&aux.getNationality().equals(this.getNationality());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toSave(){
        return this.getId()+","+this.firstName+","+this.lastName+","+this.age+','+this.getNationality();
    }
}
