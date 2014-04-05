package com.tom.hibernate;

import com.tom.entities.Person;
import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Tom Mac
 * Date: 4/4/14
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateConfig {

    public static Configuration getConfiguration(){
        //configuring Hibernate
        Configuration config = new Configuration();
        config.setProperty("hibernate.dialect",
                "org.hibernate.dialect.SQLServerDialect");
        config.setProperty("hibernate.connection.driver_class",
                "net.sourceforge.jtds.jdbc.Driver");
        config.setProperty("hibernate.connection.url",
                "jdbc:jtds:sqlserver://localhost:1433/tomdb");
        config.setProperty("hibernate.connection.username", "sa");
        config.setProperty("hibernate.connection.password", "devserver");
        //introducing persistent classes to Hibernate
        config.addAnnotatedClass(Person.class);
        return config;
    }


}
