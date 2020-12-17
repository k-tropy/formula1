package ru.bolgov.task6.view;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {
    private static final int MAX_WIDTH_NUMBER = 4;
    private static final int MAX_WIDTH_NAME = 20;
    private static final int MAX_WIDTH_TEAM = 26;
    private static final int WIDTH_LINE = MAX_WIDTH_NAME + MAX_WIDTH_TEAM + 17;
    private static final int TOP_RACERS = 15;
    
    private static final DateTimeFormatter FORMATTER_OUT = DateTimeFormatter.ofPattern("mm:ss.SSS");

    private int count = 0;

    public String orderByTimeUnderlineTopRacers(List<String> report) {
        return report.stream()
                .sorted(orderByTime)
                .map(this::finalReportString)
                .collect(Collectors.joining("\n"));
    }

    Comparator<String> orderByTime = Comparator.comparing(s -> LocalTime.parse(s.substring(0, s.indexOf("_"))));
    
    private String finalReportString(String s) {
        StringBuilder result = new StringBuilder();
        String[] arrayStrings = s.split("_");
        String number = ++count + ".";

        result.append(number)
                .append(generateSequenceChars(MAX_WIDTH_NUMBER - number.length()))
                .append(arrayStrings[1])
                .append(generateSequenceChars(MAX_WIDTH_NAME - arrayStrings[1].length()))
                .append("| ")
                .append(arrayStrings[2])
                .append(generateSequenceChars(MAX_WIDTH_TEAM - arrayStrings[2].length()))
                .append("| ")
                .append((LocalTime.parse(arrayStrings[0])).format(FORMATTER_OUT));
        
        if (count == TOP_RACERS) {
            result.append("\n")
                  .append(generateSequenceChars(WIDTH_LINE, "-"));
        }
        
        return result.toString();
    }

    private String generateSequenceChars(int i) {
        return String.format("%" + i + "s", "");
    }

    private String generateSequenceChars(int i, String s) {
        return generateSequenceChars(i).replace(" ", s);
    }

}
