package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that describe an entity appliance of the Laptop type
 * @author Kirill Ryabov
 */
public class Laptop extends Appliance{
	/**
	 * Field describes the battery capacity property
	 */
	private double batteryCapacity;
	/**
	 * Field describes the OS property
	 */
	private String os;
	/**
	 * Field describes the memory ROM property
	 */
	private double memoryROM;
	/**
	 * Field describes the system memory property
	 */
	private double systemMemory;
	/**
	 * Field describes the CPU property
	 */
	private double cpu;
	/**
	 * Field describes the display inches property
	 */
	private double displayInches;

	/**
	 * Default constructor
	 */
	public Laptop() {}

	/**
	 * Constructor that sets the value of all fields
	 * @param batteryCapacity value of the battery capacity field
	 * @param os value of the OS field
	 * @param memoryROM value of the memory ROM field
	 * @param systemMemory value of the system memory field
	 * @param cpu value of the CPU field
	 * @param displayInches value of the display inches field
	 */
	public Laptop(double batteryCapacity, String os, double memoryROM, double systemMemory, double cpu, double displayInches) {
		this.batteryCapacity = batteryCapacity;
		this.os = os;
		this.memoryROM = memoryROM;
		this.systemMemory = systemMemory;
		this.cpu = cpu;
		this.displayInches = displayInches;
	}

	/**
	 * Constructor that sets the value of all fields
	 * @param applianceData HashMap with fields names(keys) and their values(values)
	 */
	public Laptop(Map<String, Object> applianceData) {
		batteryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()).toString());
		os = (String) applianceData.get(SearchCriteria.Laptop.OS.toString());
		memoryROM = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.MEMORY_ROM.toString()).toString());
		systemMemory = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()).toString());
		cpu = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.CPU.toString()).toString());
		displayInches = Double.parseDouble(applianceData.get(SearchCriteria.Laptop.DISPLAY_INCHES.toString()).toString());
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
		doubleFields.put(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), batteryCapacity);
		doubleFields.put(SearchCriteria.Laptop.MEMORY_ROM.toString(), memoryROM);
		doubleFields.put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), systemMemory);
		doubleFields.put(SearchCriteria.Laptop.CPU.toString(), cpu);
		doubleFields.put(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), displayInches);

		Map<String, String> stringFields = new HashMap<String, String>();
		stringFields.put(SearchCriteria.Laptop.OS.toString(), os);

		return checkFieldsByCriteria(criteria, doubleFields, stringFields);
	}

	/**
	 * Method that returns value of the battery capacity field
	 * @return value of the battery capacity field
	 */
	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	/**
	 * Method that sets the value of the battery capacity field
	 * @param batteryCapacity value of the battery capacity field
	 */
	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	/**
	 * Method that returns value of the OS field
	 * @return value of the OS field
	 */
	public String getOs() {
		return os;
	}

	/**
	 * Method that sets the value of the OS field
	 * @param os value of the OS field
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * Method that returns value of the memory ROM field
	 * @return value of the memory ROM field
	 */
	public double getMemoryROM() {
		return memoryROM;
	}

	/**
	 * Method that sets the value of the memory ROM field
	 * @param memoryROM value of the memory ROM field
	 */
	public void setMemoryROM(double memoryROM) {
		this.memoryROM = memoryROM;
	}

	/**
	 * Method that returns value of the system memory field
	 * @return value of the system memory field
	 */
	public double getSystemMemory() {
		return systemMemory;
	}

	/**
	 * Method that sets the value of the system memory field
	 * @param systemMemory value of the system memory field
	 */
	public void setSystemMemory(double systemMemory) {
		this.systemMemory = systemMemory;
	}

	/**
	 * Method that returns value of the CPU field
	 * @return value of the CPU field
	 */
	public double getCpu() {
		return cpu;
	}

	/**
	 * Method that sets the value of the CPU field
	 * @param cpu value of the CPU field
	 */
	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	/**
	 * Method that returns value of the display inches field
	 * @return value of the display inches field
	 */
	public double getDisplayInches() {
		return displayInches;
	}

	/**
	 * Method that sets the value of the display inches field
	 * @param displayInches value of the display inches field
	 */
	public void setDisplayInches(double displayInches) {
		this.displayInches = displayInches;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Laptop laptop = (Laptop) o;
		return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 && Double.compare(laptop.memoryROM, memoryROM) == 0 && Double.compare(laptop.systemMemory, systemMemory) == 0 && Double.compare(laptop.cpu, cpu) == 0 && Double.compare(laptop.displayInches, displayInches) == 0 && Objects.equals(os, laptop.os);
	}

	@Override
	public int hashCode() {
		return Objects.hash(batteryCapacity, os, memoryROM, systemMemory, cpu, displayInches);
	}

	@Override
	public String toString() {
		return "Laptop{" +
				"batteryCapacity=" + batteryCapacity +
				", os='" + os + '\'' +
				", memoryROM=" + memoryROM +
				", systemMemory=" + systemMemory +
				", cpu=" + cpu +
				", displayInches=" + displayInches +
				'}';
	}
}
