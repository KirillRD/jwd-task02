package com.epam.task2.dao;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public interface ApplianceDAO {
	HashSet<Appliance> find(Criteria criteria) throws IOException, SAXException, ParserConfigurationException;
}
