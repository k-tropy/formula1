package ru.bolgov.task6;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Printer {
    private static final int MAX_WIDTH_NUMBER = 4;
    private static final int MAX_WIDTH_NAME = 20;
    private static final int MAX_WIDTH_TEAM = 26;
    private static final int WIDTH_LINE = MAX_WIDTH_NAME + MAX_WIDTH_TEAM + 17;
    private static final int TOP_RACERS = 15;
    private static final DateTimeFormatter FORMATTER_OUT = DateTimeFormatter.ofPattern("mm:ss.SSS");
    private static final String COLUMN_SEPARATOR = "| ";

    private int count = 0;

    public String printReport(ReportCreator report) {
        Comparator<ResultOfLap> orderByTime = Comparator.comparing(ResultOfLap::getTime);
        return report.getReportMap().values().stream().sorted(orderByTime).map(this::lapResultToString).peek(System.out::println).collect(Collectors.joining("\n"));
        
    }

    private String lapResultToString(ResultOfLap resultOfLap) {
        StringBuilder result = new StringBuilder();
        String number = ++count + ".";

        result.append(number).append(createGaps(MAX_WIDTH_NUMBER - number.length()))
                .append(resultOfLap.getName()).append(createGaps(MAX_WIDTH_NAME - resultOfLap.getName().length())).append(COLUMN_SEPARATOR)
                .append(resultOfLap.getTeam()).append(createGaps(MAX_WIDTH_TEAM - resultOfLap.getTeam().length())).append(COLUMN_SEPARATOR)
                .append(FORMATTER_OUT.format(resultOfLap.getTime()));

        if (count == TOP_RACERS) {
            result.append("\n").append(createDashes(WIDTH_LINE));
        }

        return result.toString();
    }

    private String createGaps(int i) {
        return String.format("%" + i + "s", "");
    }

    private String createDashes(int i) {
        return createGaps(i).replace(" ", "-");
    }

} 
