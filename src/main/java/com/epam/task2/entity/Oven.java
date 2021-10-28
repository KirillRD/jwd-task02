package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Oven implements Appliance{
	private double powerConsumption;
	private double weight;
	private double capacity;
	private double depth;
	private double height;
	private double width;

	public Oven() {}

	public Oven(double powerConsumption, double weight, double capacity, double depth, double height, double width) {
		this.powerConsumption = powerConsumption;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
	}

	public Oven(Map<String, Object> applianceData) {
		powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
		weight = Double.parseDouble(applianceData.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
		capacity = Double.parseDouble(applianceData.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
		depth = Double.parseDouble(applianceData.get(SearchCriteria.Oven.DEPTH.toString()).toString());
		height = Double.parseDouble(applianceData.get(SearchCriteria.Oven.HEIGHT.toString()).toString());
		width = Double.parseDouble(applianceData.get(SearchCriteria.Oven.WIDTH.toString()).toString());
	}

	@Override
	public boolean containsCriteria(Criteria criteria) {
		if (!criteria.getTypeAppliance().equals(SearchCriteria.Oven.class.getSimpleName())) {
			return false;
		}

		Map<String, Object> criteriaOven = criteria.getCriteria();

		boolean equal = !criteriaOven.isEmpty();

		if (criteriaOven.containsKey(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
			double powerConsumption = Double.parseDouble(criteriaOven.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
			equal = this.powerConsumption == powerConsumption && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.WEIGHT.toString())) {
			double weight = Double.parseDouble(criteriaOven.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
			equal = this.weight == weight && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.CAPACITY.toString())) {
			double capacity = Double.parseDouble(criteriaOven.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
			equal = this.capacity == capacity && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.DEPTH.toString())) {
			double depth = Double.parseDouble(criteriaOven.get(SearchCriteria.Oven.DEPTH.toString()).toString());
			equal = this.depth == depth && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.HEIGHT.toString())) {
			double height = Double.parseDouble(criteriaOven.get(SearchCriteria.Oven.HEIGHT.toString()).toString());
			equal = this.height == height && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.WIDTH.toString())) {
			double width = Double.parseDouble(criteriaOven.get(SearchCriteria.Oven.WIDTH.toString()).toString());
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

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
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
