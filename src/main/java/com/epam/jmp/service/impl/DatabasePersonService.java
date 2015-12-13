package com.epam.jmp.service.impl;

import com.epam.jmp.service.api.PersonService;
import com.epam.jmp.service.api.model.Person;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ваня on 13.12.2015.
 */
public class DatabasePersonService implements PersonService {

    private EntityManager entityManager;

    public DatabasePersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void writePerson(Person person) {
        entityManager .getTransaction().begin();

        entityManager.persist(person);

        entityManager.getTransaction().commit();
    }

    @Override
    public List<Person> readPersons() {
        return entityManager.createQuery("select r from PersistablePerson r").getResultList();
    }
}
