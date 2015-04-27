/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.beans.impl;

import com.codepianist.pizzapp.beans.Bean;
import com.codepianist.pizzapp.dao.impl.DessertDao;
import com.codepianist.pizzapp.model.impl.Dessert;
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
public class DessertBean extends Bean{
    
    //
    
    @EJB
    private DessertDao dessertDao;
    
    
    
    //
    
    private OrderBean orderBean;
    
    private List<Dessert> desserts;
    public List<Dessert> getDesserts() { return desserts; }
    
    private Dessert selDessert;
    public Dessert getSelDessert() { return selDessert; }
    public void setSelDessert(Dessert selDessert) { this.selDessert = selDessert; }
    
    
    
    
    //

	@PostConstruct
    public void init(){
        System.out.println("IndexBean.init START...");
        orderBean= (OrderBean) FacesContext.getCurrentInstance()
                    .getExternalContext().getSessionMap().get("orderBean");
        try {
            desserts= dessertDao.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("IndexBean.init END.");
    }
    
    
    
    //
    
    public String addDessert(){
        orderBean.add(selDessert);
        return null;
    }
}
