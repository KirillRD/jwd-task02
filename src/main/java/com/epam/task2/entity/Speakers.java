package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Speakers extends Appliance{
    private double powerConsumption;
    private double numberOfSpeakers;
    private String frequencyRange;
    private double cordLength;

    public Speakers() {}

    public Speakers(double powerConsumption, double numberOfSpeakers, String frequencyRange, double cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public Speakers(Map<String, Object> applianceData) {
        powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
        numberOfSpeakers = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()).toString());
        frequencyRange = (String) applianceData.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        cordLength = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(this.getClass().getSimpleName())) {
            return false;
        }

        Map<String, Double> doubleFields = new HashMap<String, Double>();
        doubleFields.put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), powerConsumption);
        doubleFields.put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), numberOfSpeakers);
        doubleFields.put(SearchCriteria.Speakers.CORD_LENGTH.toString(), cordLength);

        Map<String, String> stringFields = new HashMap<String, String>();
        stringFields.put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), frequencyRange);

        return checkFieldsByCriteria(criteria, doubleFields, stringFields);
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(double numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return Double.compare(speakers.powerConsumption, powerConsumption) == 0 && Double.compare(speakers.numberOfSpeakers, numberOfSpeakers) == 0 && Double.compare(speakers.cordLength, cordLength) == 0 && Objects.equals(frequencyRange, speakers.frequencyRange);
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
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}
