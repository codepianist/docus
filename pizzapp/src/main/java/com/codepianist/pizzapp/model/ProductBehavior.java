/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.model;

/**
 *
 * @author cesar
 * @param <T>
 */
public interface ProductBehavior<T extends Product> {
    
    public void buildName(String name);
    public void calculatePrice(double price);
    
}
