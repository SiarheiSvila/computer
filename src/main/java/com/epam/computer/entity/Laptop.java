package com.epam.computer.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (namespace="http://www.examle.com/computers", name = "laptop")
@XmlType (name="Laptop", namespace="http://www.examle.com/computers")

public class Laptop extends Computer{

    @XmlElement(name = "weight", namespace = "http://www.examle.com/computers")
    private double weight;

    @XmlElement(name = "diagonal", namespace = "http://www.examle.com/computers")
    private double diagonal;

    public Laptop(double weight, double diagonal) {
        this.weight = weight;
        this.diagonal = diagonal;
    }

    public Laptop() {
    }

    public Laptop(String name, String origin, int year, double price, int RAM, int ROM, double weight, double diagonal) {
        super(name, origin, year, price, RAM, ROM);
        this.weight = weight;
        this.diagonal = diagonal;
    }

    public Laptop(Computer computer){
        super(computer.getName(), computer.getOrigin(), computer.getYear(),
                computer.getPrice(), computer.getRAM(), computer.getROM());
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "weight=" + weight +
                ", diagonal=" + diagonal +
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

        Laptop laptop = (Laptop) o;

        if (weight != laptop.weight) {
            return false;
        }
        if (diagonal != laptop.diagonal) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(17*super.hashCode() + 4*weight + 71*diagonal);
    }
}
