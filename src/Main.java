public class Main {

    public static void checkAuthentication(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (login == null || !login.matches("^[a-zA-Z0-9_]+$") || login.length() > 20) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры, " +
                    "знак подчеркивания и быть не длиннее 20 символов.");
        }

        if (password == null || !password.matches("^[a-zA-Z0-9_]+$") || password.length() > 20) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры, " +
                    "знак подчеркивания и быть не длиннее 20 символов.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }



    // Метод main
    public static void main(String[] args) {
        try {
            checkAuthentication("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("Аутентификация успешна!");

        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка аутентификации: " + e.getMessage());
        }
    }
}
