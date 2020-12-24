package ru.bolgov.task6;

import java.time.LocalDateTime;

public class ResultOfLap {
    private final String name;
    private final String team;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime time;

    public ResultOfLap(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

}
