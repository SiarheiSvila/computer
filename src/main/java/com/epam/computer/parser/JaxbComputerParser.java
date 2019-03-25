package com.epam.computer.parser;

import com.epam.computer.entity.Computer;
import com.epam.computer.entity.Computers;
import com.epam.computer.parser.api.ComputerParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.*;
import java.io.File;
import java.util.List;

public class JaxbComputerParser implements ComputerParser {
    private static final Logger LOGGER = LogManager.getLogger(SaxComputerParser.class);
    public JaxbComputerParser() {
    }

    @Override
    public List<Computer> parse(String path) {
        Computers computers = new Computers();



        try {
            JAXBContext jc = JAXBContext.newInstance(Computers.class);
            Unmarshaller u = jc.createUnmarshaller();
            computers = (Computers) u.unmarshal(new File(path));
        } catch (JAXBException e) {
            LOGGER.error("JaxbException", e);
            throw new IllegalArgumentException("Error. JAXBException", e);
        }

        return computers.getList();
    }
}
