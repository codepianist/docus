/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codepianist.orderws.model;

import com.codepianist.orderws.model.impl.Order;
import com.codepianist.orderws.model.impl.OrderItem;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author cesar
 */
@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({Order.class, OrderItem.class})
@MappedSuperclass
public abstract class Persistent implements Serializable{
    
    @XmlElement(required= true, nillable= false)
    @Id @GeneratedValue
    protected long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    
}
