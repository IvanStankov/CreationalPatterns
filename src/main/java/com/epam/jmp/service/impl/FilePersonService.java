package com.epam.jmp.service.impl;

import com.epam.jmp.service.api.PersonService;
import com.epam.jmp.service.api.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ваня on 13.12.2015.
 */
public class FilePersonService implements PersonService {

    private File file;

    public FilePersonService() {
        file = new File("./persons.txt");
        try {
            file.createNewFile();
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writePerson(Person person) {
        List<Person> persons = readPersons();
        try (OutputStream out = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(out)) {
            if (persons == null) {
                persons = new ArrayList<>();
            }
            persons.add(person);
            oos.writeObject(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readPersons() {
        List<Person> persons = null;
        try (InputStream is = new FileInputStream(file);
             InputStream buffer = new BufferedInputStream(is);
             ObjectInput input = new ObjectInputStream(buffer)) {
            persons = (List<Person>) input.readObject();
        } catch (EOFException e) {
            // Ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
