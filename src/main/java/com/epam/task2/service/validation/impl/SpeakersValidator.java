package com.epam.task2.service.validation.impl;

import com.epam.task2.entity.Appliance;
import com.epam.task2.entity.Speakers;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.entity.criteria.SearchCriteria;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.validation.ApplianceValidator;

import java.util.List;
import java.util.Map;

public class SpeakersValidator extends ApplianceValidator {
    public SpeakersValidator() {}

    @Override
    public void isCriteriaValid(Criteria criteria) throws ServiceException {
        Map<String, List<Object>> criteriaAppliance = criteria.getCriteria();

        for (String key : criteriaAppliance.keySet()) {
            try {
                switch (SearchCriteria.Speakers.valueOf(key)) {
                    case POWER_CONSUMPTION:
                    case NUMBER_OF_SPEAKERS:
                    case CORD_LENGTH:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            isPossibleDoubleValue(criteriaAppliance.get(key).get(i));
                        }
                        break;
                    case FREQUENCY_RANGE:
                        for (int i = 0; i < criteriaAppliance.get(key).size(); i++) {
                            if (!isFrequencyRangeValid(criteriaAppliance.get(key).get(i))) {
                                throw new ServiceException("Frequency range \"" + criteriaAppliance.get(key).get(i) + "\" isn't valid");
                            }
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                throw new ServiceException("Criteria don't have \"" + key + "\" field");
            }
        }
    }

    @Override
    public void isApplianceValid(Appliance appliance) throws ServiceException {
        Speakers speakers = (Speakers) appliance;
        isPossibleDoubleValue(speakers.getPowerConsumption());
        isPossibleDoubleValue(speakers.getNumberOfSpeakers());
        isPossibleDoubleValue(speakers.getCordLength());
        if (!isFrequencyRangeValid(speakers.getFrequencyRange())) {
            throw new ServiceException("Frequency range \"" + speakers.getFrequencyRange() + "\" doesn't valid");
        }
    }

    private boolean isFrequencyRangeValid(Object value) {
        String line = value.toString();
        int position = line.indexOf("-");
        if (position == -1) {
            return false;
        }
        double min;
        double max;
        try {
            min = Double.parseDouble(line.substring(0, position));
            max = Double.parseDouble(line.substring(position+1));
        } catch (NumberFormatException e) {
            return false;
        }
        return min < max;
    }
}
