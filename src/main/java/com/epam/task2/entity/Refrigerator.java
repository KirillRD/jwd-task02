package com.epam.task2.entity;

import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Refrigerator extends Appliance{
	private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private int height;
    private int width;

    public Refrigerator(Map<String, Object> applianceData) {
        powerConsumption = Integer.parseInt(applianceData.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).toString());
        weight = Integer.parseInt(applianceData.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString());
        freezerCapacity = Integer.parseInt(applianceData.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).toString());
        overallCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).toString());
        height = Integer.parseInt(applianceData.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString());
        width = Integer.parseInt(applianceData.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString());
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return powerConsumption == that.powerConsumption && weight == that.weight && freezerCapacity == that.freezerCapacity && Double.compare(that.overallCapacity, overallCapacity) == 0 && height == that.height && width == that.width;
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
