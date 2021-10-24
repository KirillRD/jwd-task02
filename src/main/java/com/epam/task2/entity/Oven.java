package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Oven implements Appliance{
	private int powerConsumption;
	private int weight;
	private int capacity;
	private int depth;
	private double height;
	private double width;

	public Oven() {}

	public Oven(Map<String, Object> applianceData) {
		powerConsumption = Integer.parseInt(applianceData.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
		weight = Integer.parseInt(applianceData.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
		capacity = Integer.parseInt(applianceData.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
		depth = Integer.parseInt(applianceData.get(SearchCriteria.Oven.DEPTH.toString()).toString());
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
			int powerConsumption = Integer.parseInt(criteriaOven.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
			equal = this.powerConsumption == powerConsumption && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.WEIGHT.toString())) {
			int weight = Integer.parseInt(criteriaOven.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
			equal = this.weight == weight && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.CAPACITY.toString())) {
			int capacity = Integer.parseInt(criteriaOven.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
			equal = this.capacity == capacity && equal;
		}
		if (criteriaOven.containsKey(SearchCriteria.Oven.DEPTH.toString())) {
			int depth = Integer.parseInt(criteriaOven.get(SearchCriteria.Oven.DEPTH.toString()).toString());
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
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
		return powerConsumption == oven.powerConsumption && weight == oven.weight && capacity == oven.capacity && depth == oven.depth && Double.compare(oven.height, height) == 0 && Double.compare(oven.width, width) == 0;
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
