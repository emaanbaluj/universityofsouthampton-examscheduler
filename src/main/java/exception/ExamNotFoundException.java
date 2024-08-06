package exception;

/**
 * Custom exception thrown when an exam is not found.
 */
public class ExamNotFoundException extends RuntimeException {

    /**
     * Constructs a new ExamNotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public ExamNotFoundException(String message) {
        super(message);
    }
}