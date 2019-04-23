package com.inventario.model.dao;

import com.inventario.entities.Cliente;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("clienteDao")
public class ClienteDaoImpl implements ClienteDao, Serializable {
    
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
    public List<Cliente> listClient(){
    
        return getSession().createQuery("select c from Cliente c").list();
    
    }
    
}
