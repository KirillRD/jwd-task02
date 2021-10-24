package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class VacuumCleaner implements Appliance{
    private int powerConsumption;
    private char filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner() {}

    public VacuumCleaner(Map<String, Object> applianceData) {
        powerConsumption = Integer.parseInt(applianceData.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()).toString());
        filterType = applianceData.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()).toString().charAt(0);
        bagType = (String) applianceData.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        wandType = (String) applianceData.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        motorSpeedRegulation = Integer.parseInt(applianceData.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()).toString());
        cleaningWidth = Integer.parseInt(applianceData.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()).toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(SearchCriteria.VacuumCleaner.class.getSimpleName())) {
            return false;
        }

        Map<String, Object> criteriaVacuumCleaner = criteria.getCriteria();

        boolean equal = !criteriaVacuumCleaner.isEmpty();

        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
            int powerConsumption = Integer.parseInt(criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()).toString());
            equal = this.powerConsumption == powerConsumption && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())) {
            char filterType = criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()).toString().charAt(0);
            equal = this.filterType == filterType && equal;
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
            int motorSpeedRegulation = Integer.parseInt(criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()).toString());
            equal = this.motorSpeedRegulation == motorSpeedRegulation && equal;
        }
        if (criteriaVacuumCleaner.containsKey(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
            int cleaningWidth = Integer.parseInt(criteriaVacuumCleaner.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()).toString());
            equal = this.cleaningWidth == cleaningWidth && equal;
        }
        return equal;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public char getFilterType() {
        return filterType;
    }

    public void setFilterType(char filterType) {
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

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return powerConsumption == that.powerConsumption && filterType == that.filterType && motorSpeedRegulation == that.motorSpeedRegulation && cleaningWidth == that.cleaningWidth && Objects.equals(bagType, that.bagType) && Objects.equals(wandType, that.wandType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", filterType=" + filterType +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }
}
