package ru.bolgov.task6;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReportCreator {
    private static final int INDEX_BEGINNING_ABBREVATION = 0;
    private static final int INDEX_BEGINNING_INFORMATION = 3;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    private final Map<String, ResultOfLap> reportMap;

    public ReportCreator() {
        this.reportMap = new HashMap<>();
    }

    public Map<String, ResultOfLap> getReportMap() {
        return reportMap;
    }

    public Map<String, ResultOfLap> createReport(String startFileName, String endFileName, String abbFileName) {
        loadDataFromAbbreviationFile(abbFileName);
        loadDataFromStartFile(startFileName);
        loadDataFromEndFile(endFileName);
        calculateLapTime();
        return this.reportMap;
    }

    private void loadDataFromAbbreviationFile(String abbreviation) {
        try (Stream<String> lines = Files.lines(takeFilePath(abbreviation))) {
            lines.forEach(x -> {
                String[] substrings = x.split("_");
                ResultOfLap resultOfLap = new ResultOfLap(substrings[1], substrings[2]);
                this.reportMap.put(takeKey(x), resultOfLap);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataFromStartFile(String startFile) {
        try (Stream<String> lines = Files.lines(takeFilePath(startFile))) {
            lines.forEach(x -> this.reportMap.get(takeKey(x)).setStart(takeTime(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataFromEndFile(String endFile) {
         try (Stream<String> lines = Files.lines(takeFilePath(endFile))) {
            lines.forEach(x -> this.reportMap.get(takeKey(x)).setEnd(takeTime(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculateLapTime() {
        this.reportMap.entrySet().stream().forEach(x -> {
            ResultOfLap result = x.getValue();
            LocalDateTime startTime = result.getStart();
            LocalDateTime endTime = result.getEnd();
            LocalDateTime lapTime = endTime.minusHours(startTime.getHour()).minusMinutes(startTime.getMinute())
                    .minusSeconds(startTime.getSecond()).minusNanos(startTime.getNano());
            result.setTime(lapTime);
        });
    }
    
    private String takeKey(String s){
        return s.substring(INDEX_BEGINNING_ABBREVATION, INDEX_BEGINNING_INFORMATION);
    }
    
    private LocalDateTime takeTime(String s) {
        return LocalDateTime.parse(s.substring(INDEX_BEGINNING_INFORMATION), FORMATTER);
    }
    
    private Path takeFilePath(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);
        return Paths.get(url.getPath().substring(1));
    }
}
