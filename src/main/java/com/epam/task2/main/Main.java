package com.epam.task2.main;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ApplianceService;
import com.epam.task2.service.ServiceFactory;
import com.epam.task2.entity.criteria.SearchCriteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		HashSet<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaLaptop = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
		criteriaLaptop.add(SearchCriteria.Laptop.CPU.toString(), 2.2);

		appliances = service.find(criteriaLaptop);

		PrintApplianceInfo.print(appliances);
	}
}
