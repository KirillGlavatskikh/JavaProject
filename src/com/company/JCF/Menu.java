package com.company.JCF;

public enum Menu {
    ADD_USER("1", "Add new user"),
    DELETE_USER("2", "Delete user"),
    CHECK_USER("3", "User exist?"),
    CHANGE_LOGIN("4", "Change login"),
    CHANGE_PASSWORD("5", "Change password"),
    EXIT("6", "Exit");


    private final String number;
    private final String desc;

    Menu(String number, String desc) {
        this.number = number;
        this.desc = desc;
    }

    public String getNumber() {
        return number;
    }

    public String getDesc() {
        return desc;
    }

    public static Menu getEnumByUser(String number) {
        for (Menu value : values()) {
            if (value.number.equals(number)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(desc);
        sb.append("\n");
        return sb.toString();
    }
}
