package com.epam.task2.dao.xml.constant;

/**
 * Enum of appliance types with value types in XML
 * @author Kirill Ryabov
 */
public enum APPLIANCE_TYPES_XML {
    Oven("oven"),
    Laptop("laptop"),
    Refrigerator("refrigerator"),
    VacuumCleaner("vacuum-cleaner"),
    TabletPC("tablet-pc"),
    Speakers("speakers");

    /**
     * Field with appliance type in XML
     */
    private final String applianceTypeXML;

    /**
     * Constructor for assigning a value to a field with appliance type in XML
     * @param applianceTypeXML value of appliance type in XML
     */
    APPLIANCE_TYPES_XML(String applianceTypeXML) {
        this.applianceTypeXML = applianceTypeXML;
    }

    /**
     * Method for getting appliance type by appliance type in XML
     * @param applianceTypeXML appliance type in XML
     * @return appliance type
     */
    public static String getApplianceType(String applianceTypeXML) {
        for (APPLIANCE_TYPES_XML e : APPLIANCE_TYPES_XML.values()) {
            if (e.applianceTypeXML.equals(applianceTypeXML)) {
                return e.name();
            }
        }
        return null;
    }

    /**
     * Method for getting appliance type in XML by appliance type
     * @param applianceType appliance type
     * @return appliance type in XML
     */
    public static String getApplianceTypeXML(String applianceType) {
        return APPLIANCE_TYPES_XML.valueOf(applianceType).applianceTypeXML;
    }
}
