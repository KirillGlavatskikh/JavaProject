package com.company.MAP;

import java.util.Objects;

public class Human {

    private String city;
    private String fine;

    public Human(String city, String fine) {
        this.city = city;
        this.fine = fine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Human{");
        sb.append("city='").append(city).append('\'');
        sb.append(", fine='").append(fine).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return city.equals(human.city) && fine.equals(human.fine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, fine);
    }
}
