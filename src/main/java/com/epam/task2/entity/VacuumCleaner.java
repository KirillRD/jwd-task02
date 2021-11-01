package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that describe an entity appliance of the Vacuum cleaner type
 * @author Kirill Ryabov
 */
public class VacuumCleaner extends Appliance{
    /**
     * Field describes the power consumption property
     */
    private double powerConsumption;
    /**
     * Field describes the filter type property
     */
    private String filterType;
    /**
     * Field describes the bag type property
     */
    private String bagType;
    /**
     * Field describes the wand type property
     */
    private String wandType;
    /**
     * Field describes the motor speed regulation property
     */
    private double motorSpeedRegulation;
    /**
     * Field describes the cleaning width property
     */
    private double cleaningWidth;

    /**
     * Default constructor
     */
    public VacuumCleaner() {}

    /**
     *
     * @param powerConsumption value of the power consumption field
     * @param filterType value of the filter type field
     * @param bagType value of the bag type field
     * @param wandType value of the wand type field
     * @param motorSpeedRegulation value of the motor speed regulation field
     * @param cleaningWidth value of the cleaning width field
     */
    public VacuumCleaner(double powerConsumption, String filterType, String bagType, String wandType, double motorSpeedRegulation, double cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    /**
     * Constructor that sets the value of all fields
     * @param applianceData HashMap with fields names(keys) and their values(values)
     */
    public VacuumCleaner(Map<String, Object> applianceData) {
        powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()).toString());
        filterType = (String) applianceData.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
        bagType = (String) applianceData.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        wandType = (String) applianceData.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        motorSpeedRegulation = Double.parseDouble(applianceData.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()).toString());
        cleaningWidth = Double.parseDouble(applianceData.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()).toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(this.getClass().getSimpleName())) {
            return false;
        }

        Map<String, Double> doubleFields = new HashMap<String, Double>();
        doubleFields.put(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), powerConsumption);
        doubleFields.put(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), motorSpeedRegulation);
        doubleFields.put(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), cleaningWidth);

        Map<String, String> stringFields = new HashMap<String, String>();
        stringFields.put(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), filterType);
        stringFields.put(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), bagType);
        stringFields.put(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), wandType);

        return checkFieldsByCriteria(criteria, doubleFields, stringFields);
    }

    /**
     * Method that returns value of the power consumption field
     * @return value of the power consumption field
     */
    public double getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * Method that sets the value of the power consumption field
     * @param powerConsumption value of the power consumption field
     */
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    /**
     * Method that returns value of the filter type field
     * @return value of the filter type field
     */
    public String getFilterType() {
        return filterType;
    }

    /**
     * Method that sets the value of the filter type field
     * @param filterType value of the filter type field
     */
    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    /**
     * Method that returns value of the bag type field
     * @return value of the bag type field
     */
    public String getBagType() {
        return bagType;
    }

    /**
     * Method that sets the value of the bag type field
     * @param bagType value of the bag type field
     */
    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    /**
     * Method that returns value of the wand type field
     * @return value of the wand type field
     */
    public String getWandType() {
        return wandType;
    }

    /**
     * Method that sets the value of the wand type field
     * @param wandType value of the wand type field
     */
    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    /**
     * Method that returns value of the motor speed regulation field
     * @return value of the motor speed regulation field
     */
    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    /**
     * Method that sets the value of the motor speed regulation field
     * @param motorSpeedRegulation value of the motor speed regulation field
     */
    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    /**
     * Method that returns value of the cleaning width field
     * @return value of the cleaning width field
     */
    public double getCleaningWidth() {
        return cleaningWidth;
    }

    /**
     * Method that sets the value of the cleaning width field
     * @param cleaningWidth value of the cleaning width field
     */
    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return Double.compare(that.powerConsumption, powerConsumption) == 0 && Double.compare(that.motorSpeedRegulation, motorSpeedRegulation) == 0 && Double.compare(that.cleaningWidth, cleaningWidth) == 0 && Objects.equals(filterType, that.filterType) && Objects.equals(bagType, that.bagType) && Objects.equals(wandType, that.wandType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }
}
