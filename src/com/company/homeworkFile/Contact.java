package com.company.homeworkFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = -1137015459714456182L;

    private String name;
    private String surname;
    private String nickname;
    private String additionPhoneNumber;
    private String email;
    private int yearBirth;

    public Contact(String name, String surname, String nickname, String additionPhoneNumber, String email, int yearBirth) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.additionPhoneNumber = additionPhoneNumber;
        this.email = email;
        this.yearBirth = yearBirth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", additionPhoneNumber='").append(additionPhoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", yearBirth=").append(yearBirth);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return yearBirth == contact.yearBirth && Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname) && Objects.equals(nickname, contact.nickname) && Objects.equals(additionPhoneNumber, contact.additionPhoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nickname, additionPhoneNumber, email, yearBirth);
    }
}
