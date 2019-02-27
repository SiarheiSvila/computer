package com.epam.computer.parsers;

import com.epam.computer.enumParser.ParserEnum;

import java.io.InputStream;

public abstract class ComputerParser {
    public abstract void parse(InputStream input);

    public void writeTitle() {
        System.out.println("\n\nComputers: ");
    }

    public void writePersonalStart(){
        writeComputerTypeStart();
        System.out.println("Personal computer\n");
    }

    public void writeLaptopStart(){
        writeComputerTypeStart();
        System.out.println("Laptop\n");
    }

    public void writeComputerTypeStart() {
        System.out.print("   Type: ");
    }

    public void writeComputerTypeEnd() {
        System.out.println();
    }

    public void writeComputerFeatureStart(String name) {
        switch (ParserEnum.valueOf(name.toUpperCase())){
            case NAME:System.out.print("     Name: ");
                break;

            case ORIGIN:
                System.out.print("     Producer country: ");
                break;
            case YEAR:
                System.out.print("     Year of issue: ");
                break;
            case PRICE:
                System.out.print("     Price: ");
                break;
            case RAM:
                System.out.print("     RAM GB: ");
                break;
            case ROM:
                System.out.print("     ROM GB: ");
                break;
            case KEYBOARD_PRODUCER:
                System.out.print("     Name of keyboard producer: ");
                break;
            case WEIGHT:
                System.out.print("     Weight: ");
                break;
            case DIAGONAL:
                System.out.print("     Diagonal in inches: ");
                break;
        }
    }

    public void writeComputerFeatureEnd() {
        System.out.println();
    }

    public void writeText(String text) {
        System.out.println(text.trim());
    }
}
