package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> usersAccount = this.users.get(user);
            if (!usersAccount.contains(account)) {
                usersAccount.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return this.users.keySet().stream()
                .flatMap(Stream::ofNullable)
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = this.findByPassport(passport);
        if (user != null) {
            result = this.users.get(user).stream()
                    .flatMap(Stream::ofNullable)
                    .filter(acc -> requisite.equals(acc.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            result = true;
        }
        return result;
    }
}