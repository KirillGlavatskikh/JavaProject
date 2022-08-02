package com.company.MAP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Реализовать базу данных налоговой инспекции по
    //штрафам. Идентифицировать конкретного человека бу-
    //дет его персональный идентификационный код. У одного
    //человека может быть много штрафов.
    //Реализовать:
    //1. Полная распечатка базы данных.
    //2. Распечатка данных по конкретному коду.
    //3. Распечатка данных по конкретному типу штрафа.
    //4. Распечатка данных по конкретному городу.
    //5. Добавление нового человека с информацией о нем.
    //6. Добавление новых штрафов для уже существующей записи.
    //7. Удаление штрафа.
    //8. Замена информации о человеке и его штрафах.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Human> database = new HashMap<>();

        database.put("1", new Human("Moscow", "3000"));
        database.put("2", new Human("Saratov", "1500"));
        database.put("3", new Human("Volgograd", "2500"));

        printDialog();

        outer:
        while (scanner.hasNextLine()) {
            System.out.println("Select item: ");
            String currentSelect = scanner.nextLine();
            OperationMenu enumByUser = OperationMenu.getEnumByUser(currentSelect);
            if (enumByUser == null) {
                System.out.println("Not found");
                printDialog();
                continue;
            }
            switch (enumByUser) {
                case PRINT_DATABASE -> printDatabase(database);
                case CODE_PRINTOUT -> printCode(database, scanner);
                case FINE_PRINTOUT -> printFine(database, scanner);
                case CITY_PRINTOUT -> printCity(database, scanner);
                case ADD_HUMAN -> addNewHuman(database, scanner);
                case ADD_FINE -> addNewFine(database, scanner);
                case DELETE_FINE -> deleteFine(database, scanner);
                case REPLACE_INFORMATION -> replaceInformation(database, scanner);
                case EXIT -> {
                    System.out.println("Exit");
                    break outer;
                }
                default -> System.out.println("Value not supported!");
            }
            printDialog();
        }
        scanner.close();
    }

    private static void printDatabase(Map<String, Human> database) {
        System.out.println(database);
    }

    private static void printCode(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter id: ");
        String code = scanner.nextLine();
        System.out.println(database.get(code));
    }

    private static void printFine(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter fine: ");
        String fine = scanner.nextLine();
        for (Map.Entry<String, Human> item : database.entrySet()) {
            if (item.getValue().getFine().equals(fine)) {
                System.out.println("Personal id: " + item.getKey() + " Information: " + item.getValue());
            }
        }
    }

    private static void printCity(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter city: ");
        String city = scanner.nextLine();
        for (Map.Entry<String, Human> item : database.entrySet()) {
            if (item.getValue().getCity().equals(city)) {
                System.out.println("Personal id: " + item.getKey() + " Information: " + item.getValue());
            }
        }
    }

    private static void addNewHuman(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter new id: ");
        while (scanner.hasNextLine()) {
            String id = scanner.nextLine();
            if (id.equals("exit")) {
                System.out.println("Exit");
                break;
            } else if (isCheckId(database, id)) {
                System.out.println("Human exist");
            } else {
                System.out.println("Enter city: ");
                String city = scanner.nextLine();
                System.out.println("Enter fine: ");
                String fine = scanner.nextLine();
                database.put(id, new Human(city, fine));
                System.out.println(database);
            }
            System.out.println("Enter id: ");
        }
    }

    private static void addNewFine(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter new fine: ");
        String newFine = scanner.nextLine();
        for (Map.Entry<String, Human> item : database.entrySet()) {
            if (item.getKey().equals(id)) {
                String fine = item.getValue().getFine() + ", ";
                fine = fine.concat(newFine);
                item.getValue().setFine(fine);
            }
        }
        System.out.println(database);
    }

    private static void deleteFine(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter fine to delete: ");
        String deleteFine = scanner.nextLine();
        for (Map.Entry<String, Human> item : database.entrySet()) {
            if (item.getKey().equals(id)) {
                String fineReplace = item.getValue().getFine().replace(deleteFine, "");
                item.getValue().setFine(fineReplace);
            }
        }
        System.out.println(database);
    }

    private static void replaceInformation(Map<String, Human> database, Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        for (Map.Entry<String, Human> item : database.entrySet()) {
            if (item.getKey().equals(id)) {
                System.out.println("Change city? (yes/no)");
                String checkCity = scanner.nextLine();
                if (checkCity.equals("no")) {
                    System.out.println("Exit");
                    break;
                } else {
                    System.out.println("Enter new city: ");
                    String newCity = scanner.nextLine();
                    item.getValue().setCity(newCity);
                }
                System.out.println("Change fine? (yes/no)");
                String checkFine = scanner.nextLine();
                if (checkFine.equals("no")) {
                    System.out.println("Exit");
                    break;
                } else {
                    System.out.println("Enter new fine: ");
                    String newFine = scanner.nextLine();
                    item.getValue().setFine(newFine);
                }
            }
        }
        System.out.println(database);
    }

    private static boolean isCheckId(Map<String, Human> database, String id) {
        for (Map.Entry<String, Human> item : database.entrySet()) {
            if (item.getKey().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static void printDialog() {
        System.out.println("""
                1. Print database
                2. Code printout
                3. Fine printout
                4. City printout
                5. Add new human
                6. Add new fine
                7. Delete fine
                8. Replace information
                9. Exit
                Select item:
                """);
    }
}


