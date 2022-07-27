package ru.niatomi.hibernate.model.dao.impl;

import ru.niatomi.hibernate.model.dao.ArticleDao;
import ru.niatomi.hibernate.model.persistence.Article;
import ru.niatomi.hibernate.model.persistence.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
public class ArticleDaoImpl implements ArticleDao {
    @Override
    public Optional<Article> findById(Long key) {
        return Optional.empty();
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    public Optional<Article> update(Long key, Article article) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> deleteById(Long key) {
        return Optional.empty();
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
