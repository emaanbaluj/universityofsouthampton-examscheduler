package examscheduler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The Exam class represents an exam entity with attributes such as faculty, module name, title, date, start time, end time, and format.
 * It is mapped to a database table named "uosexams".
 */
@Entity
@Table(name = "uosexams")  // This will create a table named "uosexams" in the database
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String faculty;
    private String moduleName;
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;

    private String format;

    // Default constructor
    public Exam() {}

    /**
     * Constructs a new Exam with the specified details.
     *
     * @param faculty the faculty responsible for the exam
     * @param moduleName the name of the module for which the exam is conducted
     * @param title the title of the exam
     * @param date the date of the exam
     * @param startTime the start time of the exam
     * @param endTime the end time of the exam
     * @param format the format of the exam (e.g., in-person, online)
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

    /**
     * Gets the ID of the exam.
     *
     * @return the exam ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the faculty responsible for the exam.
     *
     * @return the faculty name
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty responsible for the exam.
     *
     * @param faculty the new faculty name
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Gets the module name for the exam.
     *
     * @return the module name
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets the module name for the exam.
     *
     * @param moduleName the new module name
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * Gets the title of the exam.
     *
     * @return the exam title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the exam.
     *
     * @param title the new exam title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the date of the exam.
     *
     * @return the exam date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the exam.
     *
     * @param date the new exam date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the start time of the exam.
     *
     * @return the start time of the exam
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the exam.
     *
     * @param startTime the new start time
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time of the exam.
     *
     * @return the end time of the exam
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the exam.
     *
     * @param endTime the new end time
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the format of the exam (e.g., in-person, online).
     *
     * @return the exam format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the exam.
     *
     * @param format the new exam format
     */
    public void setFormat(String format) {
        this.format = format;
    }
}