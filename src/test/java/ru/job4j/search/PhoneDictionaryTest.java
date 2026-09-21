package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        Person person = new Person("Petr", "Arsentev", "534872", "Bryansk");
        phones.add(person);
        ArrayList<Person> expected = new ArrayList<>();
        expected.add(person);
        ArrayList<Person> result = phones.find("Petr");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNothingFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Igor");
        assertThat(persons).isEmpty();
    }
}