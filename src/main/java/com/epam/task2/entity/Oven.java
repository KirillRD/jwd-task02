package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that describe an entity appliance of the Oven type
 * @author Kirill Ryabov
 */
public class Oven extends Appliance{
	/**
	 * Field describes the power consumption property
	 */
	private double powerConsumption;
	/**
	 * Field describes the weight property
	 */
	private double weight;
	/**
	 * Field describes the capacity property
	 */
	private double capacity;
	/**
	 * Field describes the depth property
	 */
	private double depth;
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
	public Oven() {}

	/**
	 * Constructor that sets the value of all fields
	 * @param powerConsumption value of the power consumption field
	 * @param weight value of the weight field
	 * @param capacity value of the capacity field
	 * @param depth value of the depth field
	 * @param height value of the height field
	 * @param width value of the width field
	 */
	public Oven(double powerConsumption, double weight, double capacity, double depth, double height, double width) {
		this.powerConsumption = powerConsumption;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
	}

	/**
	 * Constructor that sets the value of all fields
	 * @param applianceData HashMap with fields names(keys) and their values(values)
	 */
	public Oven(Map<String, Object> applianceData) {
		powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
		weight = Double.parseDouble(applianceData.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
		capacity = Double.parseDouble(applianceData.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
		depth = Double.parseDouble(applianceData.get(SearchCriteria.Oven.DEPTH.toString()).toString());
		height = Double.parseDouble(applianceData.get(SearchCriteria.Oven.HEIGHT.toString()).toString());
		width = Double.parseDouble(applianceData.get(SearchCriteria.Oven.WIDTH.toString()).toString());
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
		doubleFields.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), powerConsumption);
		doubleFields.put(SearchCriteria.Oven.WEIGHT.toString(), weight);
		doubleFields.put(SearchCriteria.Oven.CAPACITY.toString(), capacity);
		doubleFields.put(SearchCriteria.Oven.DEPTH.toString(), depth);
		doubleFields.put(SearchCriteria.Oven.HEIGHT.toString(), height);
		doubleFields.put(SearchCriteria.Oven.WIDTH.toString(), width);

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
	 * Method that returns value of the capacity field
	 * @return value of the capacity field
	 */
	public double getCapacity() {
		return capacity;
	}

	/**
	 * Method that sets the value of the capacity field
	 * @param capacity value of the capacity field
	 */
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	/**
	 * Method that returns value of the depth field
	 * @return value of the depth field
	 */
	public double getDepth() {
		return depth;
	}

	/**
	 * Method that sets the value of the depth field
	 * @param depth value of the depth field
	 */
	public void setDepth(double depth) {
		this.depth = depth;
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
		Oven oven = (Oven) o;
		return Double.compare(oven.powerConsumption, powerConsumption) == 0 && Double.compare(oven.weight, weight) == 0 && Double.compare(oven.capacity, capacity) == 0 && Double.compare(oven.depth, depth) == 0 && Double.compare(oven.height, height) == 0 && Double.compare(oven.width, width) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(powerConsumption, weight, capacity, depth, height, width);
	}

	@Override
	public String toString() {
		return "Oven{" +
				"powerConsumption=" + powerConsumption +
				", weight=" + weight +
				", capacity=" + capacity +
				", depth=" + depth +
				", height=" + height +
				", width=" + width +
				'}';
	}
}
