package com.epam.task2.service;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;

import java.util.HashSet;

/**
 * Interface that implements the behavior of logic for working with data
 * @author Kirill Ryabov
 */
public interface ApplianceService {
	/**
	 * Method that searches and validates appliances with according to criteria
	 * @param criteria contains name of appliance type and HashMap with fields names(keys) and their values(values)
	 * @return HashSet of appliances with according to criteria
	 * @throws ServiceException when exception in service layer
	 */
	HashSet<Appliance> find(Criteria criteria) throws ServiceException;

	/**
	 * Method that adds and validates appliance with all properties
	 * @param appliance single appliance type with all filled fields
	 * @throws ServiceException when exception in service layer
	 */
	void addAppliance(Appliance appliance) throws ServiceException;
}
