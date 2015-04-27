/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author cesar
 */
public class HibernateUtils implements Serializable {
    
    //
    
    private static HibernateUtils me;
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    
    
    //
    
    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
            config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);

    }

    
    
    //
    
    public static HibernateUtils getInstance() {
        if(me == null)
            me = new HibernateUtils();
        return me;
    }
    
    public Session getSession(){
        return sessionFactory.openSession();
    }
    
    public void closeSession(Session session){
        session.close();
    }
}
