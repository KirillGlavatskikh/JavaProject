package com.company.astronomia;

public enum OperationMenu {

    SNOW_INFORMATION_ALL_OBJECTS("1", "Show information all objects"),
    SHOW_OBJECT_AT_A_DISTANCE("2", "Show objects at a distance"),
    ADD_NEW_ASTRONOMICAL_OBJECT("3", "Add new astronomical object"),
    CHANGE_ASTRONOMICAL_OBJECT_INFORMATION("4", "Change astronomical object information"),
    DELETE_ASTRONOMICAL_OBJECT("5", "Delete astronomical object"),
    GET_STATISTICS_POSITION_ASTRONOMICAL_OBJECTS("6", "Get statistic position astronomical objects"),
    ADD_NEW_BLACK_HOLE("7", "Add new black hole"),
    CHANGE_BLACK_HOLE_INFORMATION("8", "Change black hole information"),
    GET_STATISTICS_POSITION_BLACK_HOLES("9", "Get statistic position black holes"),
    EXIT("10", "Exit");

    private String number;
    private String desc;

    OperationMenu(String number, String desc) {
        this.number = number;
        this.desc = desc;
    }

    public static OperationMenu enumByUser (String number){
        for(OperationMenu value : values()){
            if (value.number.equals(number)){
                return value;
            }
        }
        return null;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OperationMenu{");
        sb.append("number='").append(number).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
