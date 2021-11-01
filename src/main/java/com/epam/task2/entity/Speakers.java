package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that describe an entity appliance of the Speakers type
 * @author Kirill Ryabov
 */
public class Speakers extends Appliance{
    /**
     * Field describes the power consumption property
     */
    private double powerConsumption;
    /**
     * Field describes the number of speakers property
     */
    private double numberOfSpeakers;
    /**
     * Field describes the frequency range property
     */
    private String frequencyRange;
    /**
     * Field describes the cord length property
     */
    private double cordLength;

    /**
     * Default constructor
     */
    public Speakers() {}

    /**
     * Constructor that sets the value of all fields
     * @param powerConsumption value of the power consumption field
     * @param numberOfSpeakers value of the number of speakers field
     * @param frequencyRange value of the frequency range field
     * @param cordLength value of the cord length field
     */
    public Speakers(double powerConsumption, double numberOfSpeakers, String frequencyRange, double cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    /**
     * Constructor that sets the value of all fields
     * @param applianceData HashMap with fields names(keys) and their values(values)
     */
    public Speakers(Map<String, Object> applianceData) {
        powerConsumption = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
        numberOfSpeakers = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()).toString());
        frequencyRange = (String) applianceData.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        cordLength = Double.parseDouble(applianceData.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
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
        doubleFields.put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), powerConsumption);
        doubleFields.put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), numberOfSpeakers);
        doubleFields.put(SearchCriteria.Speakers.CORD_LENGTH.toString(), cordLength);

        Map<String, String> stringFields = new HashMap<String, String>();
        stringFields.put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), frequencyRange);

        return checkFieldsByCriteria(criteria, doubleFields, stringFields);
    }

    /**
     * Method that returns value of the power consumption field
     * @return value of the power consumption field
     */
    public double getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * Method that sets the value of the power consumption field
     * @param powerConsumption value of the power consumption field
     */
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    /**
     * Method that returns value of the number of speakers field
     * @return value of the number of speakers field
     */
    public double getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    /**
     * Method that sets the value of the number of speakers field
     * @param numberOfSpeakers value of the number of speakers field
     */
    public void setNumberOfSpeakers(double numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    /**
     * Method that returns value of the frequency range field
     * @return value of the frequency range field
     */
    public String getFrequencyRange() {
        return frequencyRange;
    }

    /**
     * Method that sets the value of the frequency range field
     * @param frequencyRange value of the frequency range field
     */
    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    /**
     * Method that returns value of the cord length field
     * @return value of the cord length field
     */
    public double getCordLength() {
        return cordLength;
    }

    /**
     * Method that sets the value of the cord length field
     * @param cordLength value of the cord length field
     */
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
