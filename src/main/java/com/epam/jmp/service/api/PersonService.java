package com.epam.jmp.service.api;

import com.epam.jmp.service.api.model.Person;

import java.util.List;

/**
 * Created by Ваня on 13.12.2015.
 */
public interface PersonService {

    void writePerson (Person person);

    List<Person> readPersons();

}
