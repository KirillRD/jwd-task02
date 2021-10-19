package com.epam.task2.dao.impl;

import com.epam.task2.dao.ApplianceDAO;
import com.epam.task2.dao.FileData;
import com.epam.task2.dao.Parser;
import com.epam.task2.entity.*;
import com.epam.task2.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public HashSet<Appliance> find(Criteria criteria) {
		HashSet<Appliance> setOfAppliances = new HashSet<Appliance>();

		FileData fileData = new FileData("e:\\Users\\Kirill\\Programs\\EPAM\\jwd-task02\\src\\main\\resources\\appliances_db.txt");
		String line = fileData.readLine();
		Map<String, Object> applianceData;

		while (fileData.hasNext()) {
			if (line != null) {
				applianceData = Parser.getMapOfCriteria(criteria.getGroupSearchName() ,line);
				if (applianceData != null) {
					boolean isEqual = true;
					for (String key : criteria.getCriteria().keySet()) {
						if (!criteria.getCriteria().get(key).equals(applianceData.get(key))) {
							isEqual = false;
						}
					}
					if (isEqual) {
						switch (criteria.getGroupSearchName()) {
							case "Laptop":
								setOfAppliances.add(new Laptop(applianceData));
								break;
							case "Oven":
								setOfAppliances.add(new Oven(applianceData));
								break;
							case "Refrigerator":
								setOfAppliances.add(new Refrigerator(applianceData));
								break;
							case "Speakers":
								setOfAppliances.add(new Speakers(applianceData));
								break;
							case "TabletPC":
								setOfAppliances.add(new TabletPC(applianceData));
								break;
							case "VacuumCleaner":
								setOfAppliances.add(new VacuumCleaner(applianceData));
								break;
						}
					}
				}
				line = fileData.readLine();
			}
		}
		fileData.close();
		return setOfAppliances;
	}
}
