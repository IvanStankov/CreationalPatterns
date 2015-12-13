package com.epam.jmp.client;

import com.epam.jmp.service.api.PersistenceServiceType;
import com.epam.jmp.service.api.PersonService;
import com.epam.jmp.service.api.factory.ElementsFactory;
import com.epam.jmp.service.api.model.Person;
import com.epam.jmp.service.api.model.PersonType;
import com.epam.jmp.service.database.DbManager;
import com.epam.jmp.service.impl.factory.ElementsFactoryImpl;
import com.epam.jmp.service.impl.factory.PersistablePersonFactory;
import com.epam.jmp.service.impl.factory.PersonServiceFactoryImpl;

import java.util.List;

/**
 * Created by Ваня on 13.12.2015.
 */
public class Client {

    public static void main(String[] args) {
        try {
            init();

            ElementsFactory elementsFactory = new ElementsFactoryImpl(new PersistablePersonFactory(),
                    new PersonServiceFactoryImpl());

            Person dunedain = elementsFactory.createPerson(PersonType.DUNEDAIN);
            Person majar = elementsFactory.createPerson(PersonType.MAJAR);
            

            // Database service
            PersonService personService = elementsFactory.createPersonService(PersistenceServiceType.DATABASE);
            personService.writePerson(dunedain);
            personService.writePerson(majar);

            List<Person> persons = personService.readPersons();
            System.out.println(persons);

            // File service
            personService = elementsFactory.createPersonService(PersistenceServiceType.FILE);

            personService.writePerson(majar.clone());
            personService.writePerson(dunedain.clone());

            persons = personService.readPersons();
            System.out.println(persons);
        } finally {
            destroy();
        }
    }

    private static void init() {
        DbManager.getInstance().init();
    }

    private static void destroy() {
        DbManager.getInstance().destroy();
    }

}
