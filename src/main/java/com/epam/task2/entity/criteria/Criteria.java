package com.epam.task2.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Criteria {

	private String typeAppliance;
	private Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String typeAppliance) {
		this.typeAppliance = typeAppliance;
	}
	
	public String getTypeAppliance() {
		return typeAppliance;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value.toString());
	}

	public Map<String, Object> getCriteria() {
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
}
