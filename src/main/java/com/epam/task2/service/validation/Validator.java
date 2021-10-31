package com.epam.task2.service.validation;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ServiceException;

public final class Validator {
	private Validator() {}
	
	public static void criteriaValidator(Criteria criteria) throws ServiceException {
		if (criteria.getCriteria().isEmpty()) {
			throw new ServiceException("\"" + criteria.getTypeAppliance() + "\" don't have criteria");
		}
		ApplianceValidator applianceValidator = ApplianceValidatorFactory.getApplianceValidator(criteria.getTypeAppliance());
		applianceValidator.isCriteriaValid(criteria);
	}

	public static void newApplianceValidator(Appliance appliance) throws ServiceException{
		if (appliance == null) {
			throw new ServiceException("Appliance is null");
		}
		ApplianceValidator applianceValidator = ApplianceValidatorFactory.getApplianceValidator(appliance.getClass().getSimpleName());
		applianceValidator.isApplianceValid(appliance);
	}
}
