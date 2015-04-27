/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author cesar
 * @param <T>
 */
@Entity @Table(name="products")
@Inheritance (strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name="product_type")
public abstract class Product<T extends Product> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Transient
    private Class<T> clazz;
    
    @Transient
    protected ProductBehavior behavior= new ProductBehavior() {
        @Override
        public void buildName(String _name) {
            name= _name;
        }

        @Override
        public void calculatePrice(double _price) {
            price= _price;
        }
    };
    
    @Id @GeneratedValue
    protected long id;
    public long getId() { return id; }
    
    protected boolean test;
    public boolean isTest() { return test; }
    public T setTest(boolean test){
        this.test= test;
        return clazz.cast(this);
    }
    
    protected String name;
    public String getName() { return name;  }
 
    protected double price;
    public double getPrice() { return price; }

    protected String descr;
    public String getDescr() { return descr; }
    
    
    
    //
    
    protected Product(){
        this.clazz= (Class<T>)getClass();
    }
    protected Product(String name, String descr, double price) {
        this();
        behavior.buildName(name);
        behavior.calculatePrice(price);
        this.descr= descr;
    }

}
