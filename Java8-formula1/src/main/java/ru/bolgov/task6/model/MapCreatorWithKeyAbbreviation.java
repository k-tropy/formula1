package ru.bolgov.task6.model;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MapCreatorWithKeyAbbreviation {
    private static final int INDEX_BEGINNING_ABBREVATION = 0;
    private static final int INDEX_BEGINNING_INFORMATION = 3;

    public Map<String, String> createMap(String fileName) {
        HashMap<String, String> mapFileLines = new HashMap<>();

        URL url = getClass().getClassLoader().getResource(fileName);

        try (Stream<String> lines = Files.lines(Paths.get(url.getPath().substring(1)))) {
            lines.forEach(x -> mapFileLines.put(x.substring(INDEX_BEGINNING_ABBREVATION, INDEX_BEGINNING_INFORMATION),
                    x.substring(INDEX_BEGINNING_INFORMATION)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapFileLines;

    }
}
