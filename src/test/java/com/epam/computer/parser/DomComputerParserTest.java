package com.epam.computer.parser;

import com.epam.computer.entity.Computer;
import com.epam.computer.entity.Laptop;
import com.epam.computer.entity.Personal;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomComputerParserTest {
    private static final String PATH = "./src/test/resources/computer.xml";

    private final static Personal PERSONAL_1 = new Personal("AMD",
            "United States",
            2019,
            550,
            16,
            256,
            "Logiteck");

    private final static Personal PERSONAL_2 = new Personal("Dell",
            "China",
            2016,
            700,
            32,
            128,
            "Dialog");

    private final static Laptop LAPTOP = new Laptop("HP",
            "Spain",
            2017,
            320,
            4,
            64,
            2.4,
            14.1);

    private final static List<Computer> EXPECTED_LIST = new ArrayList<>(Arrays.asList(LAPTOP, PERSONAL_1, PERSONAL_2));

    @Test
    public void testDomParser() {
        //given
        DomComputerParser parser = new DomComputerParser();

        //when
        List<Computer> actual = parser.parse(PATH);

        //then
        Assert.assertEquals(EXPECTED_LIST, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDomParserNoSuchFile() {
        //given
        DomComputerParser parser = new DomComputerParser();

        //when
        List<Computer> actual = parser.parse(" ");

        //then
    }
}
