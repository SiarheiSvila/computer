package com.epam.computer.parser;

import com.epam.computer.entity.Computer;
import com.epam.computer.parser.api.ComputerParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxComputerParser implements ComputerParser {
    private static final Logger LOGGER = LogManager.getLogger(SaxComputerParser.class);

    private ComputerHandler computerHandler;
    private XMLReader xmlReader;

    public SaxComputerParser(){
        computerHandler = new ComputerHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(computerHandler);
        } catch (SAXException e) {
            LOGGER.error("Exception creating xml reader", e);
        }
    }

    @Override
    public List<Computer> parse(String xmlFile) {
        try {
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            LOGGER.error("Exception streaming xml reader", e);
        } catch (SAXException e) {
            LOGGER.error("Exception parsing xml file", e);
        }

        return  computerHandler.getComputers();
    }
}
