package com.epam.task2.service.validation;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ServiceException;

/**
 * Abstract class that describes the behavior of the appliance validator
 * @author Kirill Ryabov
 */
public abstract class ApplianceValidator {
    /**
     * Method throws an exception when the data is not valid
     * @param criteria checked criteria that contains name of appliance type and HashMap with fields names(keys) and their values(values)
     * @throws ServiceException when data isn't valid
     */
    public abstract void isCriteriaValid(Criteria criteria) throws ServiceException;

    /**
     * Method throws an exception when the data is not valid
     * @param appliance checked single appliance type with all filled fields
     * @throws ServiceException when data isn't valid
     */
    public abstract void isApplianceValid(Appliance appliance) throws ServiceException;

    /**
     * Method throws an exception when the data is not valid
     * @param value checked double value
     * @throws ServiceException when data isn't valid
     */
    protected final void isPossibleDoubleValue(Object value) throws ServiceException {
        try {
            double doubleValue = Double.parseDouble(value.toString());
            if (doubleValue <= 0) {
                throw new ServiceException("\"" + value.toString() + "\" isn't bigger than 0");
            }
        } catch (NumberFormatException e) {
            throw new ServiceException("\"" + value.toString() + "\" isn't double");
        }
    }
}
