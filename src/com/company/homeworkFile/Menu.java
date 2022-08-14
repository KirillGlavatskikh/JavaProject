package com.company.homeworkFile;

public enum Menu {

    ADD_NEW_CONTACT("1", "Add new contact"),
    SHOW_PHONE_BOOK("2", "Show phone book"),
    SEARCH_CONTACT("3", "Search contact"),
    EXIT("4", "Exit");

    private String number;
    private String desc;

    Menu(String number, String desc) {
        this.number = number;
        this.desc = desc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Menu getEnumByUser(String number) {
        for (Menu value : values()) {
            if (value.number.equals(number)) {
                return value;
            }
        }
        return null;
    }
}
