package ru.bolgov.task6.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreator {
    private static final DateTimeFormatter FORMATTER_OUT = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private static final DateTimeFormatter FORMATTER_IN = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public List<String> createReport(Map<String, String> startMap, Map<String, String> endMap,
            Map<String, String> abbMap) {

        ArrayList<String> report = new ArrayList<>();

        abbMap.entrySet().stream().forEach(s -> {
            String key = s.getKey();
            report.add(countLapTime(startMap.get(key), endMap.get(key)).concat(s.getValue()));
        });

        return report;
    }

    private String countLapTime(String start, String end) {
        LocalDateTime startTime = LocalDateTime.parse(start, FORMATTER_IN);
        LocalDateTime endTime = LocalDateTime.parse(end, FORMATTER_IN);
        return (endTime.minusHours(startTime.getHour()).minusMinutes(startTime.getMinute())
                .minusSeconds(startTime.getSecond()).minusNanos(startTime.getNano())).format(FORMATTER_OUT);
    }

}
