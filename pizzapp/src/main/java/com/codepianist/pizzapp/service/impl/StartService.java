/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.pizzapp.service.impl;

import com.codepianist.pizzapp.dao.impl.BeverageDao;
import com.codepianist.pizzapp.dao.impl.DessertDao;
import com.codepianist.pizzapp.dao.impl.PizzaFlavorDao;
import com.codepianist.pizzapp.model.impl.Beverage;
import com.codepianist.pizzapp.model.impl.Dessert;
import com.codepianist.pizzapp.model.impl.PizzaFlavor;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cesar
 */
@Stateless
public class StartService {
    
    @EJB
    private BeverageDao beverageDao;
    
    @EJB
    private DessertDao dessertDao;
    
    @EJB
    private PizzaFlavorDao pizzaFlavorDao;
    
    
    public void start(){
        try {
            List<Beverage> test1= beverageDao.list();
            if(test1==null || test1.isEmpty()){
                List<Beverage> bevs= Arrays.asList(
                    new Beverage[]{
                        new Beverage("Coca-Cola Lata","...", 5.0),
                        new Beverage("Pepsi Lata","...", 5.0),
                        new Beverage("Guarana Antartica Lata","...", 5.0),
                        new Beverage("Suco de Laranja","...", 6.0),
                        new Beverage("Suco de Limão","...", 6.0),
                        new Beverage("Cerveja Skol Lata","...", 7.0),
                        new Beverage("Cerveja Brahma Lata","...", 7.0)
                    }
                );
                beverageDao.addAll(bevs);
            }
            List<Dessert> test2= dessertDao.list();
            if(test2==null || test2.isEmpty()){
                List<Dessert> dess= Arrays.asList(
                    new Dessert[]{
                        new Dessert("Pudim de Leite","...", 8),
                        new Dessert("Mousse de Maracuja","...", 9.0),
                        new Dessert("Mousse de Chocolate","...", 9.0),
                        new Dessert("Creme Papaia com Licor de Cassis","...", 11.0),
                        new Dessert("Sorvete de Chocolate","...", 7.5),
                        new Dessert("Sorvete de Pistache","...", 7.5),
                        new Dessert("Sorvete Banana Split","...", 10.5),
                    }
                );
                dessertDao.addAll(dess);
            }
            List<PizzaFlavor> test3= pizzaFlavorDao.list();
            if(test3==null || test3.isEmpty()){
                List<PizzaFlavor> pizz= Arrays.asList(
                    new PizzaFlavor[]{
                        new PizzaFlavor("Calabresa","Molho, Calabreza fatiada, Cebolas em rodelas e Azeitonas.", 32),
                        new PizzaFlavor("Napolitana","Molho, Mussarela, Parmesão, Rodelas de tomate e Azeitonas.", 35),
                        new PizzaFlavor("Frango com Catupiry","Molho, Frango, Catupiry e Azeitonas.", 35),
                        new PizzaFlavor("Portuguesa","Molho, Presunto, Ovos cozidos, Cebola em rodelas e Azeitonas.", 34),
                        new PizzaFlavor("Palmito","Molho, Mussarela, Palmito, Bacon e Azeitonas.",37),
                        new PizzaFlavor("Brócolis","Molho, Mussarela, Brócolis, Bacon, Catupiry e Azeitonas.", 36),
                        new PizzaFlavor("Lombo Canadense","Molho, Mussarela, Lombo, Tomate, Alicci, Parmesão e Azeitonas.", 37)
                    }
                );
                pizzaFlavorDao.addAll(pizz);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
            
    
}
