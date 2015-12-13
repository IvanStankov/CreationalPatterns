package com.epam.jmp.service.api.factory;

import com.epam.jmp.service.api.PersistenceServiceType;
import com.epam.jmp.service.api.PersonService;
import com.epam.jmp.service.api.model.Person;
import com.epam.jmp.service.api.model.PersonType;

/**
 * Created by Ваня on 13.12.2015.
 */
public interface ElementsFactory {

    Person createPerson(PersonType personType);

    PersonService createPersonService(PersistenceServiceType persistenceServiceType);

}
