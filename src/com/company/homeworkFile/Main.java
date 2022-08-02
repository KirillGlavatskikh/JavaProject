package com.company.homeworkFile;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Long,Contact> listContact = new HashMap<>();

        // Ключем будет мобильный номер телефона. Возможность добавить дополнительные номера осталась.

        listContact.put(82344568934L,new Contact("Vasya","Ivanov", "Vasek", "783456",
                "vasek228@mail.ru",1995 ));
        listContact.put(81238903478L, new Contact("Petya", "Petrov", "Petruha", "451289",
                "Petruha@gmail.ru", 2000));
        listContact.put(88903457834L, new Contact("Sasha","Pupkin", "Sanek", "347812",
                "SanekPro@mail.ru", 1999));


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/Java Project/src/com/company/homeworkFile/PhoneBook.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/Java Project/src/com/company/homeworkFile/PhoneBook.txt"))){
            BufferedWriter bf = new BufferedWriter(new FileWriter("D:/Java Project/src/com/company/homeworkFile/Book.txt"));
            for (Map.Entry<Long, Contact> list : listContact.entrySet()) {
                bf.write(list.getKey() + " : " +list.getValue());
            }
            Contact [] contact = new Contact[objectInputStream.available()];
            for (int i = 0; i < contact.length; i++) {
                contact[i] = (Contact) objectInputStream.readObject();
            }
            System.out.println(Arrays.toString(contact));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
