package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurnameAndAnotherFindByAddress() {
        var phones = new PhoneDictionary();
        var boris = new Person("Boris", "Shumilov", "544454", "Gomel");
        var petr = new Person("Petr", "Arsentev", "534872", "Bryansk");
        var ivan = new Person("Ivan", "Bondar", "322535", "Derbent");
        phones.add(boris);
        phones.add(petr);
        phones.add(ivan);
        var persons = phones.find("ent");
        Person[] expected = {petr, ivan};
        assertThat(persons.toArray(new Person[0]), is(expected));
    }

    @Test
    public void whenNotFound() {
        var phones = new PhoneDictionary();
        var boris = new Person("Boris", "Shumilov", "544454", "Gomel");
        var petr = new Person("Petr", "Arsentev", "534872", "Bryansk");
        var ivan = new Person("Ivan", "Bondar", "322535", "Derbent");
        phones.add(boris);
        phones.add(petr);
        phones.add(ivan);
        var persons = phones.find("Vasya");
        Person[] expected = {};
        assertThat(persons.toArray(new Person[0]), is(expected));
    }
}