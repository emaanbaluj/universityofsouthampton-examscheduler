package controller;

import exception.ExamNotFoundException;
import model.Exam;
import key.ExamKey;
import service.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Exam entities.
 *
 * Provides endpoints for creating, retrieving, updating, and deleting exams.
 */
@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    /**
     * Constructor for ExamController.
     *
     * @param examService the ExamService instance for handling business logic.
     */
    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    /**
     * Creates a new exam.
     *
     * @param exam the Exam object containing details of the exam to be created.
     * @return ResponseEntity containing the created Exam and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Exam createdExam = examService.addExam(exam);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExam);
    }

    /**
     * Retrieves all exams.
     *
     * @return ResponseEntity containing a list of all Exam entities and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    /**
     * Retrieves a specific exam by its composite key.
     *
     * @param faculty    the faculty name of the exam.
     * @param moduleName the module name of the exam.
     * @param title      the title of the exam.
     * @return ResponseEntity containing the Exam entity and HTTP status 200 (OK).
     * @throws ExamNotFoundException if the exam with the given key does not exist.
     */
    @GetMapping("/{faculty}/{moduleName}/{title}")
    public ResponseEntity<Exam> getExam(@PathVariable String faculty,
                                        @PathVariable String moduleName,
                                        @PathVariable String title) {
        Exam exam = examService.findUniqueExam(faculty, moduleName, title);
        return ResponseEntity.ok(exam);
    }

    /**
     * Updates an existing exam identified by its composite key.
     *
     * @param faculty     the faculty name of the exam.
     * @param moduleName  the module name of the exam.
     * @param title       the title of the exam.
     * @param updatedExam the Exam object containing updated details.
     * @return ResponseEntity containing the updated Exam entity and HTTP status 200 (OK).
     * @throws ExamNotFoundException if the exam with the given key does not exist.
     */
    @PutMapping("/{faculty}/{moduleName}/{title}")
    public ResponseEntity<Exam> updateExam(@PathVariable String faculty,
                                           @PathVariable String moduleName,
                                           @PathVariable String title,
                                           @RequestBody Exam updatedExam) {
        ExamKey examKey = new ExamKey(faculty, moduleName, title);
        Exam updated = examService.updateExam(examKey, updatedExam);
        return ResponseEntity.ok(updated);
    }

    /**
     * Deletes an exam identified by its composite key.
     *
     * @param faculty    the faculty name of the exam.
     * @param moduleName the module name of the exam.
     * @param title      the title of the exam.
     * @return ResponseEntity with HTTP status 204 (No Content) if deletion is successful.
     * @throws ExamNotFoundException if the exam with the given key does not exist.
     */
    @DeleteMapping("/{faculty}/{moduleName}/{title}")
    public ResponseEntity<Void> deleteExam(@PathVariable String faculty,
                                           @PathVariable String moduleName,
                                           @PathVariable String title) {
        ExamKey examKey = new ExamKey(faculty, moduleName, title);
        examService.deleteExam(examKey);
        return ResponseEntity.noContent().build();
    }

    /**
     * Searches for exams by title.
     *
     * @param title the title or part of the title to search for.
     * @return ResponseEntity containing a list of Exam entities matching the search criteria and HTTP status 200 (OK).
     */
    @GetMapping("/search")
    public ResponseEntity<List<Exam>> searchExamsByTitle(@RequestParam String title) {
        List<Exam> exams = examService.findExamByTitle(title);
        return ResponseEntity.ok(exams);
    }
}