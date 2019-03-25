package com.epam.computer.director;

import com.epam.computer.control.Director;
import com.epam.computer.entity.Computer;
import com.epam.computer.entity.Laptop;
import com.epam.computer.entity.Personal;
import com.epam.computer.parser.DomComputerParser;
import com.epam.computer.parser.JaxbComputerParser;
import com.epam.computer.parser.SaxComputerParser;
import com.epam.computer.validator.SaxValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DirectorTest {
    private final static String PATH = "./src/test/resources/computer.xml";

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

    private final static List<Computer> EXPECTED_LIST = new ArrayList<>(Arrays.asList(PERSONAL_1, PERSONAL_2, LAPTOP));

    @Test
    public void testCreateComputerListWithSax(){
        //given
        Director director = new Director(new SaxComputerParser(), new SaxValidator());

        SaxValidator validator = Mockito.mock(SaxValidator.class);
        when(validator.validate(anyString())).thenReturn(true);

        SaxComputerParser parser = Mockito.mock(SaxComputerParser.class);
        when(parser.parse(anyString())).thenReturn(EXPECTED_LIST);

        //when
        List<Computer> actual = director.createComputerList(PATH);

        //then
        Assert.assertEquals(EXPECTED_LIST, actual);
    }

    @Test
    public void testCreateComputerListWithJaxb(){
        //given
        Director director = new Director(new JaxbComputerParser(), new SaxValidator());

        SaxValidator validator = Mockito.mock(SaxValidator.class);
        when(validator.validate(anyString())).thenReturn(true);

        JaxbComputerParser parser = Mockito.mock(JaxbComputerParser.class);
        when(parser.parse(anyString())).thenReturn(EXPECTED_LIST);

        //when
        List<Computer> actual = director.createComputerList(PATH);

        //then
        Assert.assertEquals(EXPECTED_LIST, actual);
    }

    @Test
    public void testCreateComputerListWithDom(){
        //given
        Director director = new Director(new DomComputerParser(), new SaxValidator());

        SaxValidator validator = Mockito.mock(SaxValidator.class);
        when(validator.validate(anyString())).thenReturn(true);

        DomComputerParser parser = Mockito.mock(DomComputerParser.class);
        when(parser.parse(anyString())).thenReturn(EXPECTED_LIST);

        //when
        List<Computer> actual = director.createComputerList(PATH);

        //then
        Assert.assertThat(actual, containsInAnyOrder(EXPECTED_LIST.toArray()));
    }
}
