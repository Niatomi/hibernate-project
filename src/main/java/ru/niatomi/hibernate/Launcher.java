package ru.niatomi.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.niatomi.hibernate.model.dao.StudentDao;
import ru.niatomi.hibernate.model.dao.impl.StudentDaoImpl;
import ru.niatomi.hibernate.model.persistence.Address;
import ru.niatomi.hibernate.model.persistence.Student;
import ru.niatomi.hibernate.util.SessionUtil;

import java.time.LocalDate;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        Address address = new Address();
        address.setAddress("Test address");

        Student student = new Student();
        student.setFirstName("a");
        student.setLastName("b");
        student.setAddress(address);
        student.setBirthday(LocalDate.of(1111, 11, 11));

        dao.save(student);
        System.out.println(student);


        System.out.println(dao.findById(1L));
    }

}
