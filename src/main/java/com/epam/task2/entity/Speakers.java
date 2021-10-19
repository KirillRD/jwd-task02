package com.epam.task2.entity;

import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Speakers extends Appliance{
    private int powerConsumption;
    private int numberOfSpeakers;
    private double frequencyRange;
    private int cordLength;

    public Speakers(Map<String, Object> applianceData) {
        powerConsumption = Integer.parseInt(applianceData.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
        numberOfSpeakers = Integer.parseInt(applianceData.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()).toString());
        frequencyRange = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()).toString());
        cordLength = Integer.parseInt(applianceData.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(double frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption && numberOfSpeakers == speakers.numberOfSpeakers && Double.compare(speakers.frequencyRange, frequencyRange) == 0 && cordLength == speakers.cordLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange=" + frequencyRange +
                ", cordLength=" + cordLength +
                '}';
    }
}
