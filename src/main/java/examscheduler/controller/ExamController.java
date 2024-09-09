package examscheduler.controller;

import examscheduler.model.Exam;
import examscheduler.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Exam entities.
 * Provides endpoints to create, retrieve, update, and delete exams.
 */
@RestController
@RequestMapping("/exams")
public class ExamController {

    private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private ExamService examService;

    /**
     * Creates a new exam.
     *
     * @param exam the exam details to be created
     * @return ResponseEntity containing the created exam
     */
    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        logger.info("Received request to create a new exam: {}", exam);
        Exam createdExam = examService.createExam(exam);
        logger.info("Exam created successfully with ID: {}", createdExam.getId());
        return ResponseEntity.ok(createdExam);
    }

    /**
     * Retrieves a specific exam by its ID.
     *
     * @param id the ID of the exam to retrieve
     * @return ResponseEntity containing the found exam or a 404 Not Found status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        logger.info("Received request to get exam by ID: {}", id);
        Optional<Exam> exam = examService.getExamById(id);
        if (exam.isPresent()) {
            logger.info("Exam found with ID: {}", id);
            return ResponseEntity.ok(exam.get());
        } else {
            logger.warn("Exam not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Retrieves a list of all exams.
     *
     * @return a list of all exams
     */
    @GetMapping
    public List<Exam> getAllExams() {
        logger.info("Received request to list all exams");
        List<Exam> exams = examService.getAllExams();
        logger.info("Returning {} exams", exams.size());
        return exams;
    }

    /**
     * Updates an existing exam.
     *
     * @param id the ID of the exam to update
     * @param examDetails the updated exam details
     * @return ResponseEntity containing the updated exam or a 404 Not Found status if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam examDetails) {
        logger.info("Received request to update exam with ID: {}", id);
        Exam updatedExam = examService.updateExam(id, examDetails);
        if (updatedExam != null) {
            logger.info("Exam updated successfully with ID: {}", id);
            return ResponseEntity.ok(updatedExam);
        } else {
            logger.warn("Failed to update exam. Exam not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieves a list of exams by faculty.
     *
     * @param faculty the faculty name to filter exams by
     * @return a list of exams belonging to the specified faculty
     */
    @GetMapping("/faculty/{faculty}")
    public List<Exam> getExamsByFaculty(@PathVariable String faculty) {
        logger.info("Received request to get exams for faculty: {}", faculty);
        List<Exam> exams = examService.getExamsByFaculty(faculty);
        logger.info("Returning {} exams for faculty: {}", exams.size(), faculty);
        return exams;
    }

    /**
     * Retrieves a list of exams by faculty.
     *
     * @param moduleName the faculty name to filter exams by
     * @return a list of exams belonging to the specified module name
     */
    @GetMapping("/moduleName/{moduleName}")
    public List<Exam> getExamsByModuleName(@PathVariable String moduleName) {
        return examService.getExamsByModule(moduleName);
    }

    /**
     * Retrieves a list of exams by title.
     * @param title the faculty name to filter exams by
     * @return a list of exams belonging to the specified title
     */
    @GetMapping("/title/{title}")
    public List<Exam> getExamsByTitle(@PathVariable String title) {
        logger.info("Received request to get exams for module name: {}", title);
        List<Exam> exams = examService.getExamsByTitle(title);
        logger.info("Returning {} exams for module name: {}", exams.size(), title);
        return exams;
    }


    /**
     * Deletes an exam by its ID.
     *
     * @param id the ID of the exam to delete
     * @return ResponseEntity with no content if the deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        logger.info("Received request to delete exam with ID: {}", id);
        examService.deleteExam(id);
        logger.info("Exam deleted successfully with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}