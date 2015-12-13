package com.epam.jmp.service.impl.factory;

import com.epam.jmp.service.api.PersistenceServiceType;
import com.epam.jmp.service.api.PersonService;
import com.epam.jmp.service.api.factory.ElementsFactory;
import com.epam.jmp.service.api.factory.PersonFactory;
import com.epam.jmp.service.api.factory.PersonServiceFactory;
import com.epam.jmp.service.api.model.Person;
import com.epam.jmp.service.api.model.PersonType;

/**
 * Created by Ваня on 13.12.2015.
 */
public class ElementsFactoryImpl implements ElementsFactory {

    private PersonFactory personFactory;
    private PersonServiceFactory personServiceFactory;

    public ElementsFactoryImpl(PersonFactory personFactory, PersonServiceFactory personServiceFactory) {
        this.personFactory = personFactory;
        this.personServiceFactory = personServiceFactory;
    }

    @Override
    public Person createPerson(PersonType personType) {
        return personFactory.createPerson(personType);
    }

    @Override
    public PersonService createPersonService(PersistenceServiceType persistenceServiceType) {
        return personServiceFactory.createPersonService(persistenceServiceType);
    }
}
