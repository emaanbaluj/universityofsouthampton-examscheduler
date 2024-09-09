package examscheduler.repository;

import examscheduler.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations and custom queries on the Exam entity.
 */
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    /**
     * Finds a list of exams where the faculty field contains the specified string (case-insensitive and partial match).
     *
     * @param faculty the partial or full faculty name to search for
     * @return a list of Exam entities that match the search term
     */
    @Query("SELECT e FROM Exam e WHERE LOWER(TRIM(e.faculty)) LIKE LOWER(CONCAT('%', :faculty, '%'))")
    List<Exam> findExamsByFacultyContaining(@Param("faculty") String faculty);

    /**
     * Finds a list of exams where the moduleName field contains the specified string (case-insensitive and partial match).
     *
     * @param moduleName the partial or full module name to search for
     * @return a list of Exam entities that match the search term
     */
    @Query("SELECT e FROM Exam e WHERE LOWER(TRIM(e.moduleName)) LIKE LOWER(CONCAT('%', :moduleName, '%'))")
    List<Exam> findExamsByModuleNameContaining(@Param("moduleName") String moduleName);

    /**
     * Finds a list of exams where the title field contains the specified string (case-insensitive and partial match).
     *
     * @param title the partial or full title to search for
     * @return a list of Exam entities that match the search term
     */
    @Query("SELECT e FROM Exam e WHERE LOWER(TRIM(e.title)) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Exam> findExamsByTitleContaining(@Param("title") String title);
}