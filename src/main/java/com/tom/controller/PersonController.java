package com.tom.controller;


import com.tom.entities.Person;
import com.tom.hibernate.HibernateConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "person")
public class PersonController {

    @RequestMapping(value="{personId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable int personId){
        Configuration config;
        SessionFactory factory;
        Session session;

        config = HibernateConfig.getConfiguration();
        factory = config.buildSessionFactory();
        session = factory.openSession();

        Query query = session.createQuery("from Person person where person.personId=:id").setInteger("id", personId);
        Person person = (Person) query.uniqueResult();

        return person;
    }

    @RequestMapping(value="/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello!";
    }


}
