package ru.bolgov.task6;

import java.time.LocalDateTime;

public class LapResult {
    private final String name;
    private final String team;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime time;

    public LapResult(String name, String team) {
        this.name = name;
        this.team = team;
    }
    
    public LapResult(String name, String team, LocalDateTime time, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.team = team;
        this.start = start;
        this.end = end;
        this.time = time;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        result = prime * result + ((team == null) ? 0 : team.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        LapResult other = (LapResult) obj;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        if (team == null) {
            if (other.team != null)
                return false;
        } else if (!team.equals(other.team))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }

}
