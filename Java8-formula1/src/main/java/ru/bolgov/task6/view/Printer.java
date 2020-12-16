package ru.bolgov.task6.view;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {
    private static final int MAX_WIDTH_NAME = 20;
    private static final int MAX_WIDTH_TEAM = 26;
    private static final int WIDTH_LINE = MAX_WIDTH_NAME + MAX_WIDTH_TEAM + 17;

    private int count = 0;

    public String orderByTimeUnderline15Racers(List<String> report) {
        return report.stream()
                .sorted(orderByTime)
                .map(this::finalRoportString)
                .collect(Collectors.joining("\n"));
    }

    Comparator<String> orderByTime = Comparator.comparing(s -> LocalTime.parse("00:" + s.substring(0, 9)));

    private String finalRoportString(String s) {
        StringBuilder result = new StringBuilder();
        String[] arrayStrings = s.split("_");
        String number;

        count += 1;
        if (count > 9) {
            number = count + ". ";
            if (16 == count) {
                result.append(generateSequenceChar(WIDTH_LINE, "-")).append("\n");
            }
        } else {
            number = count + ".  ";
        }

        result.append(number)
                .append(arrayStrings[1])
                .append(generateSequenceChar(MAX_WIDTH_NAME - arrayStrings[1].length()))
                .append("| ")
                .append(arrayStrings[2])
                .append(generateSequenceChar(MAX_WIDTH_TEAM - arrayStrings[2].length()))
                .append("| ")
                .append(arrayStrings[0]);

        return result.toString();
    }

    private String generateSequenceChar(int i) {
        return String.format("%" + i + "s", "");
    }

    private String generateSequenceChar(int i, String s) {
        return generateSequenceChar(i).replace(" ", s);
    }

}
