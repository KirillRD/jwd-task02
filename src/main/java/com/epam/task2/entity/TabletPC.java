package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that describe an entity appliance of the Tablet PC type
 * @author Kirill Ryabov
 */
public class TabletPC extends Appliance{
    /**
     * Field describes the battery capacity property
     */
	private double batteryCapacity;
    /**
     * Field describes the display inches property
     */
    private double displayInches;
    /**
     * Field describes the memory ROM property
     */
    private double memoryROM;
    /**
     * Field describes the flash memory capacity property
     */
    private double flashMemoryCapacity;
    /**
     * Field describes the color property
     */
    private String color;

    /**
     * Default constructor
     */
    public TabletPC() {}

    /**
     * Constructor that sets the value of all fields
     * @param batteryCapacity value of the battery capacity field
     * @param displayInches value of the display inches field
     * @param memoryROM value of the memory ROM field
     * @param flashMemoryCapacity value of the flash memory capacity field
     * @param color value of the color field
     */
    public TabletPC(double batteryCapacity, double displayInches, double memoryROM, double flashMemoryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    /**
     * Constructor that sets the value of all fields
     * @param applianceData HashMap with fields names(keys) and their values(values)
     */
    public TabletPC(Map<String, Object> applianceData) {
        batteryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()).toString());
        displayInches = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString());
        memoryROM = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString());
        flashMemoryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()).toString());
        color = (String) applianceData.get(SearchCriteria.TabletPC.COLOR.toString());
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
        doubleFields.put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), batteryCapacity);
        doubleFields.put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), displayInches);
        doubleFields.put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), memoryROM);
        doubleFields.put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), flashMemoryCapacity);

        Map<String, String> stringFields = new HashMap<String, String>();
        stringFields.put(SearchCriteria.TabletPC.COLOR.toString(), color);

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
     * Method that returns value of the flash memory capacity field
     * @return value of the flash memory capacity field
     */
    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    /**
     * Method that sets the value of the flash memory capacity field
     * @param flashMemoryCapacity value of the flash memory capacity field
     */
    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    /**
     * Method that returns value of the color field
     * @return value of the color field
     */
    public String getColor() {
        return color;
    }

    /**
     * Method that sets the value of the color field
     * @param color value of the color field
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return Double.compare(tabletPC.batteryCapacity, batteryCapacity) == 0 && Double.compare(tabletPC.displayInches, displayInches) == 0 && Double.compare(tabletPC.memoryROM, memoryROM) == 0 && Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) == 0 && Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayInches, memoryROM, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryROM=" + memoryROM +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
