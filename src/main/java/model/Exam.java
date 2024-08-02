package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {
    private final String faculty;
    private final String moduleName;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String format;

    // Constructor for partial initialization
    public Exam(String faculty, String moduleName, LocalDate date) {
        this.faculty = faculty;
        this.moduleName = moduleName;
        this.date = date;
        this.startTime = null;
        this.endTime = null;
        this.format = null;
    }

    // Constructor for full initialization
    public Exam(String faculty, String moduleName, LocalDate date, LocalTime startTime, LocalTime endTime, String format) {
        this.faculty = faculty;
        this.moduleName = moduleName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.format = format;
    }

    // Getters
    public String getFaculty() {
        return faculty;
    }

    public String getModuleName() {
        return moduleName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getFormat() {
        return format;
    }
}
