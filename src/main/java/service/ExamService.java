package service;

import model.Exam;
import key.ExamKey;
import org.springframework.stereotype.Service;
import repository.ExamRepository;
import exception.ExamNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Exam entities.
 * This class provides business logic and operations related to Exam objects.
 */
@Service
public class ExamService {

    private final ExamRepository examRepository;

    /**
     * Constructor-based dependency injection.
     *
     * @param examRepository the repository for accessing Exam data.
     */
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    /**
     * Retrieves all exams.
     *
     * @return a list of all exams.
     */
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    /**
     * Finds exams by title containing the specified string (case-insensitive).
     *
     * @param title the title or part of the title to search for.
     * @return a list of exams with titles matching the search criteria.
     */
    public List<Exam> findExamByTitle(String title) {
        return examRepository.findByTitleContainingIgnoreCase(title);
    }

    /**
     * Finds exams by faculty name containing the specified string (case-insensitive).
     *
     * @param faculty the faculty or part of the faculty name to search for.
     * @return a list of exams with faculty names matching the search criteria.
     */
    public List<Exam> findExamByFaculty(String faculty) {
        return examRepository.findByFacultyContainingIgnoreCase(faculty);
    }

    /**
     * Finds exams by module name containing the specified string (case-insensitive).
     *
     * @param moduleName the module name or part of it to search for.
     * @return a list of exams with module names matching the search criteria.
     */
    public List<Exam> findExamByModuleName(String moduleName) {
        return examRepository.findByModuleNameContainingIgnoreCase(moduleName);
    }

    /**
     * Finds a unique exam by faculty, module name, and title.
     *
     * @param faculty    the faculty name.
     * @param moduleName the module name.
     * @param title      the exam title.
     * @return the found exam or throws ExamNotFoundException if not found.
     */
    public Exam findUniqueExam(String faculty, String moduleName, String title) {
        return examRepository.findByFacultyAndModuleNameAndTitle(faculty, moduleName, title)
                .orElseThrow(() -> new ExamNotFoundException("Exam not found for faculty: "
                        + faculty + ", moduleName: " + moduleName + ", title: " + title));
    }

    /**
     * Adds a new exam to the database.
     *
     * @param newExam the exam to be added.
     * @return the saved exam.
     */
    public Exam addExam(Exam newExam) {
        return examRepository.save(newExam);
    }

    /**
     * Updates an existing exam identified by its composite key.
     *
     * @param examKey     the composite key of the exam to update.
     * @param updatedExam the updated exam details.
     * @return the updated exam.
     * @throws ExamNotFoundException if the exam is not found.
     */
    public Exam updateExam(ExamKey examKey, Exam updatedExam) {
        // Fetch the existing exam using the composite key
        Exam existingExam = examRepository.findByFacultyAndModuleNameAndTitle(
                        examKey.getFaculty(), examKey.getModuleName(), examKey.getTitle())
                .orElseThrow(() -> new ExamNotFoundException("Exam not found for faculty: "
                        + examKey.getFaculty() + ", moduleName: " + examKey.getModuleName()
                        + ", title: " + examKey.getTitle()));

        // Update the fields of the existing exam
        existingExam.setFaculty(updatedExam.getFaculty());
        existingExam.setModuleName(updatedExam.getModuleName());
        existingExam.setTitle(updatedExam.getTitle());
        existingExam.setDate(updatedExam.getDate());
        existingExam.setStartTime(updatedExam.getStartTime());
        existingExam.setEndTime(updatedExam.getEndTime());
        existingExam.setFormat(updatedExam.getFormat());

        // Save and return the updated exam
        return examRepository.save(existingExam);
    }

    /**
     * Deletes an exam identified by its composite key.
     *
     * @param examKey the composite key of the exam to delete.
     * @throws ExamNotFoundException if the exam is not found.
     */
    public void deleteExam(ExamKey examKey) {
        Optional<Exam> deletedExam = examRepository.findByFacultyAndModuleNameAndTitle(
                examKey.getFaculty(), examKey.getModuleName(), examKey.getTitle());

        if (deletedExam.isPresent()) {
            examRepository.deleteByFacultyAndModuleNameAndTitle(
                    examKey.getFaculty(), examKey.getModuleName(), examKey.getTitle());
        } else {
            throw new ExamNotFoundException("Exam not found for faculty: "
                    + examKey.getFaculty() + ", moduleName: " + examKey.getModuleName()
                    + ", title: " + examKey.getTitle());
        }
    }
}