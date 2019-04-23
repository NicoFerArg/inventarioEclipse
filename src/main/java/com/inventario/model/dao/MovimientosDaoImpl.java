/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.model.dao;

import com.inventario.entities.Movimientos;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("movimientosDao")
public class MovimientosDaoImpl implements MovimientosDao, Serializable {

    private static final long serialVersionUID = 1L;
   
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Session getSession(){
    
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Movimientos> listMove(){
    
        return getSession().createQuery("select m from Movimientos m order by m.id desc").list();
    
    }
    
    @Override
    public void createMove(Movimientos m){
    
        getSession().save(m);
    
    }
    
    @Override
    public void deleteMove(Movimientos m){
    
        getSession().delete(m);
    
    }
    
    
    
    
}
