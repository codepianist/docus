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
@DiscriminatorValue("PizzaFlavor")
public class PizzaFlavor extends Product {

    //
    public PizzaFlavor(){
        super();
    }
    public PizzaFlavor(String name, String descr, double price) {
        super(name, descr, price);
    }
    
    
    
    //
    
    @Override
    public String toString() {
        return "PizzaFlavor["
                    +"name= "+name+", "
                    +"descr= "+descr+", "
                    +"price= "+price
                +']';
    }
    
    @Override
    public boolean equals(Object o){
        return o instanceof PizzaFlavor 
            && ((PizzaFlavor)o).name.equals(this.name)
            && ((PizzaFlavor)o).descr.equals(this.descr)
            && ((PizzaFlavor)o).price==this.price;
    }

    @Override
    public int hashCode() {
        int hash = (int)price * 11;
        return hash;
    }
    
    
}
