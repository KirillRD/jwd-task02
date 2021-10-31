package com.epam.task2.dao.xml.constant;

public enum APPLIANCE_TYPES_XML {
    Oven("oven"),
    Laptop("laptop"),
    Refrigerator("refrigerator"),
    VacuumCleaner("vacuum-cleaner"),
    TabletPC("tablet-pc"),
    Speakers("speakers");

    private final String applianceTypeXML;

    APPLIANCE_TYPES_XML(String applianceTypeXML) {
        this.applianceTypeXML = applianceTypeXML;
    }

    public static String getApplianceType(String applianceTypeXML) {
        for (APPLIANCE_TYPES_XML e : APPLIANCE_TYPES_XML.values()) {
            if (e.applianceTypeXML.equals(applianceTypeXML)) {
                return e.name();
            }
        }
        return null;
    }

    public static String getApplianceTypeXML(String applianceType) {
        return APPLIANCE_TYPES_XML.valueOf(applianceType).applianceTypeXML;
    }
}
