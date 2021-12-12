package ru.niatomi.hibernate.model.dao.impl;

import jdk.nashorn.internal.runtime.options.Option;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.niatomi.hibernate.model.dao.StudentDao;
import ru.niatomi.hibernate.model.persistence.Student;
import ru.niatomi.hibernate.util.SessionUtil;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    @Override
    public Optional<Student> findById(Long id) {
        Session session = SessionUtil.createSession();
        Optional<Student> student = session
                .createQuery("from Student u where u.id = " + id, Student.class)
                .uniqueResultOptional();
        session.close();
        return student;
    }

    @Override
    public List<Student> findAll() {
        Session session = SessionUtil.createSession();
        List<Student> student = session.createQuery("from Student", Student.class)
                .getResultList();
        session.close();
        return student;
    }

    @Override
    public Student save(Student student) {
        System.out.println("Student before save = " + student);
        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.save(student.getAddress());
        session.save(student);


        transaction.commit();
        session.close();
        System.out.println("Student after save = " + student);

        return student;
    }

    @Override
    public Optional<Student> update(Long id, Student student) {
        Optional<Student> byId = findById(id);
        if (!byId.isPresent()) {
            System.out.println("Student with ID = " + id + " does not exists");
            return byId;
        }

        System.out.println("Student before update = " + student);
        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        System.out.println("Student after update = " + student);

        return Optional.of(student);
    }

    @Override
    public Optional<Student> deleteById(Long id) {
        Optional<Student> byId = findById(id);
        if (!byId.isPresent()) {
            System.out.println("Student with ID = " + id + " does not exists");
            return byId;
        }
        Student student = byId.get();


        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.delete(student);

        transaction.commit();
        session.close();


        return byId;
    }

    @Override
    public List<Student> findByStartsFirstName(String starts) {
        return null;
    }
}
