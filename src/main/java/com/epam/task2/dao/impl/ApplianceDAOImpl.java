package com.epam.task2.dao.impl;

import com.epam.task2.dao.ApplianceDAO;
import com.epam.task2.dao.FindAppliances;
import com.epam.task2.entity.*;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.parser.ApplianceXMLParser;
import com.epam.task2.parser.ApplianceXMLParserFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public HashSet<Appliance> find(Criteria criteria) throws IOException, SAXException, ParserConfigurationException {
		ApplianceXMLParser applianceXMLParser;
		try {
			applianceXMLParser = ApplianceXMLParserFactory.getInstance().getHandler("e:\\Users\\Kirill\\Programs\\EPAM\\jwd-task02\\src\\main\\resources\\appliances_db.xml");
		} catch (IOException ioException) {
			throw new IOException();
		} catch (SAXException saxException) {
			throw new SAXException();
		} catch (ParserConfigurationException parserConfigurationException) {
			throw new ParserConfigurationException();
		}

		Map<String, List<Appliance>> appliances = applianceXMLParser.getAppliances();

		return FindAppliances.findAppliances(appliances, criteria);
	}
}
