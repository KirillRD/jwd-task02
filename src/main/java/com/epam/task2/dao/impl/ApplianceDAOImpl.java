package com.epam.task2.dao.impl;

import com.epam.task2.dao.ApplianceDAO;
import com.epam.task2.dao.xml.parser.ApplianceXMLParser;
import com.epam.task2.dao.xml.writer.ApplianceXMLWriter;
import com.epam.task2.entity.*;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.dao.DAOException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Implements interface behavior {@link ApplianceDAO}
 * Class for working with data
 * @author Kirill Ryabov
 */
public class ApplianceDAOImpl implements ApplianceDAO{
	{
		ClassLoader classLoader = getClass().getClassLoader();
		dbFile = new File(classLoader.getResource("appliances_db.xml").getFile());
	}

	/**
	 * Field that contains the data file
	 */
	private final File dbFile;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HashSet<Appliance> find(Criteria criteria) throws DAOException {
		HashSet<Appliance> foundAppliances = new HashSet<Appliance>();

		try {
			Map<String, List<Appliance>> appliances = ApplianceXMLParser.getAppliances(dbFile);

			for (String key : appliances.keySet()) {
				for (Appliance appliance : appliances.get(key)) {
					if (appliance.containsCriteria(criteria)) {
						foundAppliances.add(appliance);
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new DAOException(e);
		}

		return foundAppliances;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAppliance(Appliance appliance) throws DAOException {
		try {
			ApplianceXMLWriter.saveAppliance(appliance, dbFile);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			throw new DAOException(e);
		}
	}
}
