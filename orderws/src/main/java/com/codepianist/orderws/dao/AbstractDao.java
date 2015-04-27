/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.dao;

import com.codepianist.DatabaseException;
import com.codepianist.orderws.model.Persistent;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cesar
 * @param <T>
 */
public abstract class AbstractDao<T extends Persistent> implements Serializable{

    //
    
    protected static final long serialVersionUID = 1L;
    protected Class<T> entityClass;
    private final HibernateUtils hibernate = HibernateUtils.getInstance();
    
    
    
    //
    
    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    
    
    //
    
    public long add(T entity) throws DatabaseException{
        
        Session hibernateSession = null;
        long id = -1;
        try {
            hibernateSession = hibernate.getSession();
            Transaction transaction = hibernateSession.beginTransaction();
            hibernateSession.persist(entity);
            id= entity.getId();
            
            if (!transaction.wasCommitted()) 
                transaction.commit();

        } catch (Exception e) { throw new DatabaseException(e.getLocalizedMessage()); }
        finally {
            hibernate.closeSession(hibernateSession);
        }
        return id;
    }
    public void addAll(Collection<T> entities) throws DatabaseException {
        for(T entity : entities){
            add(entity);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<T> list() throws DatabaseException {
        Session hibernateSession = null;
        List<T> pojos = null;
        try {
            hibernateSession = hibernate.getSession();
            
            Query query = hibernateSession.createQuery("from " + entityClass.getName());
            pojos = (List<T>) query.list();
            
        } catch (Exception e) { throw new DatabaseException(e.getLocalizedMessage()); }
        finally {
            hibernate.closeSession(hibernateSession);
        }
        return (List<T>) pojos;
    }   
    
}
