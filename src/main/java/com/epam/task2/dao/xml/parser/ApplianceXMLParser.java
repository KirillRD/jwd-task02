package com.epam.task2.dao.xml.parser;

import com.epam.task2.dao.xml.constant.APPLIANCE_TYPES_XML;
import com.epam.task2.entity.Appliance;
import com.epam.task2.dao.factory.ApplianceFactory;
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

    public static Map<String, List<Appliance>> getAppliances(File dbFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();

        XMLParser xmlParser = new XMLParser();
        parser.parse(dbFile, xmlParser);

        return appliances;
    }

    private static class XMLParser extends DefaultHandler {
        private StringBuffer tagValue;
        private String typeAppliance;
        private Map<String, Object> applianceData;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagValue = new StringBuffer();
            if (APPLIANCE_TYPES_XML.getApplianceType(qName) != null) {
                typeAppliance = APPLIANCE_TYPES_XML.getApplianceType(qName);
                applianceData = new HashMap<String, Object>();
                if (!appliances.containsKey(typeAppliance)) {
                    appliances.put(typeAppliance, new ArrayList<Appliance>());
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            tagValue.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            applianceData.put(qName.toUpperCase().replaceAll("-", "_"), tagValue.toString());
            if (typeAppliance.equals(APPLIANCE_TYPES_XML.getApplianceType(qName))) {
                appliances.get(typeAppliance).add(ApplianceFactory.createAppliance(typeAppliance, applianceData));
            }
        }
    }
}
