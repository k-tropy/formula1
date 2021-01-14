package ru.bolgov.task6;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ReportCreatorTest {
    String startFileName = "startTest.log";
    String endFileName = "endTest.log";
    String abbFileName = "abbreviationsTest.txt";

    @Test
    public void testCreateReport() {
        Map<String, LapResult> expectedMap = new HashMap<>();
        LapResult ricciardoLapResult = new LapResult("Daniel Ricciardo", "RED BULL RACING TAG HEUER",
                LocalDateTime.parse("2018-05-24T00:01:12.013"), LocalDateTime.parse("2018-05-24T12:14:12.054"),
                LocalDateTime.parse("2018-05-24T12:15:24.067"));
        LapResult vettelLapResult = new LapResult("Sebastian Vettel", "FERRARI",
                LocalDateTime.parse("2018-05-24T00:01:12.415"), LocalDateTime.parse("2018-05-24T12:02:50.917"),
                LocalDateTime.parse("2018-05-24T12:04:03.332"));
        LapResult hamiltonLapResult = new LapResult("Lewis Hamilton", "MERCEDES",
                LocalDateTime.parse("2018-05-24T00:01:12.460"), LocalDateTime.parse("2018-05-24T12:18:20.125"),
                LocalDateTime.parse("2018-05-24T12:19:32.585"));
        LapResult raikkonenLapResult = new LapResult("Kimi Raikkonen", "FERRARI",
                LocalDateTime.parse("2018-05-24T00:01:12.639"), LocalDateTime.parse("2018-05-24T12:03:01.250"),
                LocalDateTime.parse("2018-05-24T12:04:13.889"));

        expectedMap.put("DRR", ricciardoLapResult);
        expectedMap.put("SVF", vettelLapResult);
        expectedMap.put("LHM", hamiltonLapResult);
        expectedMap.put("KRF", raikkonenLapResult);

        ReportCreator reportCreator = new ReportCreator();
        Map<String, LapResult> actualMap = reportCreator.createReport(startFileName, endFileName, abbFileName);

        assertEquals(expectedMap, actualMap);
    }

}
