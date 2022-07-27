package ru.niatomi.hibernate.model.dao.impl;

import org.hibernate.Session;
import ru.niatomi.hibernate.model.dao.AuthorDao;
import ru.niatomi.hibernate.model.persistence.Author;
import ru.niatomi.hibernate.util.SessionUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 * @implNote finding methods implemented via Criteria API
 */
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public List<Author> getAuthorsWithArticlesHigherThan(Long countOfArticles) {
        try (Session session = SessionUtil.createSession()) {

        }
        return null;
    }

    @Override
    public Optional<Author> findById(Long key) {
        try (Session session = SessionUtil.createSession()) {

        }
        return Optional.empty();
    }

    @Override
    public List<Author> findAll() {
        try (Session session = SessionUtil.createSession()) {

        }
        return null;
    }

    @Override
    public Author save(Author author) {
        try (Session session = SessionUtil.createSession()) {

        }
        return null;
    }

    @Override
    public Optional<Author> update(Long key, Author author) {
        try (Session session = SessionUtil.createSession()) {

        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> deleteById(Long key) {
        try (Session session = SessionUtil.createSession()) {

        }
        return Optional.empty();
    }
}
