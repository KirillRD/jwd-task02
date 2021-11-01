package com.epam.task2.service.validation;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.ServiceException;

/**
 * Class validates the data entered by the user
 * This class can't be extended
 * @author Kirill Ryabov
 */
public final class Validator {
	/**
	 * Restricting access to the creation of objects of this class
	 */
	private Validator() {}

	/**
	 * Method that validates the data entered by the user in the criteria
	 * @param criteria contains name of appliance type and HashMap with fields names(keys) and their values(values)
	 * @throws ServiceException when data isn't valid
	 */
	public static void criteriaValidator(Criteria criteria) throws ServiceException {
		if (criteria.getCriteria().isEmpty()) {
			throw new ServiceException("\"" + criteria.getTypeAppliance() + "\" don't have criteria");
		}
		ApplianceValidator applianceValidator = ApplianceValidatorFactory.getApplianceValidator(criteria.getTypeAppliance());
		applianceValidator.isCriteriaValid(criteria);
	}

	/**
	 * Method that validates the properties entered by the user in the appliance
	 * @param appliance single appliance type with all filled fields
	 * @throws ServiceException when data isn't valid
	 */
	public static void newApplianceValidator(Appliance appliance) throws ServiceException{
		if (appliance == null) {
			throw new ServiceException("Appliance is null");
		}
		ApplianceValidator applianceValidator = ApplianceValidatorFactory.getApplianceValidator(appliance.getClass().getSimpleName());
		applianceValidator.isApplianceValid(appliance);
	}
}
