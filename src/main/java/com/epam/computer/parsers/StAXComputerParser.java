package com.epam.computer.parsers;

import com.epam.computer.enumParser.ParserEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXComputerParser extends ComputerParser {
    public void parse(InputStream input) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void process(XMLStreamReader reader) throws XMLStreamException{
        String name;

        while(reader.hasNext()) {
            //defyning type of read element
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();

                    switch (ParserEnum.valueOf(name.toUpperCase())) {
                        case COMPUTERS:
                            writeTitle();
                            break;

                        case PERSONAL:
                            writePersonalStart();
                            break;

                        case LAPTOP:
                            writeLaptopStart();
                            break;

                        default:
                            writeComputerFeatureStart(name);
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();

                switch (ParserEnum.valueOf(name.toUpperCase())) {
                    case PERSONAL:
                        writeComputerTypeEnd();
                        break;

                    case LAPTOP:
                        writeComputerTypeEnd();
                        break;

                    default:
                        writeComputerFeatureEnd();
                        break;
                }
                break;

                case XMLStreamConstants.CHARACTERS:
                    writeText(reader.getText());
                    break;

                default:
                    break;
            }

        }
    }
}
