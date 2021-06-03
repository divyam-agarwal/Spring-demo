package com.example.demo2.api;

import com.example.demo2.model.Person;
import com.example.demo2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.NonNull;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@NonNull @Valid @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> allPersons(){
        return personService.allPersons();
    }

    @GetMapping(path = "{id}")
    public Person selectPersonById(@PathVariable UUID id) {
        return personService.selectPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id,@NonNull @Valid @RequestBody Person updatedPerson){
        personService.updatePerson(id,updatedPerson);
    }
}
