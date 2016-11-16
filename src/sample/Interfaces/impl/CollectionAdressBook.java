package sample.Interfaces.impl;

import sample.Interfaces.AdressBook;
import sample.objects.Person;

import java.util.ArrayList;

/**
 * Created by alex on 16.11.16.
 */
public class CollectionAdressBook implements AdressBook {

    private ArrayList<Person> personList = new ArrayList<>();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void deleete(Person person) {
        personList.remove(person);
    }

    public ArrayList<Person> getPersonList(){
        return personList;
    }
}
