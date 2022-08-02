package com.company.MAP;

public enum OperationMenu {

    PRINT_DATABASE("1", "Print database"),
    CODE_PRINTOUT("2", "Code printout"),
    FINE_PRINTOUT("3", "Fine printout"),
    CITY_PRINTOUT("4", "City printout"),
    ADD_HUMAN("5", "Add new human"),
    ADD_FINE("6", "Add fine"),
    DELETE_FINE("7", "Delete fine"),
    REPLACE_INFORMATION("8", "Replace information"),
    EXIT("9", "Exit");

    private String number;
    private String desc;

    OperationMenu(String number, String desc) {
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

    public static OperationMenu getEnumByUser(String number) {
        for (OperationMenu value : values()) {
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
