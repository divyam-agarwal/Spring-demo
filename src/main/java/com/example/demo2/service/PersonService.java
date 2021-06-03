package com.example.demo2.service;

import com.example.demo2.dao.PersonDao;
import com.example.demo2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao persondao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao persondao) {
        this.persondao = persondao;
    }

    public int addPerson(Person person){
        return persondao.insertPerson(person);
    }

    public List<Person> allPersons(){
        return persondao.allPersons();
    }

    public Optional<Person> selectPersonById(UUID id) {
        return persondao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return persondao.deletePersonById(id);
    }

    public int updatePerson(UUID id,Person person){
        return persondao.updatePersonById(id,person);
    }
}
