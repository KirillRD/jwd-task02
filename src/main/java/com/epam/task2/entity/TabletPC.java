package com.epam.task2.entity;

import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class TabletPC extends Appliance{
	private int batteryCapacity;
    private int displayINCHS;
    private int memoryROM;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC(Map<String, Object> applianceData) {
        batteryCapacity = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()).toString());
        displayINCHS = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString());
        memoryROM = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString());
        flashMemoryCapacity = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()).toString());
        color = (String) applianceData.get(SearchCriteria.TabletPC.COLOR.toString());
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayINCHS() {
        return displayINCHS;
    }

    public void setDisplayINCHS(int displayINCHS) {
        this.displayINCHS = displayINCHS;
    }

    public int getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(int memoryROM) {
        this.memoryROM = memoryROM;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
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
        return batteryCapacity == tabletPC.batteryCapacity && displayINCHS == tabletPC.displayINCHS && memoryROM == tabletPC.memoryROM && flashMemoryCapacity == tabletPC.flashMemoryCapacity && Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayINCHS, memoryROM, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayINCHS=" + displayINCHS +
                ", memoryROM=" + memoryROM +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
