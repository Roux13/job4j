package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addNull() {
        Citizen citizen = null;
        PassportOffice office = new PassportOffice();
        boolean result = office.add(citizen);
        assertThat(result, is(false));
    }

    @Test
    public void addCitizenWithNullPassport() {
        Citizen citizen = new Citizen(null, "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        boolean result = office.add(citizen);
        assertThat(result, is(false));
    }

    @Test
    public void get() {
        String passport = "2f44a";
        Citizen citizen = new Citizen(passport, "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen result = office.get(passport);
        assertThat(result, is(citizen));
    }

    @Test
    public void getWhenHasNot() {
        String passport = "88888";
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen result = office.get(passport);
        Citizen expect = null;
        assertThat(result, is(expect));
    }
}