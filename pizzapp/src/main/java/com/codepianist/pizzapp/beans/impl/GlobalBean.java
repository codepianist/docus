/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.beans.impl;

import com.codepianist.pizzapp.beans.Bean;
import com.codepianist.pizzapp.service.impl.StartService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author cesar
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class GlobalBean extends Bean{
    
    @EJB
    private StartService startService;
    
    @PostConstruct
    public void init(){
        startService.start();
    }
    
}
