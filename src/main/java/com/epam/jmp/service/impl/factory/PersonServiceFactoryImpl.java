package com.epam.jmp.service.impl.factory;

import com.epam.jmp.service.api.PersistenceServiceType;
import com.epam.jmp.service.api.PersonService;
import com.epam.jmp.service.api.factory.PersonServiceFactory;
import com.epam.jmp.service.database.DbManager;
import com.epam.jmp.service.impl.DatabasePersonService;
import com.epam.jmp.service.impl.FilePersonService;

/**
 * Created by Ваня on 13.12.2015.
 */
public class PersonServiceFactoryImpl implements PersonServiceFactory {

    @Override
    public PersonService createPersonService(PersistenceServiceType persistenceServiceType) {
        PersonService result;
        switch (persistenceServiceType) {
            case DATABASE:
                result = new DatabasePersonService(DbManager.getInstance().getEntityManager());
                break;
            case FILE:
            default:
                result = new FilePersonService();
                break;

        }
        return result;
    }

}
