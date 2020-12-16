package ru.bolgov.task6;

import ru.bolgov.task6.model.FileReaderToMap;
import ru.bolgov.task6.model.ReportCreator;
import ru.bolgov.task6.view.Printer;

public class Controller {

    public void printReport(String logStart, String logEnd, String abbreviations) {
        
        FileReaderToMap startReader = new FileReaderToMap();
        startReader.readFileCreateMap(logStart);

        FileReaderToMap endReader = new FileReaderToMap();
        endReader.readFileCreateMap(logEnd);

        FileReaderToMap abbReader = new FileReaderToMap();
        abbReader.readFileCreateMap(abbreviations);

        ReportCreator reportCreator = new ReportCreator();
        reportCreator.createReport(startReader.getMapFileLines(), 
                                   endReader.getMapFileLines(),
                                   abbReader.getMapFileLines());

        Printer printer = new Printer();
        System.out.println(printer.orderByTimeUnderline15Racers(reportCreator.getReport()));

    }

}
