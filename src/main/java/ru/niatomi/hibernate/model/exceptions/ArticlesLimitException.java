package ru.niatomi.hibernate.model.exceptions;

/**
 * @author niatomi
 */
public class ArticlesLimitException extends RuntimeException{
    public ArticlesLimitException() {
        super("You can't have more than 10 articles");
    }
}
