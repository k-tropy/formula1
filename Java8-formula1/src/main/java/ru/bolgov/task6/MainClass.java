package ru.bolgov.task6;

public class MainClass {
    public static void main(String[] args) {
        String logStart = "start.log";
        String logEnd = "end.log";
        String abbreviations = "abbreviations.txt";

        ReportCreator report = new ReportCreator();
        report.createReport(logStart, logEnd, abbreviations);

        new Printer().printReport(report);
                
    }

}
