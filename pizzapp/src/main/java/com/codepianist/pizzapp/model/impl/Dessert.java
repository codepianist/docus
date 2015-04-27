/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.model.impl;

import com.codepianist.pizzapp.model.Product;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dessert")
public class Dessert extends Product {

    //
    public Dessert(){
        super();
    }
    public Dessert(String name, String descr, double price) {
        super(name, descr, price);
    }
    
    
    
    //
    
    @Override
    public String toString() {
        return "Dessert["
                    +"name= "+name+", "
                    +"descr= "+descr+", "
                    +"price= "+price
                +']';
    }
    
    @Override
    public boolean equals(Object o){
        return o instanceof Dessert 
            && ((Dessert)o).name.equals(this.name)
            && ((Dessert)o).descr.equals(this.descr)
            && ((Dessert)o).price==this.price;
    }

    @Override
    public int hashCode() {
        int hash = (int)price * 7;
        return hash;
    }
    
}
