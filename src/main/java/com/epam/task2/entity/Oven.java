package com.epam.task2.entity;

import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Oven extends Appliance{
	private int powerConsumption;
	private int weight;
	private int capacity;
	private int depth;
	private int height;
	private int width;

	public Oven(Map<String, Object> applianceData) {
		powerConsumption = Integer.parseInt(applianceData.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
		weight = Integer.parseInt(applianceData.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
		capacity = Integer.parseInt(applianceData.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
		depth = Integer.parseInt(applianceData.get(SearchCriteria.Oven.DEPTH.toString()).toString());
		height = Integer.parseInt(applianceData.get(SearchCriteria.Oven.HEIGHT.toString()).toString());
		width = Integer.parseInt(applianceData.get(SearchCriteria.Oven.WIDTH.toString()).toString());
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
		Oven oven = (Oven) o;
		return powerConsumption == oven.powerConsumption && weight == oven.weight && capacity == oven.capacity && depth == oven.depth && height == oven.height && width == oven.width;
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
