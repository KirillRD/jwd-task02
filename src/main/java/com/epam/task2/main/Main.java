package com.epam.task2.main;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.Speakers;
import com.epam.task2.entity.VacuumCleaner;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.exсeption.ServiceException;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.ServiceFactory;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.*;

public class Main {

	public static void main(String[] args) throws ServiceException {
		HashSet<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaVacuumCleaner = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
		criteriaVacuumCleaner.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "A");
		criteriaVacuumCleaner.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "B");
		criteriaVacuumCleaner.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "C");

		appliances = service.find(criteriaVacuumCleaner);

		PrintApplianceInfo.print(appliances);
//		service.addAppliance(new VacuumCleaner(
//				23,
//				"ert",
//				"hhh",
//				"bbbbbbbbb",
//				567,
//				90000
//		));
	}
}
