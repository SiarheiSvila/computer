package com.epam.computer.control;

import com.epam.computer.entity.Computer;
import com.epam.computer.parser.SaxComputerParser;
import com.epam.computer.parser.api.ComputerParser;
import com.epam.computer.validator.api.XmlValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class Director {
   private ComputerParser parser;
   private XmlValidator validator;

   private static final Logger LOGGER = LogManager.getLogger(SaxComputerParser.class);

   public Director(ComputerParser parser, XmlValidator validator){
      this.parser = parser;
      this.validator = validator;
   }

   public List<Computer> createComputerList(String path){
      List<Computer> computerList;

      if(validator.validate(path)){
         computerList = parser.parse(path);
      } else {
         LOGGER.error("Error in validating a document");
         throw new IllegalArgumentException("Error in validating a document");
      }

      return computerList;
   }
}
