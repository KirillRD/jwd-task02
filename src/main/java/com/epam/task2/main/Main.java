package com.epam.task2.main;

import com.epam.task2.entity.*;
import com.epam.task2.entity.criteria.*;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.ServiceFactory;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws ServiceException {
		HashSet<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

//		Criteria criteriaLaptop = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
//		criteriaLaptop.add(SearchCriteria.Laptop.OS.toString(), "linux");
//		criteriaLaptop.add(SearchCriteria.Laptop.OS.toString(), "windows");
//		criteriaLaptop.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 8000);

//		Criteria criteriaLaptop = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
//		criteriaLaptop.add(SearchCriteria.Laptop.OS.toString(), "linux");
//		criteriaLaptop.add(SearchCriteria.Laptop.OS.toString(), "windows");
//		criteriaLaptop.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 8000);
//
//		appliances = service.find(criteriaLaptop);
//
//		PrintApplianceInfo.print(appliances);


//		Criteria criteriaSpeakers = new Criteria(SearchCriteria.Speakers.class.getSimpleName());
//		criteriaSpeakers.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 2);
//		criteriaSpeakers.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 3);
//		criteriaSpeakers.add(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), "3-4");
//
//		appliances = service.find(criteriaSpeakers);
//
//		PrintApplianceInfo.print(appliances);


		service.addAppliance(new VacuumCleaner(
				12,
				"A",
				"y2",
				"all-in-one",
				567,
				34
		));

//		service.addAppliance(new VacuumCleaner());
	}
}
