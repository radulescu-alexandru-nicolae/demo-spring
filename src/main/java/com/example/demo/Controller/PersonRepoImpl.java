package com.example.demo.Controller;

import com.example.demo.exceptii.ExistentPerson;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.*;
import java.util.List;
public class PersonRepoImpl implements PersonRepository {
    @Autowired
    File file;
    @Autowired
    List<Person> personList;


    void test(){
        System.out.println(file);

    }
    @Override
    public List<Person> readPersoane() throws FileNotFoundException {
      return this.personList;
    }

    @Override
    public void createPerson(Person person) throws IOException, ExistentPerson {
        if(checkPerson(person)==false){

            person.setId((long)(this.readPersoane().size()+1));
            this.personList.add(person);

            savePerson(this.personList);
        }else{
            throw new ExistentPerson("Aceasta persoana deja se afla in lista noastra");
        }
    }

    @Override
    public void deletePerson(Long id) throws IOException {
       for(int i=0;i<this.personList.size();i++){
           if(personList.get(i).getId()==id){
               this.personList.remove(i);
           }
       }
        this.personList.forEach(e->{
            System.out.println(e);
        });
        savePerson(this.personList);
    }

    @Override
    public void updatePerson(Long id, Person person) throws IOException, ExistentPerson {
        Person aux=this.returnPerson(id);
        if(checkPerson(person)==false&&aux!=null){
            aux.setAge(person.getAge());
            aux.setFirstName(person.getFirstName());
            aux.setLastName(person.getLastName());
            aux.setNationality(person.getNationality());


            this.deletePerson(id);
            this.createPerson(aux);


        }else{
            System.out.println("Este o erroare");
        }

    }
    protected boolean checkPerson(Person person) throws FileNotFoundException {


        return this.readPersoane().stream().anyMatch(person1 -> person.equals(person1));

    }
    protected Person returnPerson(Long id) throws FileNotFoundException {
        return this.readPersoane().stream().filter(e->e.getId()==id).findAny().orElse(null);
    }
    private void savePerson(List<Person> personList) throws IOException {
        String mesaj="";

        for(int i=0;i<personList.size();i++){
            Person aux=personList.get(i);
            mesaj+=(aux.toSave()+"\n");
        }

        FileWriter fileWriter=new FileWriter(file);
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.print(mesaj);
        printWriter.close();

    }
}
