package com.epam.task2.dao;

/**
 * Class is used in exceptions in dao layer
 * @author Kirill Ryabov
 */
public class DAOException extends Exception {
    /**
     * Constrictor calls the parent construct
     */
    public DAOException() {
        super();
    }

    /**
     * Constrictor calls the parent construct
     * @param message that will appear
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constrictor calls the parent construct
     * @param message that will appear
     * @param cause exception will appear
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constrictor calls the parent construct
     * @param cause exception will appear
     */
    public DAOException(Throwable cause) {
        super(cause);
    }
}
