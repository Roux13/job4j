package ru.job4j.stream.tourist;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address address1 = new Address("Moscow", "Tverskaya", 15, 7);
        Address address2 = new Address("London", "Baker st.", 46, 1);
        Address address3 = new Address("New York", "Park avenue", 111, 11);
        Profile client1 = new Profile(address1);
        Profile client2 = new Profile(address2);
        Profile client3 = new Profile(address3);
        List<Profile> in = List.of(client1, client2, client3);
        List<Address> expect = List.of(address2, address1, address3);
        List<Address> result = new Profiles().collect(in);
        assertThat(result, is(expect));
    }

    @Test
    public void collectWithDuplicates() {
        Address address1 = new Address("Moscow", "Tverskaya", 15, 7);
        Address address2 = new Address("London", "Baker st.", 46, 1);
        Address address3 = new Address("New York", "Park avenue", 111, 11);
        Profile client1 = new Profile(address1);
        Profile client2 = new Profile(address2);
        Profile client22 = new Profile(address2);
        Profile client3 = new Profile(address3);
        List<Profile> in = List.of(client1, client2, client22, client3);
        List<Address> expect = List.of(address2, address1, address3);
        List<Address> result = new Profiles().collect(in);
        assertThat(result, is(expect));
    }

}