package ru.bolgov.task6.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class FileReaderToMapTest {

    @Test
    public void testReadFileCreateMap() {
        String testFileName = "testFileForReader.log";
        HashMap<String, String> expectedMap = new HashMap<>();
        
        expectedMap.put("SVF", "2018-05-24_12:02:50.917");
        expectedMap.put("NHR", "2018-05-24_12:02:49.914");
        expectedMap.put("FAM", "2018-05-24_12:13:04.512");
        expectedMap.put("KRF", "2018-05-24_12:03:01.250");
        expectedMap.put("SVM", "2018-05-24_12:18:37.735");
        expectedMap.put("MES", "2018-05-24_12:04:45.513");
        
        FileReaderToMap testReader = new FileReaderToMap();
        
        Map<String, String> actualMap = testReader.readFileCreateMap(testFileName);
        assertEquals(expectedMap, actualMap);
        
    }

}
