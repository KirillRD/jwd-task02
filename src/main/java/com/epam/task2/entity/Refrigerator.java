package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that describe an entity appliance of the Refrigerator type
 * @author Kirill Ryabov
 */
public class Refrigerator extends Appliance{
    /**
     * Field describes the power consumption property
     */
	private double powerConsumption;
    /**
     * Field describes the weight property
     */
    private double weight;
    /**
     * Field describes the freezer capacity property
     */
    private double freezerCapacity;
    /**
     * Field describes the overall capacity property
     */
    private double overallCapacity;
    /**
     * Field describes the height property
     */
    private double height;
    /**
     * Field describes the width property
     */
    private double width;

    /**
     * Default constructor
     */
    public Refrigerator() {}

    /**
     * Constructor that sets the value of all fields
     * @param powerConsumption value of the power consumption field
     * @param weight value of the weight field
     * @param freezerCapacity value of the freezer capacity field
     * @param overallCapacity value of the overall capacity field
     * @param height value of the height field
     * @param width value of the width field
     */
    public Refrigerator(double powerConsumption, double weight, double freezerCapacity, double overallCapacity, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    /**
     * Constructor that sets the value of all fields
     * @param applianceData HashMap with fields names(keys) and their values(values)
     */
    public Refrigerator(Map<String, Object> applianceData) {
        powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).toString());
        weight = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString());
        freezerCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).toString());
        overallCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).toString());
        height = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString());
        width = Double.parseDouble(applianceData.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString());
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
        doubleFields.put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), powerConsumption);
        doubleFields.put(SearchCriteria.Refrigerator.WEIGHT.toString(), weight);
        doubleFields.put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), freezerCapacity);
        doubleFields.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), overallCapacity);
        doubleFields.put(SearchCriteria.Refrigerator.HEIGHT.toString(), height);
        doubleFields.put(SearchCriteria.Refrigerator.WIDTH.toString(), width);

        return checkFieldsByCriteria(criteria, doubleFields, null);
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
     * Method that returns value of the weight field
     * @return value of the weight field
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method that sets the value of the weight field
     * @param weight value of the weight field
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Method that returns value of the freezer capacity field
     * @return value of the freezer capacity field
     */
    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    /**
     * Method that sets the value of the freezer capacity field
     * @param freezerCapacity value of the freezer capacity field
     */
    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    /**
     * Method that returns value of the overall capacity field
     * @return value of the overall capacity field
     */
    public double getOverallCapacity() {
        return overallCapacity;
    }

    /**
     * Method that sets the value of the overall capacity field
     * @param overallCapacity value of the overall capacity field
     */
    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    /**
     * Method that returns value of the height field
     * @return value of the height field
     */
    public double getHeight() {
        return height;
    }

    /**
     * Method that sets the value of the height field
     * @param height value of the height field
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Method that returns value of the width field
     * @return value of the width field
     */
    public double getWidth() {
        return width;
    }

    /**
     * Method that sets the value of the width field
     * @param width value of the width field
     */
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
