package ru.niatomi.hibernate.model.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.niatomi.hibernate.model.dao.impl.StudentDaoImpl;
import ru.niatomi.hibernate.model.dao.impl.StudentDaoImplTest;
import ru.niatomi.hibernate.model.persistence.Address;
import ru.niatomi.hibernate.model.persistence.Student;

import java.time.LocalDate;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentDaoImplTest.class
})
public class HibernateTest {
    private final static StudentDao STUDENT_DAO = new StudentDaoImpl();

    public static final Address ADDRESS_1 = new Address();
    public static final Student STUDENT_1 = new Student();

    @BeforeClass
    public static void onStart() {
        deleteData();
        loadData();
    }

    @AfterClass
    public static void onEnd() {
        deleteData();
    }

    public static void deleteData() {
        STUDENT_DAO.findAll()
                .forEach(stud -> STUDENT_DAO.deleteById(stud.getId()));
    }

    public static void loadData() {
        ADDRESS_1.setAddress("Test address");

        STUDENT_1.setAddress(ADDRESS_1);
        STUDENT_1.setFirstName("Ivan");
        STUDENT_1.setLastName("Ivanov");
        STUDENT_1.setBirthday(LocalDate.of(1999, 1, 1));

        STUDENT_DAO.save(STUDENT_1);
    }

}
