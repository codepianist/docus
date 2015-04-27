/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.dao.impl;

import com.codepianist.pizzapp.dao.ProductDao;
import com.codepianist.pizzapp.model.impl.Beverage;
import javax.ejb.Stateless;

/**
 *
 * @author cesar
 */
@Stateless
public class BeverageDao extends ProductDao<Beverage>{

    public BeverageDao() {
        super(Beverage.class);
    }
    
}
