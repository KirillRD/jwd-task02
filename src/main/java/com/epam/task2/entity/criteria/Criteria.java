package com.epam.task2.entity.criteria;

import java.util.*;

public class Criteria {

	private String typeAppliance;
	private Map<String, List<Object>> criteria = new HashMap<String, List<Object>>();

	public Criteria(String typeAppliance) {
		this.typeAppliance = typeAppliance;
	}
	
	public String getTypeAppliance() {
		return typeAppliance;
	}

	public void add(String searchCriteria, Object value) {
		if (!criteria.containsKey(searchCriteria)) {
			criteria.put(searchCriteria, new ArrayList<Object>());
		}
		criteria.get(searchCriteria).add(value.toString());
	}

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
