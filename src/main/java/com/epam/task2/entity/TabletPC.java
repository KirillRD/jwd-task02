package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TabletPC extends Appliance{
	private double batteryCapacity;
    private double displayINCHES;
    private double memoryROM;
    private double flashMemoryCapacity;
    private String color;

    public TabletPC() {}

    public TabletPC(double batteryCapacity, double displayINCHES, double memoryROM, double flashMemoryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.displayINCHES = displayINCHES;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public TabletPC(Map<String, Object> applianceData) {
        batteryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()).toString());
        displayINCHES = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString());
        memoryROM = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString());
        flashMemoryCapacity = Double.parseDouble(applianceData.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()).toString());
        color = (String) applianceData.get(SearchCriteria.TabletPC.COLOR.toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(this.getClass().getSimpleName())) {
            return false;
        }

        Map<String, Double> doubleFields = new HashMap<String, Double>();
        doubleFields.put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), batteryCapacity);
        doubleFields.put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), displayINCHES);
        doubleFields.put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), memoryROM);
        doubleFields.put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), flashMemoryCapacity);

        Map<String, String> stringFields = new HashMap<String, String>();
        stringFields.put(SearchCriteria.TabletPC.COLOR.toString(), color);

        return checkFieldsByCriteria(criteria, doubleFields, stringFields);
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayINCHES() {
        return displayINCHES;
    }

    public void setDisplayINCHES(double displayINCHES) {
        this.displayINCHES = displayINCHES;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return Double.compare(tabletPC.batteryCapacity, batteryCapacity) == 0 && Double.compare(tabletPC.displayINCHES, displayINCHES) == 0 && Double.compare(tabletPC.memoryROM, memoryROM) == 0 && Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) == 0 && Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayINCHES, memoryROM, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayINCHES=" + displayINCHES +
                ", memoryROM=" + memoryROM +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
