package com.epam.task2.service.validation;

import com.epam.task2.constant.APPLIANCE_TYPES;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.impl.*;

/**
 * Class fabric of appliances validators
 * This class can't be extended
 * @author Kirill Ryabov
 */
public final class ApplianceValidatorFactory {
    /**
     * Restricting access to the creation of objects of this class
     */
    private ApplianceValidatorFactory() {}

    /**
     * Method for creating appliance validator
     * @param typeAppliance type of appliance
     * @return object of one of the appliances validators
     * @throws ServiceException when data isn't valid
     */
    public static ApplianceValidator getApplianceValidator(String typeAppliance) throws ServiceException {
        ApplianceValidator applianceValidator;
        try {
            switch (APPLIANCE_TYPES.valueOf(typeAppliance)) {
                case Laptop:
                    applianceValidator = new LaptopValidator();
                    break;
                case Oven:
                    applianceValidator = new OvenValidator();
                    break;
                case Refrigerator:
                    applianceValidator = new RefrigeratorValidator();
                    break;
                case Speakers:
                    applianceValidator = new SpeakersValidator();
                    break;
                case TabletPC:
                    applianceValidator = new TabletPCValidator();
                    break;
                case VacuumCleaner:
                    applianceValidator = new VacuumCleanerValidator();
                    break;
                default:
                    throw new IllegalStateException();
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new ServiceException("We don't have \"" + typeAppliance +  "\" appliance type");
        }
        return applianceValidator;
    }
}
