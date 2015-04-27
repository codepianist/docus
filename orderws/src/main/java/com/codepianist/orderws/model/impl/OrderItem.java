/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.model.impl;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.codepianist.orderws.model.Persistent;

/**
 *
 * @author cesar
 */
@XmlAccessorType(XmlAccessType.NONE)
@Entity @Table(name="order_items")
public class OrderItem extends Persistent{
	
	//
	
	private static final long serialVersionUID = 1L;
	
	
	
	//
	
    @XmlElement
    private int num;
    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; }
	
    @XmlElement
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    @XmlElement
    private double price;
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName="id")
    private Order order;
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public OrderItem() { }
    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{id= "+id+", name=" + name + ", price=" + price + ", order=" + order + '}';
    }
    
    

}
