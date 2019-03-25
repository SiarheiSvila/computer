package com.epam.computer.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (namespace="http://www.examle.com/computers", name = "personal")
@XmlType (name = "Personal", namespace="http://www.examle.com/computers")

public class Personal extends Computer {

    @XmlElement(name = "keyboard-producer", namespace = "http://www.examle.com/computers")
    private String keyboard_producer;

    public Personal() {
    }

    public Personal(String name, String origin, int year, double price, int RAM, int ROM, String keyboard_producer) {
        super(name, origin, year, price, RAM, ROM);
        this.keyboard_producer = keyboard_producer;
    }

    public Personal(Computer computer){
        super(computer.getName(), computer.getOrigin(), computer.getYear(),
                computer.getPrice(), computer.getRAM(), computer.getROM());
    }

    public Personal(String keyboard_producer) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Personal personal = (Personal) o;

        return keyboard_producer.equals(personal.keyboard_producer);
    }

    @Override
    public int hashCode() {
        return (51*super.hashCode() + ((keyboard_producer== null)? 0 : 816));
    }
}
