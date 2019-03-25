package com.epam.computer.validator;

import com.epam.computer.validator.api.XmlValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

import java.io.IOException;

public class SaxValidator implements XmlValidator {
    private final static String XSD_PATH = "./src/main/resources/computer.xsd";
    private static final Logger LOGGER = LogManager.getLogger(SaxValidator.class);

    @Override
    public boolean validate(String xmlPath){
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);

        getClass().getClassLoader().getResourceAsStream(XSD_PATH);

        boolean isValid = true;

        try {
            Schema schema = factory.newSchema(new File((XSD_PATH)));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
        } catch (SAXException e) {
            isValid = false;
            LOGGER.error("SAXException", e);
        } catch (IOException e) {
            isValid = false;
            LOGGER.error("IOException", e);
        }

        return isValid;
    }
}
