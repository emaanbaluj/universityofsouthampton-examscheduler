package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents an exam entity in the system.
 */
@Entity
@Table(name = "exams")
public class Exam {

    // Unique identifier for the exam, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Faculty associated with the exam (required).
    @Column(nullable = false)
    private String faculty;

    // Module name for the exam (required).
    @Column(nullable = false)
    private String moduleName;

    // Title of the exam (required).
    @Column(nullable = false)
    private String title;

    // Date on which the exam is scheduled (required).
    @Column(nullable = false)
    private LocalDate date;

    // Optional start time for the exam.
    @Column
    private LocalTime startTime;

    // Optional end time for the exam.
    @Column
    private LocalTime endTime;

    // Optional format of the exam (e.g., "online", "in-person").
    @Column
    private String format;

    /**
     * Default constructor required by JPA.
     */
    public Exam() {
    }

    /**
     * Constructor for partial initialization.
     *
     * @param faculty    the faculty associated with the exam.
     * @param moduleName the module name for the exam.
     * @param title      the title of the exam.
     * @param date       the date of the exam.
     */
    public Exam(String faculty, String moduleName, String title, LocalDate date) {
        this.faculty = faculty;
        this.moduleName = moduleName;
        this.title = title;
        this.date = date;
    }

    /**
     * Constructor for full initialization.
     *
     * @param faculty    the faculty associated with the exam.
     * @param moduleName the module name for the exam.
     * @param title      the title of the exam.
     * @param date       the date of the exam.
     * @param startTime  the start time of the exam.
     * @param endTime    the end time of the exam.
     * @param format     the format of the exam.
     */
    public Exam(String faculty, String moduleName, String title, LocalDate date, LocalTime startTime, LocalTime endTime, String format) {
        this.faculty = faculty;
        this.moduleName = moduleName;
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.format = format;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    // Equals and HashCode for comparing Exam objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam)) return false;
        Exam exam = (Exam) o;
        return Objects.equals(getId(), exam.getId()) &&
                Objects.equals(getFaculty(), exam.getFaculty()) &&
                Objects.equals(getModuleName(), exam.getModuleName()) &&
                Objects.equals(getTitle(), exam.getTitle()) &&
                Objects.equals(getDate(), exam.getDate()) &&
                Objects.equals(getStartTime(), exam.getStartTime()) &&
                Objects.equals(getEndTime(), exam.getEndTime()) &&
                Objects.equals(getFormat(), exam.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFaculty(), getModuleName(), getTitle(), getDate(), getStartTime(), getEndTime(), getFormat());
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", faculty='" + faculty + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", format='" + format + '\'' +
                '}';
    }
}