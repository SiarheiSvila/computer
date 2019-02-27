package com.epam.computer.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Computer", propOrder = {
        "origin", "year", "price", "RAM", "ROM"
})

public class Computer {
    @XmlAttribute(required = true)
    @XmlID
    protected String name;

    @XmlElement(required = true)
    protected String origin;

    @XmlElement(required = true)
    protected int year;

    @XmlElement(required = true)
    protected double price;

    @XmlElement(required = true)
    protected int RAM;

    @XmlElement(required = true)
    protected int ROM;

    public Computer() {
    }

    public Computer(String name, String origin, int year, double price, int RAM, int ROM) {
        this.name = name;
        this.origin = origin;
        this.year = year;
        this.price = price;
        this.RAM = RAM;
        this.ROM = ROM;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getRAM() {
        return RAM;
    }

    public int getROM() {
        return ROM;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", RAM=" + RAM +
                ", ROM=" + ROM +
                '}';
    }
}
