package com.epam.computer.parser;

import com.epam.computer.computerenum.ElementEnum;
import com.epam.computer.entity.Computer;
import com.epam.computer.entity.Laptop;
import com.epam.computer.entity.Personal;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class ComputerHandler extends DefaultHandler {

    private List<Computer> computers;
    private Computer current = null;
    private ElementEnum currentEnum = null;
    private EnumSet<ElementEnum> withText;

    public ComputerHandler() {
        computers = new ArrayList<>();
        withText = EnumSet.range(ElementEnum.NAME, ElementEnum.DIAGONAL);
    }

    public List<Computer> getComputers() {
        return computers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("personal".equals(localName))
        {
            current = new Personal();
            current.setName(attrs.getValue(0));
        }
        if("laptop".equals(localName)) {
            current = new Laptop();
            current.setName(attrs.getValue(0));

        } else {
            ElementEnum temp;
            if(localName.equals("keyboard-producer")){
                temp = ElementEnum.valueOf("KEYBOARD_PRODUCER");
            }
            else {
                temp = ElementEnum.valueOf(localName.toUpperCase());
            }
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("laptop".equals(localName) || "personal".equals(localName)) {
            computers.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case ORIGIN:
                    current.setOrigin(s);
                    break;

                case YEAR:
                    current.setYear(Integer.parseInt(s));
                    break;

                case PRICE:
                    current.setPrice(Double.parseDouble(s));
                    break;

                case RAM:
                    current.setRAM(Integer.parseInt(s));
                    break;

                case ROM:
                    current.setROM(Integer.parseInt(s));
                    break;

                case KEYBOARD_PRODUCER:
                    ((Personal) current).setKeyboard_producer(s);
                    break;

                case WEIGHT:
                    ((Laptop) current).setWeight(Double.parseDouble(s));
                    break;

                case DIAGONAL:
                    ((Laptop) current).setDiagonal(Double.parseDouble(s));
                    break;

                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}


