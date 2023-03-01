package ru.catunderglue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.catunderglue.exception.IllegalEmailException;
import ru.catunderglue.exception.SameLoginAndEmailException;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    public static final String NORMAL_LOGIN = "login";
    public static final String NORMAL_EMAIL = "email@company.com";
    public static final String ILLEGAL_EMAIL = "email.com";
    public static final String LOGIN_EQUALS_EMAIL = "email@company.com";

    @Test
    @DisplayName("Пользователь успешно создан и поля инициализированы")
    public void shouldCreateUserWithAllArgs() {
        User user = new User(NORMAL_LOGIN, NORMAL_EMAIL);
        assertEquals(NORMAL_LOGIN, user.getLogin());
        assertEquals(NORMAL_EMAIL, user.getEmail());
    }

    @Test
    @DisplayName("Пользователь успешно создан без параметров и поля инициализированы null'ами")
    public void shouldCreateUserWithNoArgs() {
        User user = new User();
        assertNull(user.getEmail());
        assertNull(user.getLogin());
    }

    @Test
    @DisplayName("Ошибка при некорректной почте, без \"@\" или \".\"")
    public void shouldThrowIllegalEmailExcWhenCreatingUser() {
        assertThrows(IllegalEmailException.class, () -> new User(NORMAL_LOGIN, ILLEGAL_EMAIL));
    }

    @Test
    @DisplayName("Ошибка при создании user'a с одинаковой почтой и логином")
    public void shouldThrowSameLoginAndEmailExcWhenCreatingUser() {
        assertThrows(SameLoginAndEmailException.class, () -> new User(LOGIN_EQUALS_EMAIL, NORMAL_EMAIL));
    }
}
