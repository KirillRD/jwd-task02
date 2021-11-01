package com.epam.task2.service.impl;

import com.epam.task2.dao.ApplianceDAO;
import com.epam.task2.dao.DAOFactory;
import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.dao.DAOException;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.validation.Validator;

import java.util.HashSet;

/**
 * Implements interface behavior {@link ApplianceService}
 * Class contains logic for working with data
 * @author Kirill Ryabov
 */
public class ApplianceServiceImpl implements ApplianceService{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HashSet<Appliance> find(Criteria criteria) throws ServiceException {
		try {
			Validator.criteriaValidator(criteria);
		} catch (ServiceException e) {
			throw new ServiceException(e);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAppliance(Appliance appliance) throws ServiceException {
		try {
			Validator.newApplianceValidator(appliance);
		} catch (ServiceException e) {
			throw new ServiceException(e);
		}

		try {
			DAOFactory factory = DAOFactory.getInstance();
			ApplianceDAO applianceDAO = factory.getApplianceDAO();

			applianceDAO.addAppliance(appliance);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
