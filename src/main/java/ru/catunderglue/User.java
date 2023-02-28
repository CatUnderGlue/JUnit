package ru.catunderglue;

public class User {
    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        setEmail(email);
        setLogin(login);
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        if (login.equals(this.email)){
            throw new IllegalArgumentException("Почта и логин не должны совпадать!");
        }
        this.login = login;
    }

    public void setEmail(String email) {
        if (email.equals(this.login)){
            throw new IllegalArgumentException("Почта и логин не должны совпадать!");
        } else if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Укажите актуальную почту!");
        }
        this.email = email;
    }

    private boolean isEmailValid(String email){
        return email.contains("@") && email.contains(".");
    }
}
