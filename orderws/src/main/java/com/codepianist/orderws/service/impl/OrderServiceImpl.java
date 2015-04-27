/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.service.impl;

import com.codepianist.orderws.dao.impl.OrderDao;
import com.codepianist.DatabaseException;
import com.codepianist.NotAuthorizedException;
import com.codepianist.orderws.model.impl.Order;
import com.codepianist.orderws.service.OrderService;


//import com.sun.xml.internal.ws.developer.SchemaValidation;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *	
 * @author cesar
 */
@WebService(
    endpointInterface= "com.codepianist.orderws.service.OrderService",
    serviceName="order-service")
//@SchemaValidation
public class OrderServiceImpl implements OrderService{
    
	@EJB
    private OrderDao orderDao;
    private static final String USER= "OK";
    
    @Override
    public void addOrder(Order order, String userName) 
            throws DatabaseException, NotAuthorizedException{
        if(USER.equals(userName))
            orderDao.add(order);
        else
            throw new NotAuthorizedException();
    }
    
    @WebResult(name="orders")
    @Override
    public List<Order> listOrders(String userName)
            throws DatabaseException, NotAuthorizedException{
        List<Order> res= null;
        if(USER.equals(userName))
            res= orderDao.list();
        else
            throw new NotAuthorizedException();
        return res;
    }
    
}
