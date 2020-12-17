package ru.bolgov.task6.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PrinterTest {

    @Test
    public void testOrderByTimeUnderline15Racers() {
        List<String> report = Arrays.asList(
                new String[] { "01:12.415_Sebastian Vettel_FERRARI", 
                        "01:12.657_Fernando Alonso_MCLAREN RENAULT",
                        "01:13.065_Nico Hulkenberg_RENAULT", 
                        "01:13.265_Marcus Ericsson_SAUBER FERRARI",
                        "01:12.463_Stoffel Vandoorne_MCLAREN RENAULT", 
                        "01:12.639_Kimi Raikkonen_FERRARI" });
        
        Printer printer = new Printer();
        String actual = printer.orderByTimeUnderlineTopRacers(report);
        String expected = "1.  Sebastian Vettel    | FERRARI                   | 01:12.415\n" + 
                "2.  Stoffel Vandoorne   | MCLAREN RENAULT           | 01:12.463\n" + 
                "3.  Kimi Raikkonen      | FERRARI                   | 01:12.639\n" + 
                "4.  Fernando Alonso     | MCLAREN RENAULT           | 01:12.657\n" + 
                "5.  Nico Hulkenberg     | RENAULT                   | 01:13.065\n" + 
                "6.  Marcus Ericsson     | SAUBER FERRARI            | 01:13.265";
        assertEquals(expected, actual);
    }

}
