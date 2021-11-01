package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;

/**
 * Abstract class that describes the behavior of the appliance
 * @author Kirill Ryabov
 */
public abstract class Appliance {
    /**
     * Method checks whether the criteria are contained in this appliance
     * @param criteria contains name of appliance type and HashMap with fields names(keys) and their values(values)
     * @return true if contains or false if not contains
     */
    public abstract boolean containsCriteria(Criteria criteria);

    /**
     * Method checks whether the criteria are contained in fields in this appliance
     * @param criteria contains name of appliance type and HashMap with fields names(keys) and their values(values)
     * @param doubleFields HashMap of double fields with name and value
     * @param stringFields HashMap of string fields with name and value
     * @return true if contains or false if not contains
     */
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
