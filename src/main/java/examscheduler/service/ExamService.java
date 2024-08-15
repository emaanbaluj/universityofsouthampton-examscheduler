package examscheduler.service;

import examscheduler.model.Exam;
import examscheduler.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    // Create a new exam
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    // Get a specific exam by ID
    public Optional<Exam> getExamById(Long id) {
        return examRepository.findById(id);
    }

    // List all exams
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    // Update an existing exam
    public Exam updateExam(Long id, Exam examDetails) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if (optionalExam.isPresent()) {
            Exam exam = optionalExam.get();
            exam.setFaculty(examDetails.getFaculty());
            exam.setModuleName(examDetails.getModuleName());
            exam.setTitle(examDetails.getTitle());
            exam.setDate(examDetails.getDate());
            exam.setStartTime(examDetails.getStartTime());
            exam.setEndTime(examDetails.getEndTime());
            exam.setFormat(examDetails.getFormat());
            return examRepository.save(exam);
        }
        return null;
    }

    // Delete an exam
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}