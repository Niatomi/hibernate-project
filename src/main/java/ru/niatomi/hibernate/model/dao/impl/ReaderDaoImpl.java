package ru.niatomi.hibernate.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.niatomi.hibernate.model.dao.ReaderDao;
import ru.niatomi.hibernate.model.exceptions.NotFoundException;
import ru.niatomi.hibernate.model.persistence.Reader;
import ru.niatomi.hibernate.util.SessionUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
public class ReaderDaoImpl implements ReaderDao {
    @Override
    public Optional<Reader> findById(Long key) {
        try (Session session = SessionUtil.createSession()) {
            return Optional
                    .of(session
                            .createNativeQuery("select * from " + Reader.READER_TABLE_NAME +
                                    " where id = ?2", Reader.class)
                            .setParameter(2, key)
                            .getSingleResult());
        }
    }

    @Override
    public List<Reader> findAll() {
        try (Session session = SessionUtil.createSession()) {
            return session.createNativeQuery("select * from " + Reader.READER_TABLE_NAME, Reader.class)
                    .getResultList();
        }
    }

    @Override
    public Reader save(Reader reader) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();

            session.createNativeQuery("insert into " + Reader.READER_TABLE_NAME +
                            " values((select count(*) + 1 from " + Reader.READER_TABLE_NAME +
                            "), ?3, ?4, ?5)")
                    .setParameter(3, reader.getFirstName())
                    .setParameter(4, reader.getMail())
                    .setParameter(5, reader.getSecondName())
                    .executeUpdate();

            transaction.commit();
            return reader;
        }
    }

    @Override
    public Optional<Reader> update(Long key, Reader reader) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();

            session.createNativeQuery("update " + Reader.READER_TABLE_NAME +
                            " set " +
                            Reader.READER_TABLE_FIRST_NAME + " = ?1, " +
                            Reader.READER_TABLE_MAIL + " = ?2, " +
                            Reader.READER_TABLE_SECOND_NAME + " = ?3 " +
                            "where id=?4")
                    .setParameter(1, reader.getFirstName())
                    .setParameter(2, reader.getMail())
                    .setParameter(3, reader.getSecondName())
                    .setParameter(4, key)
                    .executeUpdate();

            transaction.commit();
            return Optional.of(reader);
        }
    }

    @Override
    public Optional<Reader> deleteById(Long key) {
        try (Session session = SessionUtil.createSession()) {
            Transaction transaction = session.beginTransaction();

            Optional<Reader> byId = findById(key);
            if (!byId.isPresent()) {
                transaction.rollback();
                throw new NotFoundException();
            }

            session.createNativeQuery("delete from " + Reader.READER_TABLE_NAME +
                            " where id=?1")
                    .setParameter(1, key)
                    .executeUpdate();

            transaction.commit();

            return byId;
        }
    }
}
