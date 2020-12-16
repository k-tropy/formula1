package ru.bolgov.task6.model;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileReaderToMap {
    private final Map<String, String> mapFileLines;

    public Map<String, String> getMapFileLines() {
        return mapFileLines;
    }

    public FileReaderToMap() {
        this.mapFileLines = new HashMap<>();
    }

    public Map<String, String> readFileCreateMap(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);//Как переписать путь?

        try (Stream<String> lines = Files.lines(Paths.get(url.getPath().substring(1)))) {
            lines.forEach(x -> mapFileLines.put(x.substring(0, 3), x.substring(3, x.length())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapFileLines;

    }
}