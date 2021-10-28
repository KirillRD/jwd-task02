package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Refrigerator implements Appliance{
	private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator() {}

    public Refrigerator(double powerConsumption, double weight, double freezerCapacity, double overallCapacity, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public Refrigerator(Map<String, Object> applianceData) {
        powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).toString());
        weight = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString());
        freezerCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).toString());
        overallCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).toString());
        height = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString());
        width = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(SearchCriteria.Refrigerator.class.getSimpleName())) {
            return false;
        }

        Map<String, Object> criteriaRefrigerator = criteria.getCriteria();

        boolean equal = !criteriaRefrigerator.isEmpty();

        if (criteriaRefrigerator.containsKey(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())) {
            double powerConsumption = Double.parseDouble(criteriaRefrigerator.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).toString());
            equal = this.powerConsumption == powerConsumption && equal;
        }
        if (criteriaRefrigerator.containsKey(SearchCriteria.Refrigerator.WEIGHT.toString())) {
            double weight = Double.parseDouble(criteriaRefrigerator.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString());
            equal = this.weight == weight && equal;
        }
        if (criteriaRefrigerator.containsKey(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())) {
            double freezerCapacity = Double.parseDouble(criteriaRefrigerator.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).toString());
            equal = this.freezerCapacity == freezerCapacity && equal;
        }
        if (criteriaRefrigerator.containsKey(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())) {
            double overallCapacity = Double.parseDouble(criteriaRefrigerator.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).toString());
            equal = this.overallCapacity == overallCapacity && equal;
        }
        if (criteriaRefrigerator.containsKey(SearchCriteria.Refrigerator.HEIGHT.toString())) {
            double height = Double.parseDouble(criteriaRefrigerator.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString());
            equal = this.height == height && equal;
        }
        if (criteriaRefrigerator.containsKey(SearchCriteria.Refrigerator.WIDTH.toString())) {
            double width = Double.parseDouble(criteriaRefrigerator.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString());
            equal = this.width == width && equal;
        }
        return equal;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return Double.compare(that.powerConsumption, powerConsumption) == 0 && Double.compare(that.weight, weight) == 0 && Double.compare(that.freezerCapacity, freezerCapacity) == 0 && Double.compare(that.overallCapacity, overallCapacity) == 0 && Double.compare(that.height, height) == 0 && Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
