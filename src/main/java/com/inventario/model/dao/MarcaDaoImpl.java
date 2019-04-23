/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.model.dao;

import com.inventario.entities.Marca;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author flobos
 */
@Repository("marcaDao")
public class MarcaDaoImpl implements MarcaDao, Serializable {
    
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
    public List<Marca> listBrand(){
    
        return getSession().createQuery("select b from Marca b order by b.id desc").list();
    
    }
    
    @Override
    public void createBrand(Marca b){
    
        getSession().save(b);
    
    }
    
    @Override
    public void deleteBrand(Marca b){
    
        getSession().delete(b);
    
    }
    
    
    
}
