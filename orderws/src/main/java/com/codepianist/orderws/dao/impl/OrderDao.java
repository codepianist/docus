/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.dao.impl;

import com.codepianist.DatabaseException;
import com.codepianist.orderws.dao.AbstractDao;
import com.codepianist.orderws.model.impl.Order;
import com.codepianist.orderws.model.impl.OrderItem;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless; 

/**
 *
 * @author cesar
 */
@Stateless
public class OrderDao extends AbstractDao<Order>{
    
	//
	
	private static final long serialVersionUID = 1L;
	
	
	
	// 
	
	@EJB
    private OrderItemDao orderItemDao; //= new OrderItemDao();
    
    
    public OrderDao() {
        super(Order.class);
    }
    
    
    public void addOrderAndItems(Order order) 
        throws DatabaseException{
        
        add(order);
        int num= 1;
        for(OrderItem item: order.getItems()){
            item.setOrder(order);
            item.setNum(num);
            orderItemDao.add(item);
        }
        
    }
    
    
    public static void main(String[] args) throws Exception{
        System.out.println("Executando...");
        OrderDao dao= new OrderDao();
        
        /* 1 */
        System.out.println("Inserindo...");
        List<OrderItem> items= Arrays.asList(
                new OrderItem[]{
                    new OrderItem("Coca-Cola Lata",5),
                    new OrderItem("Misto Quente",8),
                    new OrderItem("Café",3.5)
                    });
        
        Order o1= new Order(items);
        dao.addOrderAndItems(o1);
        
        System.out.println("Listando...");
        for(Order o: dao.list()){
            System.out.println("Order: "+o);
            for(OrderItem i: o.getItems()){
                System.out.println(" > Item: "+i);
            }
        }
        
        /* 2 */
        System.out.println("Inserindo...");
        //List<OrderItem> 
        	items= Arrays.asList(
                new OrderItem[]{
                    new OrderItem("Guarana Lata",5),
                    new OrderItem("Baury",9),
                    new OrderItem("Café com Chantily",5.5)
                    });
        
        Order o2= new Order(items);
        dao.addOrderAndItems(o2);
        
        System.out.println("Listando...");
        for(Order o: dao.list()){
            System.out.println("Order: "+o);
            for(OrderItem i: o.getItems()){
                System.out.println(" > Item: "+i);
            }
        }

        System.out.println("Pronto.");
        
    }
    
}
