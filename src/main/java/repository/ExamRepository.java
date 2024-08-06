package repository;

import model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    // Search by title - return List if multiple results are possible
    List<Exam> findByTitleContainingIgnoreCase(String title);

    // Search by faculty - return List if multiple results are possible
    List<Exam> findByFacultyContainingIgnoreCase(String faculty);

    // Search by module name - return List if multiple results are possible
    List<Exam> findByModuleNameContainingIgnoreCase(String moduleName);

    // Combined search with unique constraint, return Optional<Exam>
    Optional<Exam> findByFacultyAndModuleNameAndTitle(String faculty, String moduleName, String title);

    void deleteByFacultyAndModuleNameAndTitle(String faculty, String moduleName, String title);

}
