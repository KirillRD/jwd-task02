package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Speakers implements Appliance{
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speakers() {}

    public Speakers(Map<String, Object> applianceData) {
        powerConsumption = Integer.parseInt(applianceData.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
        numberOfSpeakers = Integer.parseInt(applianceData.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()).toString());
        frequencyRange = (String) applianceData.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        cordLength = Integer.parseInt(applianceData.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
    }

    @Override
    public boolean containsCriteria(Criteria criteria) {
        if (!criteria.getTypeAppliance().equals(SearchCriteria.Speakers.class.getSimpleName())) {
            return false;
        }

        Map<String, Object> criteriaSpeakers = criteria.getCriteria();

        boolean equal = !criteriaSpeakers.isEmpty();

        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
            int powerConsumption = Integer.parseInt(criteriaSpeakers.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
            equal = this.powerConsumption == powerConsumption && equal;
        }
        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
            int numberOfSpeakers = Integer.parseInt(criteriaSpeakers.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()).toString());
            equal = this.numberOfSpeakers == numberOfSpeakers && equal;
        }
        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
            String frequencyRange = (String) criteriaSpeakers.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
            equal = this.frequencyRange.equals(frequencyRange) && equal;
        }
        if (criteriaSpeakers.containsKey(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
            int cordLength = Integer.parseInt(criteriaSpeakers.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
            equal = this.cordLength == cordLength && equal;
        }
        return equal;
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

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
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
        return powerConsumption == speakers.powerConsumption && numberOfSpeakers == speakers.numberOfSpeakers && cordLength == speakers.cordLength && Objects.equals(frequencyRange, speakers.frequencyRange);
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
