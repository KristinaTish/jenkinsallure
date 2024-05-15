import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getUserName(){
        return new Object[][]{
                {"Тимоти Шаламе", true}, //13 символов
                {"Тимоти Шаламемаева", true}, //18 симв
                {"Тимоти Шаламемаевая", true}, //19 симв
                {"Ти м", true}, //4 симв
                {"Т м", true}, //3 симв
                {"Тимоттея Шаламемемемемаевая", false}, //27 симв
                {"Тимотея Шаламемаевая", false}, //20 симв
                {"Тимоттея Шаламемаевая", false}, //21 симв
                {"Тимоттея Шаламемемемемаевая", false}, //27 симв
                {"ТимотиШаламе", false}, //слитное написание
                {"Т ", false}, //2 симв
                {"Т", false}, //1 симв
                {"", false}, //0 симв
                {" ", false}, //1 симв пробел
                {" ТимотиШаламе", false}, // пробел вначале
                {"ТимотиШаламе ", false}, //пробел в конце


        };
    }

    @Test
    @DisplayName("Проверяем валидацию имени держателя карты")
    @Description("Имя пользователя должно состоять из 3-19 символов, в строке есть только 1 пробел, нет пробелов в начале и в конце строки ")
    public void checkUserNameValidation(){
        Account account = new Account(name);
        boolean result = account.checkNameToEmboss();
        assertEquals("Булевое значение не совпадает с ожидаемым, невалидное имя проходит при регистрации карты", result, expected);
    }
}
