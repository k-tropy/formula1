package ru.bolgov.task6;

public class MainClass {
    public static void main(String[] args) {
        String logStart = "start.log";
        String logEnd = "end.log";
        String abbreviations = "abbreviations.txt";

        Controller controller = new Controller();
        controller.printReport(logStart, logEnd, abbreviations);

    }

}
