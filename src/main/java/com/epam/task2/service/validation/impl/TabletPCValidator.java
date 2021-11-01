package com.epam.task2.service.validation.impl;

import com.epam.task2.constant.POSSIBLE_VALUES;
import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.TabletPC;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.ApplianceValidator;

import java.util.List;
import java.util.Map;

/**
 * Class that contains methods for verifying the validity of data for a device of type Tablet PC
 * @author Kirill Ryabov
 */
public class TabletPCValidator extends ApplianceValidator {
    /**
     * Default constructor
     */
    public TabletPCValidator() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void isCriteriaValid(Criteria criteria) throws ServiceException {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        for (String key : criteriaAppliance.keySet()) {
            try {
                switch (SearchCriteria.TabletPC.valueOf(key)) {
                    case BATTERY_CAPACITY:
                    case DISPLAY_INCHES:
                    case MEMORY_ROM:
                    case FLASH_MEMORY_CAPACITY:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            isPossibleDoubleValue(criteriaAppliance.get(key).get(i));
                        }
                        break;
                    case COLOR:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            if (!isColorValid(criteriaAppliance.get(key).get(i))) {
                                throw new ServiceException("We don't have \"" + criteriaAppliance.get(key).get(i) + "\" color");
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
        TabletPC tabletPC = (TabletPC) appliance;
        isPossibleDoubleValue(tabletPC.getBatteryCapacity());
        isPossibleDoubleValue(tabletPC.getDisplayInches());
        isPossibleDoubleValue(tabletPC.getMemoryROM());
        isPossibleDoubleValue(tabletPC.getFlashMemoryCapacity());
        if (!isColorValid(tabletPC.getColor())) {
            throw new ServiceException("Color \"" + tabletPC.getColor() + "\" doesn't exist");
        }
    }

    /**
     * Method returns true if the data is valid or false if not
     * @param value checked color value
     * @return true or false
     */
    private boolean isColorValid(Object value) {
        for (POSSIBLE_VALUES.COLOR valueCOLOR : POSSIBLE_VALUES.COLOR.values()) {
            if (valueCOLOR.name().equals(value.toString().toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
