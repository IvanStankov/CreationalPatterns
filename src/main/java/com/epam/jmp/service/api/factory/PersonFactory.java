package com.epam.jmp.service.api.factory;

import com.epam.jmp.service.api.model.Person;
import com.epam.jmp.service.api.model.PersonType;

/**
 * Created by Ваня on 13.12.2015.
 */
public interface PersonFactory {

    Person createPerson(PersonType personType);

}
