package ru.niatomi.hibernate.model.dao.impl;

import org.junit.Test;
import ru.niatomi.hibernate.model.dao.StudentDao;
import ru.niatomi.hibernate.model.persistence.Student;

import java.util.Optional;

import static org.junit.Assert.*;
import static ru.niatomi.hibernate.model.dao.HibernateTest.STUDENT_1;


public class StudentDaoImplTest {
    private final StudentDaoImpl dao = new StudentDaoImpl();

    @Test
    public void findUserById() {
        Student expected = STUDENT_1;
        Optional<Student> actual = dao.findById(1L);

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }
}