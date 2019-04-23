package com.inventario.model.dao;

import com.inventario.entities.Repuesto;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("repuestoDao")
public class RepuestoDaoImpl implements RepuestoDao , Serializable {
   
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
    public List<Repuesto> listPart(){
    
        return getSession().createQuery("select b from Repuesto b order by b.id desc").list();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Repuesto> listByBrand(int id_brand){
     
        return getSession().createQuery("select p from Repuesto p where p.brands.id=:id_brand").setParameter("id_brand", id_brand).list();
    }
    
    @Override
    public void createPart(Repuesto p){
    
        getSession().save(p);
    
    }
    
    @Override
    public void deletePart(Repuesto p){
    
        getSession().delete(p);
    
    }
    
}
