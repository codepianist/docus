/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.model.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.codepianist.orderws.model.Persistent;

/**
 *
 * @author cesar
 */
@XmlAccessorType(XmlAccessType.NONE)
@Entity @Table(name="orders")
public class Order extends Persistent{
    
	//
	
	private static final long serialVersionUID = 1L;
	
	
	
	//
	
	/*
	@XmlElement(name="order-date")
    @Column(name= "order_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private final Calendar orderDate;
    public Calendar getOrderDate() {  return orderDate; }
    */

    
    @XmlElementWrapper(name="items")
    @XmlElement(name="item")
    @OneToMany(mappedBy="order", fetch = FetchType.EAGER)
    private List<OrderItem> items;
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) {
        this.items = items;
        doCalculations(items);
    }

    
    @XmlElement
    private double total;
    public double getTotal() { return total; }
    public String getTotalAsStr() { 
    	NumberFormat formatter = DecimalFormat.getCurrencyInstance(new Locale("pt","BR"));
    	formatter.setMaximumFractionDigits(2);
    	return formatter.format(total);

    }
    
    private void doCalculations(List<OrderItem> items){
        this.total= 0;
        this.noItems= 0;
        for(OrderItem curr: items){
        	this.total+= curr.getPrice();
        	this.noItems++;
        }
    }
    
    @XmlElement
    private int noItems;
    public int getNoItems() { return noItems; }
    

    public Order(){ 
        //this.orderDate= new GregorianCalendar();
    }
    public Order(List<OrderItem> items) {
        this();
        this.items = items;
        doCalculations(items);
    }

    @Override
    public String toString() {
        return "Order{id= " + id +", qt. items=" + (items!=null ? items.size() : 0) + ", total=" + total + '}';
    }
    
    
    
}
