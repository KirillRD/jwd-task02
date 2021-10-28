package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Speakers implements Appliance{
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
        if (!criteria.getTypeAppliance().equals(SearchCriteria.Speakers.class.getSimpleName())) {
            return false;
        }

        Map<String, Object> criteriaSpeakers = criteria.getCriteria();

        boolean equal = !criteriaSpeakers.isEmpty();

        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
            double powerConsumption = Double.parseDouble(criteriaSpeakers.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
            equal = this.powerConsumption == powerConsumption && equal;
        }
        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
            double numberOfSpeakers = Double.parseDouble(criteriaSpeakers.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()).toString());
            equal = this.numberOfSpeakers == numberOfSpeakers && equal;
        }
        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
            String frequencyRange = (String) criteriaSpeakers.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
            equal = this.frequencyRange.equals(frequencyRange) && equal;
        }
        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
            double cordLength = Double.parseDouble(criteriaSpeakers.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
            equal = this.cordLength == cordLength && equal;
        }
        return equal;
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
