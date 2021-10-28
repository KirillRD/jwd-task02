package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class VacuumCleaner implements Appliance{
    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner() {}

    public VacuumCleaner(double powerConsumption, String filterType, String bagType, String wandType, double motorSpeedRegulation, double cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner(Map<String, Object> applianceData) {
        powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()).toString());
        filterType = (String) applianceData.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
        bagType = (String) applianceData.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        wandType = (String) applianceData.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        motorSpeedRegulation = Double.parseDouble(applianceData.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()).toString());
        cleaningWidth = Double.parseDouble(applianceData.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()).toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(SearchCriteria.VacuumCleaner.class.getSimpleName())) {
            return false;
        }

        Map<String, Object> criteriaVacuumCleaner = criteria.getCriteria();

        boolean equal = !criteriaVacuumCleaner.isEmpty();

        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
            double powerConsumption = Double.parseDouble(criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()).toString());
            equal = this.powerConsumption == powerConsumption && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())) {
            String filterType = (String) criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
            equal = this.filterType.equals(filterType) && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.BAG_TYPE.toString())) {
            String bagType = (String) criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
            equal = this.bagType.equals(bagType) && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.WAND_TYPE.toString())) {
            String wandType = (String) criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
            equal = this.wandType.equals(wandType) && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())) {
            double motorSpeedRegulation = Double.parseDouble(criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()).toString());
            equal = this.motorSpeedRegulation == motorSpeedRegulation && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
            double cleaningWidth = Double.parseDouble(criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()).toString());
            equal = this.cleaningWidth == cleaningWidth && equal;
        }
        return equal;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

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
