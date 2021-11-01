package com.epam.task2.dao.factory;

import com.epam.task2.constant.APPLIANCE_TYPES;
import com.epam.task2.entity.*;

import java.util.Map;

/**
 * Class fabric of appliances
 * This class can't be extended
 * @author Kirill Ryabov
 */
public final class ApplianceFactory {
    /**
     * Restricting access to the creation of objects of this class
     */
    private ApplianceFactory() {}

    /**
     * Method for creating appliance of a certain type with filled fields
     * @param typeAppliance type of appliance
     * @param applianceData HashMap with fields names(keys) and their values(values)
     * @return object of one of the appliances
     */
    public static Appliance createAppliance(String typeAppliance, Map<String, Object> applianceData) {
        Appliance appliance = null;

        switch(APPLIANCE_TYPES.valueOf(typeAppliance)) {
            case Laptop:
                appliance = new Laptop(applianceData);
                break;
            case Oven:
                appliance = new Oven(applianceData);
                break;
            case Refrigerator:
                appliance = new Refrigerator(applianceData);
                break;
            case Speakers:
                appliance = new Speakers(applianceData);
                break;
            case TabletPC:
                appliance = new TabletPC(applianceData);
                break;
            case VacuumCleaner:
                appliance = new VacuumCleaner(applianceData);
                break;
        }

        return appliance;
    }
}
