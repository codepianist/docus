/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.beans.impl;

import com.codepianist.pizzapp.beans.Bean;
import com.codepianist.pizzapp.dao.impl.BeverageDao;
import com.codepianist.pizzapp.model.impl.Beverage;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cesar
 */
@ManagedBean
@ViewScoped
public class BeverageBean extends Bean{
    
    
    //
    
	private static final long serialVersionUID = 1L;


	
	//
	
	@EJB
    private BeverageDao beverageDao;
    
    
    
    //
    
    private OrderBean orderBean;
    
    private List<Beverage> beverages;
    public List<Beverage> getBeverages() { return beverages; }
    
    private Beverage selBeverage;
    public Beverage getSelBeverage() { return selBeverage; }
    public void setSelBeverage(Beverage selBeverage) { this.selBeverage = selBeverage; }
    
    
    //
    
    @PostConstruct
    public void init(){
        System.out.println("IndexBean.init START...");
        orderBean= (OrderBean) FacesContext.getCurrentInstance()
                    .getExternalContext().getSessionMap().get("orderBean");
        try {
            beverages= beverageDao.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("IndexBean.init END.");
    }
    
    
    
    //
    
    public String addBeverage(){
        orderBean.add(selBeverage);
        return null;
    }
    
}
