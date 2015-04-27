/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.service;

import com.codepianist.DatabaseException;
import com.codepianist.NotAuthorizedException;
import com.codepianist.orderws.model.impl.Order;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author cesar
 */
@WebService
public interface OrderService {
    
    @WebMethod
    public void addOrder (
            @WebParam(name="order")Order order, 
            @WebParam(name="user", header= true)String user) 
            throws DatabaseException, NotAuthorizedException;
    
    @WebMethod
    @WebResult(name="order")
    public List<Order> listOrders(
            @WebParam(name="user", header= true) String user) 
            throws DatabaseException, NotAuthorizedException;
    
}
