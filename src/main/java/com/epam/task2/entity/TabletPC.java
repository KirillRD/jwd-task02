package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class TabletPC implements Appliance{
	private int batteryCapacity;
    private int displayINCHS;
    private int memoryROM;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC() {}

    public TabletPC(Map<String, Object> applianceData) {
        batteryCapacity = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()).toString());
        displayINCHS = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString());
        memoryROM = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString());
        flashMemoryCapacity = Integer.parseInt(applianceData.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()).toString());
        color = (String) applianceData.get(SearchCriteria.TabletPC.COLOR.toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(SearchCriteria.TabletPC.class.getSimpleName())) {
            return false;
        }

        Map<String, Object> criteriaTabletPC = criteria.getCriteria();

        boolean equal = !criteriaTabletPC.isEmpty();

        if (criteriaTabletPC.containsKey(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())) {
            int batteryCapacity = Integer.parseInt(criteriaTabletPC.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()).toString());
            equal = this.batteryCapacity == batteryCapacity && equal;
        }
        if (criteriaTabletPC.containsKey(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())) {
            int displayINCHS = Integer.parseInt(criteriaTabletPC.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString());
            equal = this.displayINCHS == displayINCHS && equal;
        }
        if (criteriaTabletPC.containsKey(SearchCriteria.TabletPC.MEMORY_ROM.toString())) {
            int memoryROM = Integer.parseInt(criteriaTabletPC.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString());
            equal = this.memoryROM == memoryROM && equal;
        }
        if (criteriaTabletPC.containsKey(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())) {
            int flashMemoryCapacity = Integer.parseInt(criteriaTabletPC.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()).toString());
            equal = this.flashMemoryCapacity == flashMemoryCapacity && equal;
        }
        if (criteriaTabletPC.containsKey(SearchCriteria.TabletPC.COLOR.toString())) {
            String color = (String) criteriaTabletPC.get(SearchCriteria.TabletPC.COLOR.toString());
            equal = this.color.equals(color) && equal;
        }
        return equal;
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
