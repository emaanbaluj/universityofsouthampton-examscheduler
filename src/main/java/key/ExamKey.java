package key;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite key class for Exam entity.
 */
public class ExamKey implements Serializable {

    private String faculty;
    private String moduleName;
    private String title;

    // Default constructor
    public ExamKey() {
    }

    // Constructor with fields
    public ExamKey(String faculty, String moduleName, String title) {
        this.faculty = faculty;
        this.moduleName = moduleName;
        this.title = title;
    }

    // Getters and Setters
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

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamKey)) return false;
        ExamKey that = (ExamKey) o;
        return Objects.equals(getFaculty(), that.getFaculty()) &&
                Objects.equals(getModuleName(), that.getModuleName()) &&
                Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getModuleName(), getTitle());
    }
}