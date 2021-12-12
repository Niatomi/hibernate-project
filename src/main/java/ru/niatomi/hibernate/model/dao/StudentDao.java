package ru.niatomi.hibernate.model.dao;

import ru.niatomi.hibernate.model.persistence.Student;

import java.util.List;

public interface StudentDao extends GenericDao<Student, Long>{
    List<Student> findByStartsFirstName(String starts);
}
