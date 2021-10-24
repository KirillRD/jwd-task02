package com.epam.task2.entity;

import java.util.Map;

public final class ApplianceFactory {
    private ApplianceFactory() {}

    public static Appliance createAppliance(String typeAppliance, Map<String, Object> applianceData) {
        Appliance appliance;

        switch(typeAppliance) {
            case "Laptop":
                appliance = new Laptop(applianceData);
                break;
            case "Oven":
                appliance = new Oven(applianceData);
                break;
            case "Refrigerator":
                appliance = new Refrigerator(applianceData);
                break;
            case "Speakers":
                appliance = new Speakers(applianceData);
                break;
            case "TabletPC":
                appliance = new TabletPC(applianceData);
                break;
            case "VacuumCleaner":
                appliance = new VacuumCleaner(applianceData);
                break;
            default:
                throw new NullPointerException();
        }

        return appliance;
    }
}
