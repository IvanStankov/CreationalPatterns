package com.epam.jmp.service.impl.factory;

import com.epam.jmp.service.api.factory.PersonFactory;
import com.epam.jmp.service.api.model.PersonType;
import com.epam.jmp.service.impl.model.PersistablePerson;
import com.epam.jmp.service.api.model.Person;

/**
 * Created by Ваня on 13.12.2015.
 */
public class PersistablePersonFactory implements PersonFactory {

    @Override
    public Person createPerson(PersonType personType) {
        Person person = null;
        switch (personType) {
            case DUNEDAIN:
                person = PersistablePerson.newBuilder().setName("Isildor").setPosition("King").build();
                break;
            case MAJAR:
                person = PersistablePerson.newBuilder().setName("Gandalf").setPosition("Gray wizard").build();
                break;
        }
        return person;
    }

}
