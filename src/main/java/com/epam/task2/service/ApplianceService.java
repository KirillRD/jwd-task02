package com.epam.task2.service;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.exсeption.ServiceException;

import java.util.HashSet;

public interface ApplianceService {
	HashSet<Appliance> find(Criteria criteria) throws ServiceException;

	void addAppliance(Appliance appliance) throws ServiceException;
}
