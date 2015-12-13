package com.epam.jmp.service.api.factory;

import com.epam.jmp.service.api.PersistenceServiceType;
import com.epam.jmp.service.api.PersonService;

/**
 * Created by Ваня on 13.12.2015.
 */
public interface PersonServiceFactory {

    PersonService createPersonService(PersistenceServiceType persistenceServiceType);

}
