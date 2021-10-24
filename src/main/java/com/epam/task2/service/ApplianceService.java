package com.epam.task2.service;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public interface ApplianceService {
	HashSet<Appliance> find(Criteria criteria) throws ParserConfigurationException, SAXException, IOException;
}
