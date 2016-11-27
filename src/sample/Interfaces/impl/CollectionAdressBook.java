package sample.Interfaces.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Interfaces.AdressBook;
import sample.objects.Person;

import java.util.ArrayList;

/**
 * Created by alex on 16.11.16.
 */
public class CollectionAdressBook implements AdressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList(){
        return personList;
    }

    public void print() {

        int number = 0;
        System.out.println();

        for (Person person : personList) {
            number++;
            System.out.println(number + " fio -> " + person.getFio() + " phone -> " + person.getPhone());
        }
    }

    public void fillTestData() {

        personList.add(new Person("Илья", "1111"));
        personList.add(new Person("Иван", "7788"));
        personList.add(new Person("Игорь", "745545788"));
        personList.add(new Person("Ира", "7545788"));
        personList.add(new Person("Юля", "7434388"));
        personList.add(new Person("Маша", "755558"));
        personList.add(new Person("Сергей", "111117788"));
        personList.add(new Person("Виктор", "98987788"));
        personList.add(new Person("Катя", "56677899"));
        personList.add(new Person("Джони", "44447788"));
        personList.add(new Person("Элон", "745789788"));
        personList.add(new Person("Трубадур", "77798464164948458588"));
    }



}
