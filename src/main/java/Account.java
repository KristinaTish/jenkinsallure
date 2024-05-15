import static org.hamcrest.MatcherAssert.assertThat;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        int nameLength = name.length();
        String trimmedName = name.trim();
        String[] splitted = name.split(" ");

        // Проверка длины строки
        if (nameLength < 3 || nameLength > 19) {
            return false;
        }

        // Проверка наличия только одного пробела
        if (splitted.length != 2) {
            return false;
        }

        // Проверка, что пробел не находится в начале или в конце строки
        if (!name.equals(trimmedName)) {
            return false;
        }

        return true;
    }
}


/*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
              - 3 вкл - 19  вкл символов,
              - в строке есть только 1 пробел,
              - пробел стоит не в начале и не в конце строки.
         */