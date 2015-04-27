/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.model.impl;

import com.codepianist.pizzapp.model.Product;
import com.codepianist.pizzapp.model.ProductBehavior;
import com.codepianist.PizzaIllegalNumSlicesException;
import java.util.List;
import javax.persistence.Transient;

/**
 *
 * @author cesar
 */
public class Pizza extends Product{
    
    //
    
    @Transient
    private List<PizzaFlavor> flavors;
    public List<PizzaFlavor> getFlavors() { return flavors; } 

    private String ratio;
    public String getRatio() { return ratio; }
    
    
    //
    
    public Pizza(){
        behavior= new ProductBehavior() {
            @Override
            public void buildName(String _name){
                int parts= flavors!=null ? flavors.size() : 0;
                switch(parts){
                    case 1: 
                        ratio= "1";
                        name= nameHelper("1", flavors);
                        break;
                    case 2:
                        ratio= "1/2";
                        name= nameHelper("1/2", flavors);
                        break;
                    case 3:
                        ratio= "1/3";
                        name= nameHelper("1/3", flavors);
                        break;
                    case 4:
                        ratio= "1/4";
                        name= nameHelper("1/4", flavors);
                        break;
                    default: 
                        throw new PizzaIllegalNumSlicesException("Uma pizza pode ser dividida em no máximo 4 pedaços.");
                }
            }
            
            private String nameHelper(String ratio, List<PizzaFlavor> flavors){
                StringBuilder name;
                if("1".equals(ratio))
                    name= new StringBuilder("1 Pizza inteira de");
                else
                    name= new StringBuilder("1 Pizza:");
                
                int size= flavors.size(); 
                int counter= 1;
                for(PizzaFlavor pf: flavors){
                    if(!"1".equals(ratio))
                        name.append(ratio);
                    
                    name.append(" ")
                        .append(pf.getName());
                    if(counter==size)
                        name.append(".");
                    else
                        name.append(", ");
                    counter++;
                }
                return name.toString();
            }

            @Override
            public void calculatePrice(double _price) {
                double higher= 0;
                for(PizzaFlavor pf: flavors){
                    if(pf.getPrice() > higher)
                        higher= pf.getPrice();
                }
                price= higher;
            }
        };
    }
    public Pizza(final List<PizzaFlavor> flavors){
        this();
        this.flavors= flavors;
        behavior.buildName(null);
        behavior.calculatePrice(0);
    }
    
}
