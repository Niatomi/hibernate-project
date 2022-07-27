package ru.niatomi.hibernate.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.niatomi.hibernate.model.dao.AuthorDao;
import ru.niatomi.hibernate.model.exceptions.NotFoundException;
import ru.niatomi.hibernate.model.persistence.Author;
import ru.niatomi.hibernate.util.SessionUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Author> builderQuery = builder.createQuery(Author.class);
            Root<Author> root = builderQuery.from(Author.class);

            builderQuery.select(root)
                    .where(builder.greaterThan(root.get("articles"), countOfArticles));

            return session.createQuery(builderQuery).getResultList();

        }
    }

    @Override
    public Optional<Author> findById(Long key) {
        try (Session session = SessionUtil.createSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Author> builderQuery = builder.createQuery(Author.class);
            Root<Author> root = builderQuery.from(Author.class);

            builderQuery.select(root)
                    .where(builder.equal(root.get("id"), key));

            return Optional.of(session.createQuery(builderQuery).getSingleResult());

        }
    }

    @Override
    public List<Author> findAll() {
        try (Session session = SessionUtil.createSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Author> builderQuery = builder.createQuery(Author.class);
            Root<Author> root = builderQuery.from(Author.class);

            builderQuery.select(root);

            return session.createQuery(builderQuery).getResultList();

        }
    }

    @Override
    public Author save(Author author) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
        return null;
    }

    @Override
    public Optional<Author> update(Long key, Author author) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();
            author.setId(key);
            session.update(author);
            transaction.commit();
            return Optional.of(author);
        }
    }

    @Override
    public Optional<Author> deleteById(Long key) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();
            Optional<Author> byId = findById(key);
            if (!byId.isPresent()) {
                throw new NotFoundException();
            }

            session.delete(byId.get());
            transaction.commit();
            return byId;
        }
    }
}
