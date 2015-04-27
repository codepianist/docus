/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist;

import javax.xml.ws.WebFault;

/**
 *
 * @author cesar
 */
@WebFault(name="NotAuthorizedException")
public class NotAuthorizedException extends Exception{
    
    private static final long serialVersionUID = 1L;
    private static final String PREFIX=  "User not authorized: ";

    
    public NotAuthorizedException() { }

    public NotAuthorizedException(String message, Throwable cause) {
        super(PREFIX+message , cause);
    }

    public NotAuthorizedException(String message) {
        super(PREFIX+message);
    }

    public NotAuthorizedException(Throwable cause) {
        super(cause);
    }
    
    public NotAuthorizedException(String message,
        Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression,
        writableStackTrace);
    }
    
}
