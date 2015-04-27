/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.dao;

import com.codepianist.pizzapp.dao.impl.BeverageDao;
import com.codepianist.pizzapp.model.impl.Beverage;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cesar
 */
public class Test {
    
    public static void main(String[] args) throws Exception{
        //_2();
        _3();
        
    }
    
    private static void _1(){
        try {
            BeverageDao dao= new BeverageDao();
            for(Beverage b: dao.list())
                System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void _2(){
        List<Beverage> instances= Arrays.asList(
                new Beverage[]{
                    new Beverage("Coca-Cola Lata", "...", 5).setTest(true),
                    new Beverage("Guarana Lata", "...", 5).setTest(true),
                    new Beverage("Suco de Laranja", "...", 6).setTest(true),
                    new Beverage("Suco de Caju", "...", 6).setTest(true),
                    new Beverage("Cerveja Brahma Lata", "...", 7).setTest(true)
                });
        for(Beverage b: instances)
            System.out.println(b);
    }
    
    private static void _3(){
        try {
            BeverageDao dao= new BeverageDao();
            Beverage b= dao.getByQuery("from Beverage", "name", "Coca-Cola Lata");
            System.out.println("b= "+b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
