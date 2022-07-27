package ru.niatomi.hibernate.model.dao;

import ru.niatomi.hibernate.model.persistence.Article;
import ru.niatomi.hibernate.model.persistence.Reader;

/**
 * @author niatomi
 */
public interface ReaderDao extends GenericDao<Reader, Long>{

    boolean addArticle(Article article, Reader reader);

}
