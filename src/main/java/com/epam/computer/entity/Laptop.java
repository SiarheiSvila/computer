package com.epam.computer.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Personal", propOrder = {
        "origin", "year", "price", "RAM", "ROM", "weight", "diagonal"
})

public class Laptop extends Computer{
    @XmlElement(required = true)
    private double weight;

    @XmlElement(required = true)
    private double diagonal;

    public Laptop(double weight, double diagonal) {
        this.weight = weight;
        this.diagonal = diagonal;
    }

    public Laptop() {
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
}
