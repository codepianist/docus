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
public class DatabaseException extends Exception{
    
    private static final long serialVersionUID = 1L;
    private static final String PREFIX= 
            "There was a problem with the communication with the Database (";

    private static final String SUFIX= 
            "). Please inform the System Administrator. ";
    
    public DatabaseException() { }

    public DatabaseException(String message, Throwable cause) {
        super(PREFIX+message+SUFIX, cause);
    }

    public DatabaseException(String message) {
        super(PREFIX+message+SUFIX);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
    
}
