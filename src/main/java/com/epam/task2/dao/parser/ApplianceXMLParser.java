package com.epam.task2.dao.parser;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.ApplianceFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ApplianceXMLParser {
    private static final Map<String, List<Appliance>> appliances = new HashMap<String, List<Appliance>>();

    private ApplianceXMLParser() {}

    public static Map<String, List<Appliance>> getAppliances() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();

        XMLParser xmlParser = new XMLParser();
        // TODO путь файла
        String pathToFile = "e:\\Users\\Kirill\\Programs\\EPAM\\jwd-task02\\src\\main\\resources\\appliances_db.xml";
        parser.parse(new File(pathToFile), xmlParser);

        return appliances;
    }

    private static class XMLParser extends DefaultHandler {
        private StringBuffer tagValue;
        private String typeAppliance;
        private Map<String, Object> applianceData;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagValue = new StringBuffer();
            if (qName.equals("appliance")) {
                typeAppliance = attributes.getValue("type");
                applianceData = new HashMap<String, Object>();
            }
            if (!appliances.containsKey(typeAppliance)) {
                appliances.put(typeAppliance, new ArrayList<Appliance>());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            tagValue.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            applianceData.put(qName.toUpperCase().replaceAll("-", "_"), tagValue.toString());
            if (qName.equals("appliance")) {
                appliances.get(typeAppliance).add(ApplianceFactory.createAppliance(typeAppliance, applianceData));
            }
        }
    }
}
