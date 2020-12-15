package ru.bolgov.task6.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportCreater {
    private final ArrayList<String> report;

    public ReportCreater() {
        this.report = new ArrayList<>();
    }

    public ArrayList<String> getReport() {
        return report;
    }

    public ArrayList<String> createReport(Map<String, String> startMap, Map<String, String> endMap,
            Map<String, String> abbMap) {
        for (Map.Entry<String, String> s : abbMap.entrySet()) {
            String key = s.getKey();
            String abbExplanation = s.getValue();
            String startTime = takeTime(key, startMap);
            String endTime = takeTime(key, endMap);
            report.add(startTime.concat("_").concat(endTime).concat(abbExplanation));

        }

        // переписать по возможности на java 8
        /*
         * abbMap.entrySet().stream() .forEach(x->x.getKey());
         */
        return report;
    }

    private String takeTime(String key, Map<String, String> map) {
        String value = map.get(key);
        return value.substring(11, value.length());
    }

}
