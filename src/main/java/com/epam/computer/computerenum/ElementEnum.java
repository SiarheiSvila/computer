package com.epam.computer.computerenum;

public enum ElementEnum {
    COMPUTERS("computers"),
    PERSONAL("personal"),
    LAPTOP("laptop"),
    NAME("name"),
    ORIGIN("origin"),
    YEAR("year"),
    PRICE("price"),
    RAM("ram"),
    ROM("rom"),
    KEYBOARD_PRODUCER("keyboard-producer"),
    WEIGHT("weight"),
    DIAGONAL("diagonal");

    private String value;
    private ElementEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
