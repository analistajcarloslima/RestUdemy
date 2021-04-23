package br.com.jow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.jow.model.Person;

//Service vai permitir que o spring use a classe em outras sem a necessidade de criar uma instancia ( chamado de injeção)
@Service
public class PersonServices {

    // esse couter vai gerar um id para o database
    private final AtomicLong counter = new AtomicLong();
    
    //metodo para criação de um objeto person
    public Person create(Person person) {
        return person;
    }

    //metodo para criação de update um objeto person
    public Person update(Person person) {
        return person;
    }

        //metodo para deletar de update um objeto person
        public void delete(String id) {
        }
    



    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Jow");
        person.setLastname("Lima");
        person.setAdress("Orós");
        person.setGender("Male");
        return person;

    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;

    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Person Name" + i);
        person.setLastname("Last" + i);
        person.setAdress("Adress" + i);
        person.setGender("Sex" + i);
        return person;

    }
}
