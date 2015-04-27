/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.beans.impl;

import com.codepianist.pizzapp.beans.Bean;
import com.codepianist.pizzapp.model.Product;
import com.codepianist.pizzapp.model.impl.CustomerOrder;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cesar
 */
@ManagedBean(eager = true)
@SessionScoped
public class OrderBean extends Bean{
    
    //
    
    private CustomerOrder order;
    public CustomerOrder getOrder() { return order; }
    public void setOrder(CustomerOrder order) { this.order = order; }
    
    
    
    //
    
    @PostConstruct
    public void init(){
        order= new CustomerOrder();
        System.out.println("Criando order");
    }
    
    
    

    

    
    //
    
    public String closeOrder(){
        // send to WS
        return null;
    }
    
    public String cancel(){
        order= new CustomerOrder();
        return null;
    }
    
    
    
    //
    
    public void add(Product product){
        order.addProduct(product);
    }
    
    public void remove(Product product){
        order.removeProduct(product);
    }
    
}
