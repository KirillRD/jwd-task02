package com.epam.task2.service.validation.impl;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.Oven;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.ApplianceValidator;

import java.util.List;
import java.util.Map;

public class OvenValidator extends ApplianceValidator {
    public OvenValidator() {}

    @Override
    public void isCriteriaValid(Criteria criteria) throws ServiceException {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        for (String key : criteriaAppliance.keySet()) {
            try {
                switch (SearchCriteria.Oven.valueOf(key)) {
                    case POWER_CONSUMPTION:
                    case WEIGHT:
                    case CAPACITY:
                    case DEPTH:
                    case HEIGHT:
                    case WIDTH:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            isPossibleDoubleValue(criteriaAppliance.get(key).get(i));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                throw new ServiceException("Criteria don't have \"" + key + "\" field");
            }
        }
    }

    @Override
    public void isApplianceValid(Appliance appliance) throws ServiceException {
        Oven oven = (Oven) appliance;
        isPossibleDoubleValue(oven.getPowerConsumption());
        isPossibleDoubleValue(oven.getWeight());
        isPossibleDoubleValue(oven.getCapacity());
        isPossibleDoubleValue(oven.getDepth());
        isPossibleDoubleValue(oven.getHeight());
        isPossibleDoubleValue(oven.getDepth());
    }
}
