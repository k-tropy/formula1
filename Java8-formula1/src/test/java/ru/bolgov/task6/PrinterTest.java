package ru.bolgov.task6;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class PrinterTest {

    @Test
    public void testPrintReport() {
        ReportCreator report = mock(ReportCreator.class);
        Map<String, LapResult> reportMap = new HashMap<>();
        when(report.getReportMap()).thenReturn(reportMap);
        
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
        reportMap.put("DRR", ricciardoLapResult);
        reportMap.put("SVF", vettelLapResult);
        reportMap.put("LHM", hamiltonLapResult);
        reportMap.put("KRF", raikkonenLapResult);

        String actualString = new Printer().printReport(report);
        String expectedString = "1.  Daniel Ricciardo    | RED BULL RACING TAG HEUER | 01:12.013\n"
                + "2.  Sebastian Vettel    | FERRARI                   | 01:12.415\n"
                + "3.  Lewis Hamilton      | MERCEDES                  | 01:12.460\n"
                + "4.  Kimi Raikkonen      | FERRARI                   | 01:12.639";

        assertEquals(expectedString, actualString);
    }

} 
