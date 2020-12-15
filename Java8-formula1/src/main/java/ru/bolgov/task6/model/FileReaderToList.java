package ru.bolgov.task6.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileReaderToList {
    private final List<String> listFileLines;

    public List<String> getListFileLines() {
        return listFileLines;
    }

    public FileReaderToList() {
        this.listFileLines = new ArrayList<>();
    }

    public List<String> readFileCreateList(String fileName) {

        URL url = getClass().getClassLoader().getResource(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(url.getPath())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.listFileLines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return this.listFileLines;

    }

}
