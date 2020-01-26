package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (login != null && login.equals(user.getUsername())) {
                result = user;
            }
        }
        if (result == null) {
            throw new UserNotFoundException();
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null || user.getUsername() == null || !user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User(null, false),
                new User("Petr Arsentev", true),
                new User("No", true),
                new User("Trump", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("This user is not valid");
        } catch (UserNotFoundException e) {
            System.out.println("This user is not found.");
        }
    }
}
