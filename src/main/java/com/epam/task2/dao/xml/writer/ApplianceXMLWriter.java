package com.epam.task2.dao.xml.writer;

import com.epam.task2.dao.xml.constant.APPLIANCE_TYPES_XML;
import com.epam.task2.entity.*;
import com.epam.task2.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public final class ApplianceXMLWriter {
    private static Document document;
    private static Element newAppliance;

    private ApplianceXMLWriter() {}

    private static void setElement(String nameField, String valueField) {
        Element element = document.createElement(nameField.toLowerCase().replaceAll("_", "-"));
        element.setTextContent(valueField.toLowerCase().replaceAll("_", "-"));
        newAppliance.appendChild(element);
    }

    public static void saveAppliance(Appliance appliance, File dbFile) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(dbFile);

        Element appliances = (Element) document.getElementsByTagName("apl:appliances").item(0);

        newAppliance = document.createElement(APPLIANCE_TYPES_XML.getApplianceTypeXML(appliance.getClass().getSimpleName()));

        switch(APPLIANCE_TYPES_XML.valueOf(appliance.getClass().getSimpleName())) {
            case Laptop:
                Laptop laptop = (Laptop) appliance;
                setElement(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), String.valueOf(laptop.getBatteryCapacity()));
                setElement(SearchCriteria.Laptop.OS.toString(), String.valueOf(laptop.getOs()));
                setElement(SearchCriteria.Laptop.MEMORY_ROM.toString(), String.valueOf(laptop.getMemoryROM()));
                setElement(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), String.valueOf(laptop.getSystemMemory()));
                setElement(SearchCriteria.Laptop.CPU.toString(), String.valueOf(laptop.getCpu()));
                setElement(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), String.valueOf(laptop.getDisplayINCHES()));
                break;
            case Oven:
                Oven oven = (Oven) appliance;
                setElement(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), String.valueOf(oven.getPowerConsumption()));
                setElement(SearchCriteria.Oven.WEIGHT.toString(), String.valueOf(oven.getWeight()));
                setElement(SearchCriteria.Oven.CAPACITY.toString(), String.valueOf(oven.getCapacity()));
                setElement(SearchCriteria.Oven.DEPTH.toString(), String.valueOf(oven.getDepth()));
                setElement(SearchCriteria.Oven.HEIGHT.toString(), String.valueOf(oven.getHeight()));
                setElement(SearchCriteria.Oven.WIDTH.toString(), String.valueOf(oven.getWidth()));
                break;
            case Refrigerator:
                Refrigerator refrigerator = (Refrigerator) appliance;
                setElement(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), String.valueOf(refrigerator.getPowerConsumption()));
                setElement(SearchCriteria.Refrigerator.WEIGHT.toString(), String.valueOf(refrigerator.getWeight()));
                setElement(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), String.valueOf(refrigerator.getFreezerCapacity()));
                setElement(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), String.valueOf(refrigerator.getOverallCapacity()));
                setElement(SearchCriteria.Refrigerator.HEIGHT.toString(), String.valueOf(refrigerator.getHeight()));
                setElement(SearchCriteria.Refrigerator.WIDTH.toString(), String.valueOf(refrigerator.getWidth()));
                break;
            case Speakers:
                Speakers speakers = (Speakers) appliance;
                setElement(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), String.valueOf(speakers.getPowerConsumption()));
                setElement(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), String.valueOf(speakers.getNumberOfSpeakers()));
                setElement(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), String.valueOf(speakers.getFrequencyRange()));
                setElement(SearchCriteria.Speakers.CORD_LENGTH.toString(), String.valueOf(speakers.getCordLength()));
                break;
            case TabletPC:
                TabletPC tabletPC = (TabletPC) appliance;
                setElement(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), String.valueOf(tabletPC.getBatteryCapacity()));
                setElement(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), String.valueOf(tabletPC.getDisplayINCHES()));
                setElement(SearchCriteria.TabletPC.MEMORY_ROM.toString(), String.valueOf(tabletPC.getMemoryROM()));
                setElement(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), String.valueOf(tabletPC.getFlashMemoryCapacity()));
                setElement(SearchCriteria.TabletPC.COLOR.toString(), String.valueOf(tabletPC.getColor()));
                break;
            case VacuumCleaner:
                VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
                setElement(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), String.valueOf(vacuumCleaner.getPowerConsumption()));
                setElement(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), String.valueOf(vacuumCleaner.getFilterType()));
                setElement(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), String.valueOf(vacuumCleaner.getBagType()));
                setElement(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), String.valueOf(vacuumCleaner.getWandType()));
                setElement(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), String.valueOf(vacuumCleaner.getMotorSpeedRegulation()));
                setElement(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), String.valueOf(vacuumCleaner.getCleaningWidth()));
                break;
        }

        appliances.appendChild(newAppliance);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(dbFile);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(domSource, streamResult);
    }
}
