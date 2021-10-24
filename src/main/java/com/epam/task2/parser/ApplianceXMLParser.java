package com.epam.task2.parser;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.ApplianceFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplianceXMLParser extends DefaultHandler {
    private Map<String, List<Appliance>> appliances = new HashMap<String, List<Appliance>>();
    private StringBuffer tagValue;
    private String typeAppliance;
    private Map<String, Object> applianceData;

    ApplianceXMLParser() {}

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
        applianceData.put(qName.toUpperCase(), tagValue.toString());
        if (qName.equals("appliance")) {
            appliances.get(typeAppliance).add(ApplianceFactory.createAppliance(typeAppliance, applianceData));
        }
    }

    public Map<String, List<Appliance>> getAppliances() {
        return appliances;
    }
}
