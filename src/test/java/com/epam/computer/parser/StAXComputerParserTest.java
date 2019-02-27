package com.epam.computer.parser;

import com.epam.computer.parsers.ComputerParser;
import com.epam.computer.parsers.StAXComputerParser;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StAXComputerParserTest {
    @Test
    public void test() throws FileNotFoundException {
        ComputerParser parser = new StAXComputerParser();

        InputStream input = new FileInputStream("./src/test/resources/computer.xml");
        parser.parse(input);
    }
}
