package repository;

import model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PastExamRepository extends JpaRepository<Exam, String> { // Assuming Exam uses Long as ID

    // Find by faculty, module name, or title (OR logic)
    Optional<Exam> findFirstByFacultyOrModuleNameOrTitle(String faculty, String moduleName, String title);

    // Find by faculty, module name, and title (AND logic)
    Optional<Exam> findByExactFacultyModuleNameAndTitle(String faculty, String moduleName, String title);

    // Flexible search with partial matches and case-insensitivity
    List<Exam> findByPartialMatchInFacultyModuleOrTitle(String faculty, String moduleName, String title);
}