package com.epam.task2.service.validation;

import com.epam.task2.constant.APPLIANCE_TYPES;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.impl.*;

public final class ApplianceValidatorFactory {
    private ApplianceValidatorFactory() {}

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
            throw new ServiceException("We don't have \"" + typeAppliance +  "\" type appliance");
        }
        return applianceValidator;
    }
}
