package com.company.homeworkFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = 5385324195010387799L;

    private String name;
    private String surname;
    private String nickname;
    private Long phoneNumber;
    private String email;
    private int yearBirth;

    public Contact(String name, String surname, String nickname, Long PhoneNumber, String email, int yearBirth) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.phoneNumber = PhoneNumber;
        this.email = email;
        this.yearBirth = yearBirth;
    }

    public String getName() {
        return name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {

        return "Contact: " + name + " " + surname + " , " + nickname + " , " + phoneNumber + " , " + email + " , " + yearBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return yearBirth == contact.yearBirth && Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname) && Objects.equals(nickname, contact.nickname) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nickname, phoneNumber, email, yearBirth);
    }
}
