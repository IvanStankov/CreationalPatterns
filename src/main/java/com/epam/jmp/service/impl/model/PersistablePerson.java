package com.epam.jmp.service.impl.model;

import com.epam.jmp.service.api.model.Person;

import javax.persistence.*;

/**
 * Created by Ваня on 13.12.2015.
 */
@Entity
@Table(name = "MANAGEMENT_PERSON")
public class PersistablePerson implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "POSITION")
    private String position;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public static Builder newBuilder() {
        return new PersistablePerson().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setName(String name) {
            PersistablePerson.this.name = name;
            return this;
        }

        public Builder setPosition(String position) {
            PersistablePerson.this.position = position;
            return this;
        }

        public PersistablePerson build() {
            return PersistablePerson.this;
        }

    }

    @Override
    public String toString() {
        return "ManagementPerson{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public PersistablePerson clone() {
        PersistablePerson persistablePerson = null;
        try {
            persistablePerson = (PersistablePerson)super.clone();
        } catch (CloneNotSupportedException e) {
            // Ignore
        }
        return persistablePerson;
    }
}
