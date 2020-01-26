package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void findUserWhenNameValidThenTrue() throws UserNotFoundException {
        String find = "Name";
        User[] users = {
                new User("AnotherName", true),
                new User(find, true)};
        User result = UserStore.findUser(users, find);
        User expect = users[1];
        assertThat(result, is(expect));
    }

    @Test
    public void findUserWhenAnyNameIsNull() throws UserNotFoundException {
        String find = "Name";
        User[] users = {
                new User(null, true),
                new User(find, true)};
        User result = UserStore.findUser(users, find);
        User expect = users[1];
        assertThat(result, is(expect));
    }

    @Test(expected = UserNotFoundException.class)
    public void findUserWhenNotFound() throws UserNotFoundException {
        String find = "Name";
        User[] users = {
                new User("AnotherName", true),
                new User("AnotherName2", true)};
        User result = UserStore.findUser(users, find);
    }

    @Test(expected = UserNotFoundException.class)
    public void findUserWhenFindNameIsNull() throws UserNotFoundException {
        String find = null;
        User[] users = {
                new User("AnotherName", true),
                new User(find, true)};
        User result = UserStore.findUser(users, find);

    }

    @Test(expected = UserNotFoundException.class)
    public void findUserWhenUsersEmpty() throws UserNotFoundException {
        String find = "Name";
        User[] users = {};
        User result = UserStore.findUser(users, find);

    }

    @Test
    public void validateWhenNameGreaterThan3AndIsValid() throws UserInvalidException {
        User user = new User("Name", true);
        boolean result = UserStore.validate(user);
        assertThat(result, is(true));
    }

    @Test(expected = UserInvalidException.class)
    public void validateWhenUserIsNull() throws UserInvalidException {
        User user = null;
        boolean result = UserStore.validate(user);
    }

    @Test(expected = UserInvalidException.class)
    public void validateWhenUserNameIsNull() throws UserInvalidException {
        User user = new User(null, true);
        boolean result = UserStore.validate(user);
    }

    @Test(expected = UserInvalidException.class)
    public void validateWhenUserNameIsShorterThan3() throws UserInvalidException {
        User user = new User("Na", true);
        boolean result = UserStore.validate(user);
    }

    @Test(expected = UserInvalidException.class)
    public void validateWhenUserIsValidateFalse() throws UserInvalidException {
        User user = new User("Name", false);
        boolean result = UserStore.validate(user);
    }
}