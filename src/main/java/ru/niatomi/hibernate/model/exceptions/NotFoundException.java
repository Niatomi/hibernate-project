package ru.niatomi.hibernate.model.exceptions;

/**
 * @author niatomi
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not found");
    }
}
