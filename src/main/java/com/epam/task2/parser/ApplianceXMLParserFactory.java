package com.epam.task2.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public final class ApplianceXMLParserFactory {
    private static final ApplianceXMLParserFactory instance = new ApplianceXMLParserFactory();

    private final ApplianceXMLParser handler = new ApplianceXMLParser();

    private ApplianceXMLParserFactory() {}

    public ApplianceXMLParser getHandler(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();

            parser.parse(new File(pathToFile), handler);
        } catch (ParserConfigurationException parserConfigurationException) {
            throw new ParserConfigurationException();
        } catch (SAXException saxException) {
            throw new SAXException();
        } catch (IOException ioException) {
            throw new IOException();
        }
        return handler;
    }

    public static ApplianceXMLParserFactory getInstance() {
        return instance;
    }
}
