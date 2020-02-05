package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150.0));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150.0));
    }

    @Test
    public void findByPassport() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("2135", "Boris Petrov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        User result = bank.findByPassport(user2.getPassport());
        assertThat(user2, is(result));
    }

    @Test
    public void findByRequisite() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Account account1 = new Account("5546", 150);
        Account account2 = new Account("113", 50);
        bank.addAccount(user.getPassport(), account1);
        bank.addAccount(user.getPassport(), account2);
        Account result = bank.findByRequisite(user.getPassport(), account2.getRequisite());
        assertThat(result, is(account2));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150.0));
        bank.addAccount(user.getPassport(), new Account("113", 50.0));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150.0);
        assertThat(bank.findByRequisite("3434", "113").getBalance(), is(200.0));
    }
}