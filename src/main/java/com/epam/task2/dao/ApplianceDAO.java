package com.epam.task2.dao;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;

import java.util.HashSet;

/**
 * Interface that contains behaviors for working with data
 * @author Kirill Ryabov
 */
public interface ApplianceDAO {
	/**
	 * Method that searches appliances with according to criteria
	 * @param criteria contains name of appliance type and HashMap with fields names(keys) and their values(values)
	 * @return HashSet of appliances with according to criteria
	 * @throws DAOException when exception in dao layer
	 */
	HashSet<Appliance> find(Criteria criteria) throws DAOException;

	/**
	 * Method that adds appliance with all properties
	 * @param appliance single appliance type with all filled fields
	 * @throws DAOException when exception in dao layer
	 */
	void addAppliance(Appliance appliance) throws DAOException;
}
