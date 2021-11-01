package com.epam.task2.service;

/**
 * Class is used in exceptions in service layer
 * @author Kirill Ryabov
 */
public class ServiceException extends Exception {
    /**
     * Constrictor calls the parent construct
     */
    public ServiceException() {
        super();
    }

    /**
     * Constrictor calls the parent construct
     * @param message that will appear
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constrictor calls the parent construct
     * @param message that will appear
     * @param cause exception will appear
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constrictor calls the parent construct
     * @param cause exception will appear
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
