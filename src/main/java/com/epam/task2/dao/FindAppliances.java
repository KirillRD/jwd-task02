package com.epam.task2.dao;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class FindAppliances {
    private FindAppliances() {}

    public static HashSet<Appliance> findAppliances(Map<String, List<Appliance>> appliances, Criteria criteria) {
        HashSet<Appliance> foundAppliances = new HashSet<Appliance>();

        for (String key : appliances.keySet()) {
            for (Appliance appliance : appliances.get(key)) {
                if (appliance.containsCriteria(criteria)) {
                    foundAppliances.add(appliance);
                }
            }
        }

        return foundAppliances;
    }
}
