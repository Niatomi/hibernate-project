package ru.niatomi.hibernate.model.dao.impl;

import ru.niatomi.hibernate.model.dao.AuthorDao;
import ru.niatomi.hibernate.model.persistence.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public List<Author> getAuthorsWithArticlesHigherThan(Long countOfArticles) {
        return null;
    }

    @Override
    public Optional<Author> findById(Long key) {
        return Optional.empty();
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public Optional<Author> update(Long key, Author author) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> deleteById(Long key) {
        return Optional.empty();
    }
}
