package ru.bolgov.task6.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReportCreatorTest {

    @Test
    public void testCreateReport() {
        HashMap<String, String> startMap = new HashMap<>();
        HashMap<String, String> endMap = new HashMap<>();
        HashMap<String, String> abbMap = new HashMap<>();

        startMap.put("SVF", "2018-05-24_12:02:50.917");
        startMap.put("NHR", "2018-05-24_12:02:49.914");
        startMap.put("FAM", "2018-05-24_12:13:04.512");
        startMap.put("KRF", "2018-05-24_12:03:01.250");
        startMap.put("SVM", "2018-05-24_12:18:37.735");
        startMap.put("MES", "2018-05-24_12:04:45.513");

        endMap.put("SVM", "2018-05-24_12:19:50.198");
        endMap.put("KRF", "2018-05-24_12:04:13.889");
        endMap.put("FAM", "2018-05-24_12:14:17.169");
        endMap.put("SVF", "2018-05-24_12:04:03.332");
        endMap.put("NHR", "2018-05-24_12:04:02.979");
        endMap.put("MES", "2018-05-24_12:05:58.778");

        abbMap.put("SVM", "_Stoffel Vandoorne_MCLAREN RENAULT");
        abbMap.put("KRF", "_Kimi Raikkonen_FERRARI");
        abbMap.put("FAM", "_Fernando Alonso_MCLAREN RENAULT");
        abbMap.put("SVF", "_Sebastian Vettel_FERRARI");
        abbMap.put("NHR", "_Nico Hulkenberg_RENAULT");
        abbMap.put("MES", "_Marcus Ericsson_SAUBER FERRARI");

        List<String> expectedList = Arrays.asList(
                new String[] { "01:12.415_Sebastian Vettel_FERRARI", 
                        "01:12.657_Fernando Alonso_MCLAREN RENAULT",
                        "01:13.065_Nico Hulkenberg_RENAULT", 
                        "01:13.265_Marcus Ericsson_SAUBER FERRARI",
                        "01:12.463_Stoffel Vandoorne_MCLAREN RENAULT", 
                        "01:12.639_Kimi Raikkonen_FERRARI" });

        ReportCreator testReport = new ReportCreator();
        List<String> actualList = testReport.createReport(startMap, endMap, abbMap);
        assertEquals(expectedList, actualList);

    }

}
