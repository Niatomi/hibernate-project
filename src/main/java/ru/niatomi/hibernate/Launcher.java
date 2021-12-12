package ru.niatomi.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.niatomi.hibernate.model.persistence.Address;
import ru.niatomi.hibernate.model.persistence.Student;
import ru.niatomi.hibernate.util.SessionUtil;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {

        Launcher launcher = new Launcher();

        Student student = new Student();
        student.setFirstName("ya");
        student.setLastName("balbes");

        Address adress = new Address();
        adress.setName("kolotushkina 2");

//        student.setAdress(adress);
//        launcher.saveUser(student);


    }



}
