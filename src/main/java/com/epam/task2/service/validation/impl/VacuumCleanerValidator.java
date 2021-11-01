package com.epam.task2.service.validation.impl;

import com.epam.task2.constant.POSSIBLE_VALUES;
import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.VacuumCleaner;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.ApplianceValidator;

import java.util.List;
import java.util.Map;

/**
 * Class that contains methods for verifying the validity of data for a device of type Vacuum cleaner
 * @author Kirill Ryabov
 */
public class VacuumCleanerValidator extends ApplianceValidator {
    /**
     * Default constructor
     */
    public VacuumCleanerValidator() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void isCriteriaValid(Criteria criteria) throws ServiceException {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        for (String key : criteriaAppliance.keySet()) {
            try {
                switch (SearchCriteria.VacuumCleaner.valueOf(key)) {
                    case POWER_CONSUMPTION:
                    case MOTOR_SPEED_REGULATION:
                    case CLEANING_WIDTH:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            isPossibleDoubleValue(criteriaAppliance.get(key).get(i));
                        }
                        break;
                    case FILTER_TYPE:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            if (!isFilterTypeValid(criteriaAppliance.get(key).get(i))) {
                                throw new ServiceException("We don't have \"" + criteriaAppliance.get(key).get(i) + "\" filter type");
                            }
                        }
                        break;
                    case WAND_TYPE:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            if (!isWandTypeValid(criteriaAppliance.get(key).get(i))) {
                                throw new ServiceException("We don't have \"" + criteriaAppliance.get(key).get(i) + "\" wand type");
                            }
                        }
                        break;
                    case BAG_TYPE:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            if (!isBagTypeValid(criteriaAppliance.get(key).get(i))) {
                                throw new ServiceException("We don't have \"" + criteriaAppliance.get(key).get(i) + "\" bag type");
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
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        isPossibleDoubleValue(vacuumCleaner.getPowerConsumption());
        isPossibleDoubleValue(vacuumCleaner.getMotorSpeedRegulation());
        isPossibleDoubleValue(vacuumCleaner.getCleaningWidth());
        if (!isFilterTypeValid(vacuumCleaner.getFilterType())) {
            throw new ServiceException("Filter type \"" + vacuumCleaner.getFilterType() + "\" doesn't exist");
        }
        if (!isWandTypeValid(vacuumCleaner.getWandType())) {
            throw new ServiceException("Wand type \"" + vacuumCleaner.getWandType() + "\" doesn't exist");
        }
        if (!isBagTypeValid(vacuumCleaner.getBagType())) {
            throw new ServiceException("Bag type \"" + vacuumCleaner.getBagType() + "\" doesn't exist");
        }
    }

    /**
     * Method returns true if the data is valid or false if not
     * @param value checked filter type value
     * @return true or false
     */
    private boolean isFilterTypeValid(Object value) {
        for (POSSIBLE_VALUES.FILTER_TYPE valueFilterType : POSSIBLE_VALUES.FILTER_TYPE.values()) {
            if (valueFilterType.name().equals(value.toString().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method returns true if the data is valid or false if not
     * @param value checked wand type value
     * @return true or false
     */
    private boolean isWandTypeValid(Object value) {
        for (POSSIBLE_VALUES.WAND_TYPE valueWandType : POSSIBLE_VALUES.WAND_TYPE.values()) {
            String line = value.toString().toUpperCase().replaceAll("-", "_");
            if (valueWandType.name().equals(line)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method returns true if the data is valid or false if not
     * @param value checked bag type value
     * @return true or false
     */
    private boolean isBagTypeValid(Object value) {
        for (POSSIBLE_VALUES.BAG_TYPE valueBagType : POSSIBLE_VALUES.BAG_TYPE.values()) {
            if (valueBagType.name().equals(value.toString().toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
