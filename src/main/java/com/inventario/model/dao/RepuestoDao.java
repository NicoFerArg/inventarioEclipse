package com.inventario.model.dao;

import com.inventario.entities.Repuesto;
import java.util.List;

public interface RepuestoDao {
    
    
    public List<Repuesto> listPart();
    public void createPart(Repuesto p);
    public void deletePart(Repuesto p);
    public List<Repuesto> listByBrand(int id_brand);
   
}
