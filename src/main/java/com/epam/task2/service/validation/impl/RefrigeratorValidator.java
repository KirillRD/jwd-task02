package com.epam.task2.service.validation.impl;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.Refrigerator;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.ApplianceValidator;

import java.util.List;
import java.util.Map;

/**
 * Class that contains methods for verifying the validity of data for a device of type Refrigerator
 * @author Kirill Ryabov
 */
public class RefrigeratorValidator extends ApplianceValidator {
    /**
     * Default constructor
     */
    public RefrigeratorValidator() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void isCriteriaValid(Criteria criteria) throws ServiceException {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        for (String key : criteriaAppliance.keySet()) {
            try {
                switch (SearchCriteria.Refrigerator.valueOf(key)) {
                    case POWER_CONSUMPTION:
                    case WEIGHT:
                    case FREEZER_CAPACITY:
                    case OVERALL_CAPACITY:
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void isApplianceValid(Appliance appliance) throws ServiceException {
        Refrigerator refrigerator = (Refrigerator) appliance;
        isPossibleDoubleValue(refrigerator.getPowerConsumption());
        isPossibleDoubleValue(refrigerator.getWeight());
        isPossibleDoubleValue(refrigerator.getFreezerCapacity());
        isPossibleDoubleValue(refrigerator.getOverallCapacity());
        isPossibleDoubleValue(refrigerator.getHeight());
        isPossibleDoubleValue(refrigerator.getWidth());
    }
}
