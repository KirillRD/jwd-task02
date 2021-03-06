package com.epam.task2.service.validation.impl;

import com.epam.task2.constant.POSSIBLE_VALUES;
import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.Laptop;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.ApplianceValidator;

import java.util.List;
import java.util.Map;

/**
 * Class that contains methods for verifying the validity of data for a device of type Laptop
 * @author Kirill Ryabov
 */
public class LaptopValidator extends ApplianceValidator {
    /**
     * Default constructor
     */
    public LaptopValidator() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void isCriteriaValid(Criteria criteria) throws ServiceException {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        for (String key : criteriaAppliance.keySet()) {
            try {
                switch (SearchCriteria.Laptop.valueOf(key)) {
                    case BATTERY_CAPACITY:
                    case MEMORY_ROM:
                    case SYSTEM_MEMORY:
                    case CPU:
                    case DISPLAY_INCHES:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            isPossibleDoubleValue(criteriaAppliance.get(key).get(i));
                        }
                        break;
                    case OS:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            if (!isOSValid(criteriaAppliance.get(key).get(i))) {
                                throw new ServiceException("We don't have \"" + criteriaAppliance.get(key).get(i) + "\" OS");
                            }
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
        Laptop laptop = (Laptop) appliance;
        isPossibleDoubleValue(laptop.getBatteryCapacity());
        isPossibleDoubleValue(laptop.getMemoryROM());
        isPossibleDoubleValue(laptop.getSystemMemory());
        isPossibleDoubleValue(laptop.getCpu());
        isPossibleDoubleValue(laptop.getDisplayInches());
        if (!isOSValid(laptop.getOs())) {
            throw new ServiceException("OS \"" + laptop.getOs() + "\" doesn't exist");
        }
    }

    /**
     * Method returns true if the data is valid or false if not
     * @param value checked OS value
     * @return true or false
     */
    private boolean isOSValid(Object value) {
        for (POSSIBLE_VALUES.OS valueOS : POSSIBLE_VALUES.OS.values()) {
            if (valueOS.name().equals(value.toString().toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
