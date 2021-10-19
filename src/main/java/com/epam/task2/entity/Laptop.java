package com.epam.task2.entity;

import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Laptop extends Appliance{
	private double batteryCapacity;
	private String os;
	private int memoryROM;
	private int systemMemory;
	private double cpu;
	private int displayINCHS;

	public Laptop(Map<String, Object> applianceData) {
		batteryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()).toString());
		os = (String) applianceData.get(SearchCriteria.Laptop.OS.toString());
		memoryROM = Integer.parseInt(applianceData.get(SearchCriteria.Laptop.MEMORY_ROM.toString()).toString());
		systemMemory = Integer.parseInt(applianceData.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()).toString());
		cpu = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.CPU.toString()).toString());
		displayINCHS = Integer.parseInt(applianceData.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString()).toString());
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

	public int getMemoryROM() {
		return memoryROM;
	}

	public void setMemoryROM(int memoryROM) {
		this.memoryROM = memoryROM;
	}

	public int getSystemMemory() {
		return systemMemory;
	}

	public void setSystemMemory(int systemMemory) {
		this.systemMemory = systemMemory;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public int getDisplayINCHS() {
		return displayINCHS;
	}

	public void setDisplayINCHS(int displayINCHS) {
		this.displayINCHS = displayINCHS;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Laptop laptop = (Laptop) o;
		return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 && memoryROM == laptop.memoryROM && systemMemory == laptop.systemMemory && Double.compare(laptop.cpu, cpu) == 0 && displayINCHS == laptop.displayINCHS && Objects.equals(os, laptop.os);
	}

	@Override
	public int hashCode() {
		return Objects.hash(batteryCapacity, os, memoryROM, systemMemory, cpu, displayINCHS);
	}

	@Override
	public String toString() {
		return "Laptop{" +
				"batteryCapacity=" + batteryCapacity +
				", os='" + os + '\'' +
				", memoryROM=" + memoryROM +
				", systemMemory=" + systemMemory +
				", cpu=" + cpu +
				", displayINCHS=" + displayINCHS +
				'}';
	}
}
