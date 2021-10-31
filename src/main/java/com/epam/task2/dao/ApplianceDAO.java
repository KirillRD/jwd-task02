package com.epam.task2.dao;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;

import java.util.HashSet;

public interface ApplianceDAO {
	HashSet<Appliance> find(Criteria criteria) throws DAOException;

	void addAppliance(Appliance appliance) throws DAOException;
}
