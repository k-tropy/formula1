package ru.bolgov.task6.view;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss.SSS");
    int count = 0;

    public String orderByTimeUnderline15Racers(List<String> report) {

        report = lapTimeCounter(report);
        report = orderByTime(report);

        final StringBuilder result = new StringBuilder("");
        report.stream().map(x -> finalRoportString(x)).forEach(x -> result.append(x).append("\n"));

        return result.toString();
    }

    private List<String> lapTimeCounter(List<String> reportStartEndTime) {
        ArrayList<String> result = (ArrayList<String>) reportStartEndTime.stream().map(x -> {
            String[] line = x.split("_");
            String lapTime = countLapTime(line[0], line[1]);
            return lapTime + "_" + line[2] + "_" + line[3];
        }).collect(Collectors.toList());
        return result;
    }

    private String countLapTime(String start, String end) {
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(end);
        return (endTime.minusHours(startTime.getHour()).minusMinutes(startTime.getMinute())
                .minusSeconds(startTime.getSecond()).minusNanos(startTime.getNano())).format(formatter);
    }

    private List<String> orderByTime(List<String> reportLapTime) {
        return reportLapTime.stream().sorted((x, y) -> {
            LocalTime time1 = LocalTime.parse("00:" + x.substring(0, 9));
            LocalTime time2 = LocalTime.parse("00:" + y.substring(0, 9));
            return time1.isBefore(time2) ? -1 : (time2.isBefore(time1) ? 1 : 0);
        }).collect(Collectors.toList());

    }

    private String finalRoportString(String s) {
        StringBuilder result = new StringBuilder();
        String[] arrayStrings = s.split("_");
        count += 1;
        String number = count < 10 ? count + ".  " : count + ". ";
        result.append(number).append(arrayStrings[1])
                .append(String.format("%" + (18 - arrayStrings[1].length()) + "s", ""))// Добавить константу 21
                .append("| ").append(arrayStrings[2])
                .append(String.format("%" + (26 - arrayStrings[2].length()) + "s", ""))// добавить константу 26
                .append("| ").append(arrayStrings[0]);
        return result.toString();
    }

}
