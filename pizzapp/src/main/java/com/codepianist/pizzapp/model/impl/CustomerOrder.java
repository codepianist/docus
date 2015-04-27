/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.model.impl;

import com.codepianist.pizzapp.model.Product;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class CustomerOrder implements Serializable{
    
    private final List<Product> products= new LinkedList();
    public List<Product> getProducts() { return products; }
    
    private double total;
    public double getTotal() { return total; }
    
    
    
    //
    
    public void addProduct(Product product){
        products.add(product);
        calculateTotal();
    }
    
    public void removeProduct(Product product){
        products.remove(product);
        calculateTotal();
    }
    
    
    
    //
    
    private void calculateTotal(){
        total= 0;
        for(Product curr: products){
            total+= curr.getPrice();
        }
    }
    
}
