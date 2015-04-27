/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist;

/**
 *
 * @author cesar
 */
public class PizzaIllegalNumSlicesException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    private static final String PREFIX= 
            "Only 1 to 4 Slices are allowed: ";
    
    public PizzaIllegalNumSlicesException() { }

    public PizzaIllegalNumSlicesException(String message, Throwable cause) {
        super(PREFIX+message, cause);
    }

    public PizzaIllegalNumSlicesException(String message) {
        super(PREFIX+message);
    }

    public PizzaIllegalNumSlicesException(Throwable cause) {
        super(cause);
    }

}
