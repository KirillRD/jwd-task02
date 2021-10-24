package com.epam.task2.service.impl;

import com.epam.task2.dao.ApplianceDAO;
import com.epam.task2.dao.DAOFactory;
import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public HashSet<Appliance> find(Criteria criteria) throws ParserConfigurationException, SAXException, IOException {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		HashSet<Appliance> appliance = applianceDAO.find(criteria);
		
		// you may add your own code here
		
		return appliance;
	}

}

//you may add your own new classes
