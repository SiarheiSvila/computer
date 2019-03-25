package com.epam.computer.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType ( name = "computer", propOrder = {"origin", "year", "price", "RAM", "ROM"}, namespace="http://www.examle.com/computers")
public abstract class Computer {

    @XmlAttribute(name = "name")
    protected String name;

    @XmlElement(name = "origin", namespace = "http://www.examle.com/computers")
    protected String origin;

    @XmlElement(name = "year", namespace = "http://www.examle.com/computers")
    protected int year;

    @XmlElement(name = "price", namespace = "http://www.examle.com/computers")
    protected double price;

    @XmlElement(name = "RAM", namespace = "http://www.examle.com/computers")
    protected int RAM;

    @XmlElement(name = "ROM", namespace = "http://www.examle.com/computers")
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

        Computer computer = (Computer) o;

        if(year != computer.year) {
            return false;
        }
        if(computer.price != price) {
            return false;
        }
        if (RAM != computer.RAM) {
            return false;
        }
        if (ROM != computer.ROM) {
            return false;
        }
        if (!name.equals(computer.name)) {
            return false;
        }
        if (!origin.equals(computer.origin)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(234 +
                12*year +
                32*price +
                61*RAM +
                3*ROM +
                ((name == null)? 0:name.hashCode()) +
                ((origin == null)? 0:origin.hashCode()));
    }
}
