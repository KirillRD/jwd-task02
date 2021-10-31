package com.epam.task2.service.validation;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ServiceException;

public abstract class ApplianceValidator {
    public abstract void isCriteriaValid(Criteria criteria) throws ServiceException;
    public abstract void isApplianceValid(Appliance appliance) throws ServiceException;

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
