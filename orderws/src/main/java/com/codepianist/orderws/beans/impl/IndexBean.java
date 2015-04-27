package com.codepianist.orderws.beans.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.codepianist.orderws.beans.Bean;
import com.codepianist.orderws.dao.impl.OrderDao;
import com.codepianist.orderws.model.impl.Order;

@ManagedBean
@ViewScoped
public class IndexBean extends Bean{

    //
    
	private static final long serialVersionUID = 1L;
	
	
	
	//
	
	@EJB
	private OrderDao orderDao;	
	
	
	@PostConstruct
	public void init(){
		try {
			this.orders= orderDao.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//
	
	private List<Order> orders;
	public List<Order> getOrders() { return orders; }
	public void setOrders(List<Order> orders) { this.orders = orders; }
	
	
	
		
	
}
