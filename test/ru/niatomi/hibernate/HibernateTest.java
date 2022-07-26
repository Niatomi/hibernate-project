package ru.niatomi.hibernate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.niatomi.hibernate.model.dao.impl.ArticleDaoImplTest;

/**
 * @author niatomi
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArticleDaoImplTest.class
})
public class HibernateTest {

    @BeforeClass
    public static void onStart() {
        deleteData();
        loadData();
    }

    @AfterClass
    public static void onEnd() {}

    private static void loadData() {
    }

    private static void deleteData() {
    }


}
