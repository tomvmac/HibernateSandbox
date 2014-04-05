package persist;

import com.tom.entities.Person;
import com.tom.hibernate.HibernateConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Tom Mac
 * Date: 4/4/14
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonPersistTest {

    Configuration config;
    SessionFactory factory;
    Session session;

    @Before
    public void setup(){
        config = HibernateConfig.getConfiguration();
        factory = config.buildSessionFactory();
        session = factory.openSession();

    }

    @After
    public void tearDown(){
        session.close();
    }

    @Test
    public void getPerson(){
        Query query = session.createQuery("from Person person where person.personId=:id").setInteger("id", 1);
        Person person = (Person) query.uniqueResult();
        Assert.assertEquals(person.getAge(), 38);
    }


    @Test
    public void addPerson(){
        Transaction tx = session.beginTransaction();
        Person student = new Person("Brenda", "Yung", 38);
        session.save(student);
        tx.commit();
    }


}
