package com.epam.task2.service.impl;

import com.epam.task2.dao.ApplianceDAO;
import com.epam.task2.dao.DAOFactory;
import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.exсeption.DAOException;
import com.epam.task2.exсeption.ServiceException;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.validation.Validator;

import java.util.HashSet;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public HashSet<Appliance> find(Criteria criteria) throws ServiceException {
		if (!Validator.criteriaValidator(criteria)) {
			throw new ServiceException();
		}

		HashSet<Appliance> appliances;
		try {
			DAOFactory factory = DAOFactory.getInstance();
			ApplianceDAO applianceDAO = factory.getApplianceDAO();

			appliances = applianceDAO.find(criteria);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return appliances;
	}

	@Override
	public void addAppliance(Appliance appliance) throws ServiceException {
		// TODO добавить валидатор
		//if throw new ServiceException();

		try {
			DAOFactory factory = DAOFactory.getInstance();
			ApplianceDAO applianceDAO = factory.getApplianceDAO();

			applianceDAO.addAppliance(appliance);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
