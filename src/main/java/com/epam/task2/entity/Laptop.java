package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Laptop extends Appliance{
	private double batteryCapacity;
	private String os;
	private double memoryROM;
	private double systemMemory;
	private double cpu;
	private double displayINCHES;

	public Laptop() {}

	public Laptop(double batteryCapacity, String os, double memoryROM, double systemMemory, double cpu, double displayINCHES) {
		this.batteryCapacity = batteryCapacity;
		this.os = os;
		this.memoryROM = memoryROM;
		this.systemMemory = systemMemory;
		this.cpu = cpu;
		this.displayINCHES = displayINCHES;
	}

	public Laptop(Map<String, Object> applianceData) {
		batteryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()).toString());
		os = (String) applianceData.get(SearchCriteria.Laptop.OS.toString());
		memoryROM = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.MEMORY_ROM.toString()).toString());
		systemMemory = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()).toString());
		cpu = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.CPU.toString()).toString());
		displayINCHES = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.DISPLAY_INCHES.toString()).toString());
	}

	@Override
	public boolean containsCriteria(Criteria criteria) {
		if (!criteria.getTypeAppliance().equals(this.getClass().getSimpleName())) {
			return false;
		}

		Map<String, Double> doubleFields = new HashMap<String, Double>();
		doubleFields.put(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), batteryCapacity);
		doubleFields.put(SearchCriteria.Laptop.MEMORY_ROM.toString(), memoryROM);
		doubleFields.put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), systemMemory);
		doubleFields.put(SearchCriteria.Laptop.CPU.toString(), cpu);
		doubleFields.put(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), displayINCHES);

		Map<String, String> stringFields = new HashMap<String, String>();
		stringFields.put(SearchCriteria.Laptop.OS.toString(), os);

		return checkFieldsByCriteria(criteria, doubleFields, stringFields);
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public double getMemoryROM() {
		return memoryROM;
	}

	public void setMemoryROM(double memoryROM) {
		this.memoryROM = memoryROM;
	}

	public double getSystemMemory() {
		return systemMemory;
	}

	public void setSystemMemory(double systemMemory) {
		this.systemMemory = systemMemory;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public double getDisplayINCHES() {
		return displayINCHES;
	}

	public void setDisplayINCHES(double displayINCHES) {
		this.displayINCHES = displayINCHES;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Laptop laptop = (Laptop) o;
		return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 && Double.compare(laptop.memoryROM, memoryROM) == 0 && Double.compare(laptop.systemMemory, systemMemory) == 0 && Double.compare(laptop.cpu, cpu) == 0 && Double.compare(laptop.displayINCHES, displayINCHES) == 0 && Objects.equals(os, laptop.os);
	}

	@Override
	public int hashCode() {
		return Objects.hash(batteryCapacity, os, memoryROM, systemMemory, cpu, displayINCHES);
	}

	@Override
	public String toString() {
		return "Laptop{" +
				"batteryCapacity=" + batteryCapacity +
				", os='" + os + '\'' +
				", memoryROM=" + memoryROM +
				", systemMemory=" + systemMemory +
				", cpu=" + cpu +
				", displayINCHES=" + displayINCHES +
				'}';
	}
}
