package ru.niatomi.hibernate.model.dao;

import ru.niatomi.hibernate.model.persistence.Article;
import ru.niatomi.hibernate.model.persistence.Author;

import java.util.List;

/**
 * @author niatomi
 */
public interface ArticleDao extends GenericDao<Article, Long>{

    List<Author> getArticlesByStartsSecondNameOfAuthor(String secondName);

}
