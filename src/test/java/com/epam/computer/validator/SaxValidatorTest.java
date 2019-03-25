package com.epam.computer.validator;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SaxValidatorTest {

    private static SaxValidator xmlValidator;
    private static String validXmlFilePath;
    private static String nonValidXmlFilePath;


    @BeforeClass
    public static void init(){
        xmlValidator = new SaxValidator();
        validXmlFilePath = "./src/test/resources/computer.xml";
        nonValidXmlFilePath = "./src/test/resources/nonvalid.xml";
    }

    @AfterClass
    public static void close(){
        xmlValidator = null;
        validXmlFilePath = null;
        nonValidXmlFilePath = null;
    }

    @Test
    public void testValidateValidFile() {
        boolean actual = xmlValidator.validate(validXmlFilePath);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateNonValidFile() {
        boolean actual = xmlValidator.validate(nonValidXmlFilePath);

        Assert.assertTrue(!actual);
    }

    @Test
    public void testValidateNoSuchFile() {
        boolean actual = xmlValidator.validate(" ");

        Assert.assertTrue(!actual);
    }
}
