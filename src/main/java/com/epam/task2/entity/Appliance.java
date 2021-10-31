package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;

public abstract class Appliance {
    public abstract boolean containsCriteria(Criteria criteria);

    protected final boolean checkFieldsByCriteria(Criteria criteria, Map<String, Double> doubleFields, Map<String, String> stringFields) {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        boolean equal = !criteriaAppliance.isEmpty();

        for (String key : criteriaAppliance.keySet()) {
            boolean fieldContains = !equal;
            for (int i = 0; i < criteriaAppliance.get(key).size() && !fieldContains; i++) {
                if (doubleFields.containsKey(key)) {
                    double field = Double.parseDouble(criteriaAppliance.get(key).get(i).toString());
                    fieldContains = doubleFields.get(key) == field;
                } else if (stringFields.containsKey(key)) {
                    String field = (String) criteriaAppliance.get(key).get(i);
                    fieldContains = stringFields.get(key).equals(field);
                }
            }
            equal = fieldContains && equal;
        }

        return equal;
    }
}
