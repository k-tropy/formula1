package ru.bolgov.task6;

import java.util.List;
import java.util.Map;

import ru.bolgov.task6.model.MapCreatorWithKeyAbbreviation;
import ru.bolgov.task6.model.ReportCreator;
import ru.bolgov.task6.view.Printer;

public class Controller {

    public void printReport(String logStart, String logEnd, String abbreviations) {
        
        MapCreatorWithKeyAbbreviation startReader = new MapCreatorWithKeyAbbreviation();
        Map<String, String> startMap = startReader.createMap(logStart);

        MapCreatorWithKeyAbbreviation endReader = new MapCreatorWithKeyAbbreviation();
        Map<String, String> endMap = endReader.createMap(logEnd);

        MapCreatorWithKeyAbbreviation abbReader = new MapCreatorWithKeyAbbreviation();
        Map<String, String> abbMap = abbReader.createMap(abbreviations);

        ReportCreator reportCreator = new ReportCreator();
        List<String> report = reportCreator.createReport(startMap, endMap, abbMap);

        Printer printer = new Printer();
        System.out.println(printer.orderByTimeUnderlineTopRacers(report));

    }

}
