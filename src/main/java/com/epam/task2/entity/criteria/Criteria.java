package com.epam.task2.entity.criteria;

import java.util.*;

/**
 * Class contains criteria for finding
 * @author Kirill Ryabov
 */
public class Criteria {
	/**
	 * Field that appliance type for finding
	 */
	private String typeAppliance;

	/**
	 * HashMap with fields names(keys) and their values in ArrayList(values) for finding
	 */
	private Map<String, List<Object>> criteria = new HashMap<String, List<Object>>();

	/**
	 * Constructor for creating criteria
	 * @param typeAppliance for finding
	 */
	public Criteria(String typeAppliance) {
		this.typeAppliance = typeAppliance;
	}

	/**
	 * Method returns appliance type for finding
	 * @return appliance type for finding
	 */
	public String getTypeAppliance() {
		return typeAppliance;
	}

	/**
	 * Method adds a field value for finding in ArrayList in HashMap
	 * @param searchCriteria name field for finding
	 * @param value value field for finding
	 */
	public void add(String searchCriteria, Object value) {
		if (!criteria.containsKey(searchCriteria)) {
			criteria.put(searchCriteria, new ArrayList<Object>());
		}
		criteria.get(searchCriteria).add(value.toString());
	}

	/**
	 * Method returns HashMap with fields names(keys) and their values in ArrayList(values) for finding
	 * @return HashMap with fields names(keys) and their values in ArrayList(values) for finding
	 */
	public Map<String, List<Object>> getCriteria() {
		return criteria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Criteria criteria1 = (Criteria) o;
		return Objects.equals(typeAppliance, criteria1.typeAppliance) && Objects.equals(criteria, criteria1.criteria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(typeAppliance, criteria);
	}

	@Override
	public String toString() {
		return "Criteria{" +
				"typeAppliance='" + typeAppliance + '\'' +
				", criteria=" + criteria +
				'}';
	}
}
