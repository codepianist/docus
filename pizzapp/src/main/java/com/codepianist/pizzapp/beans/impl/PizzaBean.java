package com.codepianist.pizzapp.beans.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;

import com.codepianist.DatabaseException;
import com.codepianist.PizzaIllegalNumSlicesException;
import com.codepianist.pizzapp.beans.Bean;
import com.codepianist.pizzapp.dao.impl.PizzaFlavorDao;
import com.codepianist.pizzapp.model.impl.Pizza;
import com.codepianist.pizzapp.model.impl.PizzaFlavor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
@ManagedBean
@ViewScoped
public class PizzaBean extends Bean{
    
    //
    
    @EJB
    private PizzaFlavorDao pizzaFlavorDao;
    
    
    
    //
    
    private OrderBean orderBean;

    private List<PizzaFlavor> pizzaFlavors;
    public List<PizzaFlavor> getPizzaFlavors() { return pizzaFlavors; }
    
    private List<PizzaFlavor> selPizzaFlavors= new ArrayList();
    public List<PizzaFlavor> getSelPizzaFlavors() { return selPizzaFlavors; }
    
    private Pizza newPizza;
    public Pizza getNewPizza() { return newPizza; }
    
    
    
    
    //
    
    @PostConstruct
    public void init(){
        System.out.println("IndexBean.init START...");
        orderBean= (OrderBean) FacesContext.getCurrentInstance()
                    .getExternalContext().getSessionMap().get("orderBean");
        reset();
        System.out.println("IndexBean.init END.");
    }
   
    public void onPizzaFlvDrop(DragDropEvent ev) {
        PizzaFlavor pf= null;
        try {
            pf = ((PizzaFlavor) ev.getData());
            selPizzaFlavors.add(pf);
            newPizza= new Pizza(selPizzaFlavors);
            pizzaFlavors.remove(pf);
            
        } catch (PizzaIllegalNumSlicesException e) {
            selPizzaFlavors.remove(pf);
            FacesContext.getCurrentInstance().addMessage("msgForm:globalMsgs", 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ops!", "Um pizza precisa ter: No mínimo 1, e no máximo 4 sabores."));
            e.printStackTrace();
        } 
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("msgForm:globalMsgs", 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ops!", "Uma falha ocorreu."));
            e.printStackTrace();
        }

    }
    
    public String addPizza(){
        // FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("com.codepianist.pizzapp.PIZZA_TO_ADD", newPizza);
        orderBean.add(newPizza);
        reset();
        return null;
    }
    
    public String cancel(){
        reset();
        return null;
    }
    
    
    // 
   
    private void reset(){
        try {
            pizzaFlavors= pizzaFlavorDao.list();
            selPizzaFlavors= new ArrayList();
            newPizza= new Pizza();
            
        } catch (DatabaseException e) {
            FacesContext.getCurrentInstance().addMessage("globalMsgs", 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ops!", "Uma falha de comunicação com a base de dados ocorreu."));
            e.printStackTrace();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("globalMsgs", 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ops!", "Uma falha inesperada ocorreu."));
            e.printStackTrace();
        }
    }

}
