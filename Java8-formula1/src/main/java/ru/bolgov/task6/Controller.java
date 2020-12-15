package ru.bolgov.task6;

import ru.bolgov.task6.model.AbbreviationKeyMapCreator;
import ru.bolgov.task6.model.FileReaderToList;
import ru.bolgov.task6.model.ReportCreater;
import ru.bolgov.task6.view.Printer;

public class Controller {

    public void printReport(String logStart, String logEnd, String abbreviations) {
        FileReaderToList startReader = new FileReaderToList();
        startReader.readFileCreateList(logStart);
        AbbreviationKeyMapCreator startMapCreator = new AbbreviationKeyMapCreator();
        startMapCreator.createMap(startReader.getListFileLines());

        FileReaderToList endReader = new FileReaderToList();
        endReader.readFileCreateList(logEnd);
        AbbreviationKeyMapCreator endMapCreator = new AbbreviationKeyMapCreator();
        endMapCreator.createMap(endReader.getListFileLines());

        FileReaderToList abbReader = new FileReaderToList();
        abbReader.readFileCreateList(abbreviations);
        AbbreviationKeyMapCreator abbMapCreator = new AbbreviationKeyMapCreator();
        abbMapCreator.createMap(abbReader.getListFileLines());

        ReportCreater reportCreater = new ReportCreater();
        reportCreater.createReport(startMapCreator.getAbbreviationKeyMap(), endMapCreator.getAbbreviationKeyMap(),
                abbMapCreator.getAbbreviationKeyMap());

        Printer printer = new Printer();
        System.out.println(printer.orderByTimeUnderline15Racers(reportCreater.getReport()));

    }

}
