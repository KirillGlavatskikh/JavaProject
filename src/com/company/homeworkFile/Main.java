package com.company.homeworkFile;

import java.io.*;
import java.util.*;

public class Main {

    private static final String path = "D:/Java Project/src/com/company/homeworkFile/Phonebook.txt";

    public static void main(String[] args) {

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Vasya", "Pupkin", "Vasek", 83459862389L, "vasya228@mail.ru", 2000));
        contactList.add(new Contact("Petya", "Shishkin", "Petruha", 83434862586L, "petruha@gmail.ru", 1995));
        contactList.add(new Contact("Aleksey", "Ivanov", "Leha", 88959861239L, "leha@yandex.ru", 1999));

        outer:
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                printDialog();
                String currentSelect = scanner.nextLine();
                Menu enumByUser = Menu.getEnumByUser(currentSelect);
                if (enumByUser == null) {
                    System.out.println("Not found");
                    printDialog();
                    continue;
                }
                switch (enumByUser) {
                    case ADD_NEW_CONTACT -> addNewContact(contactList);
                    case SHOW_PHONE_BOOK -> printContactInPhoneBook();
                    case SEARCH_CONTACT -> contactSearch(contactList, scanner);
                    case EXIT -> {
                        System.out.println("Exit!");
                        break outer;
                    }
                    default -> System.out.println("Value not found");
                }
                printDialog();
            }
        }

        try {
            writeContactInPhoneBook(contactList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void printContactInPhoneBook() {

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Contact> list = (List<Contact>) ois.readObject();
            System.out.println(list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeContactInPhoneBook(List<Contact> contactList) throws ClassNotFoundException {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addNewContact(List<Contact> contactList) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter phone number");
            String phoneNumber = scanner.nextLine();
            if (checkPhoneNumber(contactList, Long.parseLong(phoneNumber))) {
                System.out.println("Contact exist!");
            } else {
                System.out.println("Enter name");
                String name = scanner.nextLine();
                System.out.println("Enter surname");
                String surname = scanner.nextLine();
                System.out.println("Enter nickname");
                String nickname = scanner.nextLine();
                System.out.println("Enter email");
                String email = scanner.nextLine();
                System.out.println("Enter year birth");
                int yearBirth = scanner.nextInt();
                contactList.add(new Contact(name, surname, nickname, Long.parseLong(phoneNumber), email, yearBirth));
                System.out.println("New contact added!");
            }
        }
    }

    private static void contactSearch(List<Contact> contactList, Scanner scanner) {
        System.out.println("Enter phone number");
        String checkContact = scanner.nextLine();
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(Long.parseLong(checkContact))) {
                System.out.println(contact);
            }
        }
    }

    private static boolean checkPhoneNumber(List<Contact> contactList, Long phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private static void printDialog() {
        System.out.println("""
                1. Add new contact
                2. Show phone book
                3. Search contact
                4. Exit
                Select item:
                """);
    }
}
