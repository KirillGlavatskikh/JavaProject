package com.company.JCF;

import java.util.*;

public class Task02 {

    // Ќеобходимо разработать приложение, которое позволит сохран€ть информацию о логинах пользователей
    //и их парол€х.  аждому пользователю соответствует пара
    // логин Ч пароль. ѕри старте приложение отображаетс€
    // меню:
    //    1. ƒобавить нового пользовател€.
    //2. ”далить существующего пользовател€.
    // 3. ѕроверить существует ли пользователь.
    //  4. »зменить логин существующего пользовател€.
    // 5. »зменить пароль существующего пользовател€.
    // ¬ зависимости от выбора пользовател€ выполн€етс€ действие, после чего меню отображаетс€ снова. ƒл€
    //решени€ задачи используйте подход€щий класс из Java
    //Collections Framework.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Human> list = new LinkedList<>();
        list.add(new Human("maxim", "0000"));
        list.add(new Human("petya", "1234"));
        list.add(new Human("vlad", "5555"));
        System.out.println(list);

        System.out.println("Enter menu item");
        printMenu();
        outer:
        while (scanner.hasNextLine()) {
            String currentOperation = scanner.nextLine();
            Menu enumByUser = Menu.getEnumByUser(currentOperation);
            if (enumByUser == null) {
                System.out.print("Operation not found!\n");
                printMenu();
                continue;
            }
            switch (enumByUser) {
                case ADD_USER -> addNewUser(list, scanner);
                case DELETE_USER -> deleteUser(list, scanner);
                case CHECK_USER -> userSearch(list, scanner);
                case CHANGE_LOGIN -> changeLogin(list, scanner);
                case CHANGE_PASSWORD -> changePassword(list, scanner);
                case EXIT -> {
                    System.out.println("Exit");
                    break outer;
                }
                default -> System.out.print("Value not supported.\n");
            }
            printMenu();
        }
        scanner.close();

    }

    private static void addNewUser(LinkedList<Human> list, Scanner scanner) {
        System.out.println("Enter login: ");
        while (scanner.hasNextLine()) {
            String login = scanner.nextLine();
            if (login.equals("exit")) {
                System.out.println("Exit");
                break;
            } else if (isCheckLoginUser(list, login)) {
                System.out.println("User exist");
            } else {
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                list.add(new Human(login, password));
            }
            System.out.println("Enter login: ");
        }
        System.out.println(list);
    }

    private static void deleteUser(LinkedList<Human> list, Scanner scanner) {
        System.out.println("Enter login: ");
        String loginDel = scanner.nextLine();
        list.removeIf(currentUser -> currentUser.getLogin().equals(loginDel));
        System.out.println(list);
    }

    private static void userSearch(LinkedList<Human> list, Scanner scanner) {
        System.out.println("Enter login: ");
        String checkLogin = scanner.nextLine();
        if (isCheckLoginUser(list, checkLogin)) {
            System.out.println("User exist");
        } else {
            System.out.println("User not exist");
        }
    }

    private static void changeLogin(LinkedList<Human> list, Scanner scanner) {
        System.out.println("Enter old login: ");
        String oldLogin = scanner.nextLine();
        for (Human currentLogin : list) {
            if (!currentLogin.getLogin().contains(oldLogin)) {

            } else {
                System.out.println("Enter new login: ");
                String newLogin = scanner.nextLine();
                currentLogin.setLogin(newLogin);
            }
        }
        System.out.println(list);
    }

    private static void changePassword(LinkedList<Human> list, Scanner scanner) {
        System.out.println("Enter old password");
        String oldPassword = scanner.nextLine();
        System.out.println("Enter new password");
        String newPassword = scanner.nextLine();
        for (Human currentPassword : list) {
            if (currentPassword.getPassword().equals(oldPassword)) {
                currentPassword.setPassword(newPassword);
                break;
            }
        }
        System.out.println(list);
    }

    private static boolean isCheckLoginUser(LinkedList<Human> list, String checkLogin) {
        for (Human currentCheckLogin : list) {
            if (currentCheckLogin.getLogin().equals(checkLogin)) {
                return true;
            }
        }
        return false;
    }


    private static void printMenu() {
        System.out.println("""
                1.Add new user
                2.Delete user
                3.check user exist
                4.New login
                5.New password
                6.exit""");
    }

}