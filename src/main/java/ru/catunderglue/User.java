package ru.catunderglue;

import ru.catunderglue.exception.IllegalEmailException;
import ru.catunderglue.exception.SameLoginAndEmailException;

public class User {
    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        if (login.equals(email)) {
            throw new SameLoginAndEmailException("Почта и логин не должны совпадать!");
        }
        if (!isEmailValid(email)){
            throw new IllegalEmailException("Укажите актуальную почту!");
        }
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    private boolean isEmailValid(String email){
        return email.contains("@") && email.contains(".");
    }
}
