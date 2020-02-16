package ru.job4j.collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>(Set.of(
                new User("Petr", 32),
                new User("Ivan", 31)
        ));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePetrVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void sortByNameInNaturalOrder() {
        User amber = new User("Amber", 25);
        User boris = new User("Boris", 20);
        User alex = new User("Alex", 30);
        Comparator<User> comparator = new SortUserByNameNaturalOrder();
        List<User> list = List.of(amber, boris, alex);
        List<User> expect = List.of(alex, amber, boris);
        List<User> result = list.stream().sorted(comparator).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

    @Test
    public void sortByNameInReverseOrder() {
        User amber = new User("Amber", 25);
        User boris = new User("Boris", 20);
        User alex = new User("Alex", 30);
        Comparator<User> comparator = new SortUserByNameReverseOrder();
        List<User> list = List.of(amber, boris, alex);
        List<User> expect = List.of(boris, amber, alex);
        List<User> result = list.stream().sorted(comparator).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

    @Test
    public void sortByAgeInNaturalOrder() {
        User amber = new User("Amber", 25);
        User boris = new User("Boris", 20);
        User alex = new User("Alex", 30);
        Comparator<User> comparator = new SortUserByAgeNaturalOrder();
        List<User> list = List.of(amber, boris, alex);
        List<User> expect = List.of(boris, amber, alex);
        List<User> result = list.stream().sorted(comparator).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

    @Test
    public void sortByAgeInReverseOrder() {
        User amber = new User("Amber", 25);
        User boris = new User("Boris", 20);
        User alex = new User("Alex", 30);
        Comparator<User> comparator = new SortUserByAgeReverseOrder();
        List<User> list = List.of(amber, boris, alex);
        List<User> expect = List.of(alex, amber, boris);
        List<User> result = list.stream().sorted(comparator).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

    @Test
    public void sortByAgeNaturalAndByNameReverse() {
        User amber = new User("Amber", 25);
        User boris = new User("Boris", 20);
        User alex = new User("Alex", 25);
        Comparator<User> comparator = new SortUserByAgeNaturalOrder().thenComparing(new SortUserByNameReverseOrder());
        List<User> list = List.of(amber, boris, alex);
        List<User> expect = List.of(boris, amber, alex);
        List<User> result = list.stream().sorted(comparator).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

    @Test
    public void sortByNameNaturalAndByAgeReverse() {
        User boris = new User("Boris", 20);
        User alex = new User("Alex", 25);
        User alex2 = new User("Alex", 30);
        Comparator<User> comparator = new SortUserByNameNaturalOrder().thenComparing(new SortUserByAgeReverseOrder());
        List<User> list = List.of(boris, alex, alex2);
        List<User> expect = List.of(alex2, alex, boris);
        List<User> result = list.stream().sorted(comparator).collect(Collectors.toList());
        assertThat(result, is(expect));
    }
}
