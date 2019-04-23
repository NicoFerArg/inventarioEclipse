package com.inventario.model.dao;

import com.inventario.entities.TipoMovimientos;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("tipomovimientosDao")
public class TipoMovimientosDaoImpl implements TipoMovimientosDao, Serializable {
    
    
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
    public List<TipoMovimientos> listTypeMove(){
    
        return getSession().createQuery("select t from TipoMovimientos t").list();
    }
}
