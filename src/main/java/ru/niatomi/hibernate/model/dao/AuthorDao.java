package ru.niatomi.hibernate.model.dao;

import ru.niatomi.hibernate.model.persistence.Author;

import java.util.List;

/**
 * @author niatomi
 */
public interface AuthorDao extends GenericDao<Author, Long> {

    List<Author> getAuthorsWithArticlesHigherThan(Long countOfArticles);

}
