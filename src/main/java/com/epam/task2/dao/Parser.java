package com.epam.task2.dao;

import java.util.HashMap;
import java.util.Map;

public final class Parser {
    private Parser() {}

    public static Map<String, Object> getMapOfCriteria(String nameAppliance, String line) {
        if(!(line.contains(nameAppliance))) {
            return null;
        }
        Map<String, Object> mapOfCriteria = new HashMap<String, Object>();

        line = line.replaceAll("\\s+", "");

        int indexPosition = 0;
        int indexFirst = line.indexOf(":", indexPosition);
        int indexEqual = line.indexOf("=", indexPosition);
        int indexLast = line.indexOf(",", indexPosition);

        while(indexLast != -1) {
            String nameCriteria = line.substring(indexFirst+1, indexEqual);
            Object value = line.substring(indexEqual+1, indexLast);
            mapOfCriteria.put(nameCriteria, value);

            indexPosition = indexLast+1;
            indexFirst = indexLast;
            indexEqual = line.indexOf("=", indexPosition);
            indexLast = line.indexOf(",", indexPosition);

            if(indexLast == -1) {
                nameCriteria = line.substring(indexFirst+1, indexEqual);
                value = line.substring(indexEqual+1, line.length());
                mapOfCriteria.put(nameCriteria, value);
            }
        }
        return mapOfCriteria;
    }
}
