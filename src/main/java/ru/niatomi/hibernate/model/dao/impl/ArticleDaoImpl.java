package ru.niatomi.hibernate.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.niatomi.hibernate.model.dao.ArticleDao;
import ru.niatomi.hibernate.model.exceptions.NotFoundException;
import ru.niatomi.hibernate.model.persistence.Article;
import ru.niatomi.hibernate.model.persistence.Author;
import ru.niatomi.hibernate.util.SessionUtil;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 * @implNote  all methods implemented via JPQL
 */
public class ArticleDaoImpl implements ArticleDao {
    @Override
    public Optional<Article> findById(Long key) {
        try (Session session = SessionUtil.createSession()) {
            return Optional
                    .of(session.createQuery("from Article a where a.id = ?1", Article.class)
                            .setParameter(1, key)
                            .getSingleResult());
        } catch (NoResultException exception) {
            return Optional.of(new Article());
        }
    }

    @Override
    public List<Article> findAll() {
        try (Session session = SessionUtil.createSession()) {
            return session.createQuery("from Article", Article.class).getResultList();
        } catch (NoResultException exception) {
            return new ArrayList<>();
        }
    }

    @Override
    public Article save(Article article) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(article);
            transaction.commit();
            return article;
        }
    }

    @Override
    public Optional<Article> update(Long key, Article article) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();
            article.setId(key);
            session.update(article);
            transaction.commit();
            return Optional.of(article);
        }
    }

    @Override
    public Optional<Article> deleteById(Long key) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();
            Optional<Article> byId = findById(key);
            if (!byId.isPresent()) {
                transaction.rollback();
                throw new NotFoundException();
            }

            session.delete(byId.get());
            transaction.commit();

            return byId;
        }
    }

    @Override
    public List<Article> getArticlesByStartsSecondNameOfAuthor(String secondName) {
        try (Session session = SessionUtil.createSession()) {
            return session
                    .createQuery("select a from Article a where a.author.secondName like ?1", Article.class)
                    .setParameter(1, secondName)
                    .getResultList();
        }

    }
}
