/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codepianist.DatabaseException;
import com.codepianist.pizzapp.model.Product;

/**
 *
 * @author cesar
 */
public class ProductDao<T extends Product> implements Serializable{

    //
    
    protected static final long serialVersionUID = 1L;
    protected Class<T> entityClass;
    private final HibernateUtils hibernate = HibernateUtils.getInstance();
    
    
    
    //
    
    public ProductDao(Class<T> entityClass) {
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
    
    public T getById(Serializable id) throws DatabaseException {
        Session hibernateSession = null;
        T pojo = null;
        try {
            hibernateSession = hibernate.getSession();
            // Transaction transaction = hibernateSession.beginTransaction();
            pojo = (T) hibernateSession.get(entityClass, id);
            // transaction.commit();
        } catch (Exception e) { throw new DatabaseException(e.getLocalizedMessage()); }
        finally {
            hibernate.closeSession(hibernateSession);
        }
        return (T) pojo;
    }
    
    public T getByQuery(String queryStr, String attrName, Object attr) 
            throws DatabaseException {
        Session hibernateSession = null;
        T result = null;
        try {
            hibernateSession = hibernate.getSession();
            Query query;
            String q= queryStr+" x where x."+attrName+" = :"+attrName;
            System.out.println("q= "+q);
            if(attrName!=null && attr!=null){
                query = hibernateSession.createQuery(queryStr+" x where x."+attrName+" = :"+attrName)
                    .setParameter(attrName, attr);
            } else {
                query = hibernateSession.createQuery(queryStr)
                    .setParameter(attrName, attr);
            }
            result = (T) query.uniqueResult();

        } catch (Exception e) { throw new DatabaseException(e.getLocalizedMessage()); }
        finally {
            hibernate.closeSession(hibernateSession);
        }
        return result;
    }
    
    public void remove(T pojo) throws DatabaseException {
        Session hibernateSession = null;

        try {
            hibernateSession = hibernate.getSession();
            Transaction transaction = hibernateSession.beginTransaction();
            hibernateSession.delete(pojo);
            if (!transaction.wasCommitted()) {
                transaction.commit();
            }
        } catch (Exception e) { throw new DatabaseException(e.getLocalizedMessage()); }
        finally {
            hibernate.closeSession(hibernateSession);
        }
    }
    
    public void removeTestInstances() throws DatabaseException {
        Session hibernateSession = null;

        try {
            hibernateSession = hibernate.getSession();
            hibernateSession.createQuery("delete from "+entityClass.getName()+" where test= 1").executeUpdate();

        } catch (Exception e) { throw new DatabaseException(e.getLocalizedMessage()); }
        finally {
            hibernate.closeSession(hibernateSession);
        }
    }  
    
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
