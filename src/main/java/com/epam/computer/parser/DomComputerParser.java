package com.epam.computer.parser;

import com.epam.computer.entity.Computer;
import com.epam.computer.entity.Laptop;
import com.epam.computer.entity.Personal;
import com.epam.computer.parser.api.ComputerParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DomComputerParser implements ComputerParser {

    private List<Computer> computerList;
    private DocumentBuilder docBuilder;

    private static final Logger LOGGER = LogManager.getLogger(SaxComputerParser.class);


    public DomComputerParser() {
        this.computerList = new ArrayList<>();
            // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Error. Parser Configuration Exception", e);
            throw new IllegalArgumentException("Parser Configuration Exception", e);
        }
    }

    @Override
    public List<Computer> parse(String fileName) {
        try {
            Document doc = docBuilder.parse(fileName);
            NodeList laptopList = doc.getElementsByTagName("laptop");
            NodeList personalList = doc.getElementsByTagName("personal");

            for(int i=0; i<laptopList.getLength(); i++){
                Node laptopNode = laptopList.item(i);
                if(laptopNode.getNodeType() == Node.ELEMENT_NODE){
                    Element laptopElement = (Element) laptopNode;

                    String name = laptopElement.getAttribute("name");

                    NodeList informationList = laptopElement.getChildNodes();

                    computerList.add(createComputer(new Laptop(), informationList, name));
                }
            }

            for (int i=0; i<personalList.getLength(); i++){
                Node personalNode = personalList.item(i);
                if(personalNode.getNodeType() == Node.ELEMENT_NODE){
                    Element personalElement = (Element) personalNode;

                    String name = personalElement.getAttribute("name");

                    NodeList informationList = personalElement.getChildNodes();

                    computerList.add(createComputer(new Personal(), informationList, name));
                }
            }

        } catch (SAXException e) {
            LOGGER.error("Error. Sax Exception", e);
            throw new IllegalArgumentException("Sax Exception", e);
        } catch (IOException e) {
            LOGGER.error("Error. IO Exception", e);
            throw new IllegalArgumentException("IO Exception", e);
        }

        return computerList;
    }


    private Computer createComputer(Computer computerType, NodeList informationList, String name){
        Computer computer;

        if(computerType instanceof Personal) {
            computer = new Personal();
        } else {
            computer = new Laptop();
        }
        computer.setName(name);

        for (int j=0; j<informationList.getLength(); j++){
            Node informationNode = informationList.item(j);

            if(informationNode.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) informationNode;

                if(j==1) {
                    String origin = element.getTextContent();
                    computer.setOrigin(origin);
                } else if(j==3) {
                    int year = Integer.parseInt(element.getTextContent());
                    computer.setYear(year);
                } else if (j==5) {
                    double price= Double.parseDouble(element.getTextContent());
                    computer.setPrice(price);
                } else if (j==7) {
                    int RAM= Integer.parseInt(element.getTextContent());
                    computer.setRAM(RAM);
                } else if (j==9) {
                    int ROM= Integer.parseInt(element.getTextContent());
                    computer.setROM(ROM);
                } else if (j==11) {
                    if (computerType instanceof Personal) {
                        String keyboard_producer = element.getTextContent();

                        ((Personal)computer).setKeyboard_producer(keyboard_producer);
                    } else {
                        double weight = Double.parseDouble(element.getTextContent());

                        ((Laptop)computer).setWeight(weight);
                    }
                } else if (j==13 && computerType instanceof Laptop) {
                    double diagonal = Double.parseDouble(element.getTextContent());

                    ((Laptop)computer).setDiagonal(diagonal);
                }

            }
        }
        return computer;
    }


}
