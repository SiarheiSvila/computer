package com.epam.computer.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Personal", propOrder = {
        "origin", "year", "price", "RAM", "ROM", "keyboard_producer"
})

public class Personal extends Computer {

    @XmlElement(required = true)
    private String keyboard_producer;

    public Personal() {
    }

    public Personal(String name, String origin, int year, double price, int RAM, int ROM, String keyboard_producer) {
        super(name, origin, year, price, RAM, ROM);
        this.keyboard_producer = keyboard_producer;
    }

    public String getKeyboard_producer() {
        return keyboard_producer;
    }

    public void setKeyboard_producer(String keyboard_producer) {
        this.keyboard_producer = keyboard_producer;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "keyboard_producer='" + keyboard_producer + '\'' +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", RAM=" + RAM +
                ", ROM=" + ROM +
                '}';
    }
}
