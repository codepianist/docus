/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.dao.impl;

import javax.ejb.Stateless;

import com.codepianist.orderws.dao.AbstractDao;
import com.codepianist.orderws.model.impl.OrderItem;

/**
 *
 * @author cesar
 */
@Stateless
public class OrderItemDao extends AbstractDao<OrderItem>{
    
	//
	
	private static final long serialVersionUID = 1L;
	
	
	
	//
	
    public OrderItemDao() {
        super(OrderItem.class);
    }
    
}
