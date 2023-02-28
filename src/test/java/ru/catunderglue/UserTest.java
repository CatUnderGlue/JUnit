package ru.catunderglue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    public static final String NORMAL_LOGIN = "login";
    public static final String NORMAL_EMAIL = "email@company.com";
    public static final String ILLEGAL_EMAIL = "email.com";
    public static final String LOGIN_EQUALS_EMAIL = "email@company.com";

    @Test
    @DisplayName("Пользователь успешно создан и поля инициализированы")
    public void shouldCreateUserAllArgs() {
        User user = new User(NORMAL_LOGIN, NORMAL_EMAIL);
        assertEquals(NORMAL_LOGIN, user.getLogin());
        assertEquals(NORMAL_EMAIL, user.getEmail());
    }

    @Test
    @DisplayName("Пользователь успешно создан без параметров")
    public void shouldCreateUserNoArgs() {
        assertDoesNotThrow(() -> new User());
    }

    @Test
    @DisplayName("Почта должна содержать \"@\" и \".\"")
    public void isEmailValidCheck() {
        assertThrows(IllegalArgumentException.class, () -> new User(NORMAL_LOGIN, ILLEGAL_EMAIL));
    }

    @Test
    @DisplayName("Почта не должна совпадать с логином")
    public void isEmailEqualsLogin() {
        assertThrows(IllegalArgumentException.class, () -> new User(LOGIN_EQUALS_EMAIL, NORMAL_EMAIL));
    }
}
