package com.example.demo.Controller;
import com.example.demo.exceptii.ExistentPerson;
import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonRepoImplTest {
@Autowired
    private PersonRepoImpl underTest;

    @Autowired
    private File file;

    @Test
    void test(){
        System.out.println(file);
        underTest.test();
    }




    @Test
    void itSOuldReturnListOfPerson() throws FileNotFoundException {
        List<Person> personList=underTest.readPersoane();


        personList.forEach(e->{
            System.out.println(e);
        });
    }


    @Test
    void createPerson() throws IOException, ExistentPerson {
        Person person=new Person("asdadsad","Radulescu",12,"Roman");
        this.underTest.createPerson(person);

        assertEquals(this.underTest.checkPerson(person),true);
    }
    @Test
    void checkPerson() throws FileNotFoundException {
        Person person=new Person("Mihnea","Alexandru",20,"Romana");
        assertThat(underTest.checkPerson(person)).isTrue();
    }
//
    @Test
    void testInsert() throws IOException, ExistentPerson {
        Person person=new Person("Ghita","Alexandru",60,"Italian");

        this.underTest.createPerson(person);

        assertThat(this.underTest.checkPerson(person)).isTrue();
    }
//
    @Test
    void delete() throws IOException {
        this.underTest.deletePerson(3L);
    }

    @Test
    void updatePerson() throws ExistentPerson, IOException {
        Person person=new Person("Ghitaaa","Alaaaexandru",60,"Italian");
        this.underTest.updatePerson(2l,person);
        assertThat(this.underTest.checkPerson(person)).isTrue();
    }


}