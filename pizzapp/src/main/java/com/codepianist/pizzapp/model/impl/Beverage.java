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
@DiscriminatorValue("Beverage")
public class Beverage extends Product<Beverage> {

    public Beverage(){
        super();
    }
    public Beverage(String name, String descr, double price) {
        super(name, descr, price);
    }

    @Override
    public String toString() {
        return "Beverage["
                    +"name= "+name+", "
                    +"descr= "+descr+", "
                    +"price= "+price
                +']';
    }
    
    @Override
    public boolean equals(Object o){
        return o instanceof Beverage 
            && ((Beverage)o).name.equals(this.name)
            && ((Beverage)o).descr.equals(this.descr)
            && ((Beverage)o).price==this.price;
    }

    @Override
    public int hashCode() {
        int hash = (int)price * 5;
        return hash;
    }

}
