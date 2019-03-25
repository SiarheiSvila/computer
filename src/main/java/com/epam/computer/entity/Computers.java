package com.epam.computer.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "computers", namespace="http://www.examle.com/computers")
@XmlType(name = "", namespace="http://www.examle.com/computers")
public class Computers {

    @XmlElementRefs(value = {@XmlElementRef (name = "personal", type = Personal.class, namespace = "http://www.examle.com/computers"),
    @XmlElementRef(name = "laptop", type = Laptop.class, namespace = "http://www.examle.com/computers")})
    private List<Computer> list = new ArrayList<>();

    public Computers(List<Computer> list) {
        this.list = list;
    }

    public Computers() {
        super();
    }

    public boolean add(Computer st) {
        return list.add(st);
    }

    public List<Computer> getList(){
        return list;
    }

    @Override
    public String toString() {
        return "Computers [list=" + list + "]";
    }
}
