package com.epam.jmp.service.api.model;

import java.io.Serializable;

/**
 * Created by Ваня on 13.12.2015.
 */
public interface Person extends Serializable, Cloneable {

    String getName();

    String getPosition();

    Person clone();

}
