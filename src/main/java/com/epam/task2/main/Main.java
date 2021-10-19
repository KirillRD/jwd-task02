package com.epam.task2.main;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.ServiceFactory;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		HashSet<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(SearchCriteria.Oven.CAPACITY.toString(), 33);
		criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 60);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);
	}
}
